package edu.ubt.testimi.service;

import edu.ubt.testimi.data.ShportaProductDTO;
import edu.ubt.testimi.data.ShportaProductViewDTO;
import edu.ubt.testimi.entity.Product;
import edu.ubt.testimi.entity.ShportaProduct;
import edu.ubt.testimi.repository.ProductRepository;
import edu.ubt.testimi.repository.ShportaProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShportaProductService {

    @Autowired
    ShportaProductRepository shportaProductRepository;

    @Autowired
    ProductRepository productRepository;

    public Boolean create(ShportaProductDTO shportaProductDTO){
        Boolean result = false;
        try {
            Product product = productRepository.getOne(shportaProductDTO.getProduct_id());
            Boolean checkShportaProductExist = shportaProductRepository.existsByProduct(product);
            if (!checkShportaProductExist && product.getSasia() > 0){
                    ShportaProduct shportaProduct = new ShportaProduct();
                    shportaProduct.setProduct(product);
                    shportaProduct.setSasia(1);
                    shportaProduct.setCmimiTotal(product.getCmimi() * shportaProductDTO.getSasia());
                    shportaProduct.setCmimiProduktit(product.getCmimi());
                    product.setSasia(product.getSasia() - 1);
                    shportaProductRepository.save(shportaProduct);
                    result = true;
            }else {
                return false;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    public List<ShportaProductViewDTO> getAll(){
        List<ShportaProductViewDTO> shportaProductViewDTOS = null;
        try {
            shportaProductViewDTOS = new ArrayList<>();
            List<ShportaProduct> shportaProducts = shportaProductRepository.findAll();
            for (ShportaProduct shportaProduct : shportaProducts){
                ShportaProductViewDTO shportaProductViewDTO = new ShportaProductViewDTO();

                shportaProductViewDTO.setId(shportaProduct.getId());
                shportaProductViewDTO.setCmimiTotal(shportaProduct.getCmimiTotal());
                shportaProductViewDTO.setSasia(shportaProduct.getSasia());
                shportaProductViewDTO.setProduct(shportaProduct.getProduct());

                shportaProductViewDTOS.add(shportaProductViewDTO);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return shportaProductViewDTOS;
    }

    public Boolean shtoSasi(Long id, Integer sasia){
        try {
            ShportaProduct shportaProduct = shportaProductRepository.getOne(id);
            Product product = productRepository.getOne(shportaProduct.getProduct().getId());
            if(sasia > product.getSasia() + shportaProduct.getSasia()){
                shportaProduct.setSasia(product.getSasia() + shportaProduct.getSasia());
                shportaProduct.setCmimiTotal((product.getCmimi() * shportaProduct.getSasia()));
                product.setSasia(0);
            }else {
                product.setSasia(product.getSasia() + shportaProduct.getSasia() - sasia);
                shportaProduct.setSasia(sasia);
                shportaProduct.setCmimiTotal(Math.round((product.getCmimi() * sasia) * 100.0) / 100.0);
            }

            shportaProductRepository.save(shportaProduct);
            productRepository.save(product);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(Long id){
        try{
            ShportaProduct shportaProduct = shportaProductRepository.getOne(id);
            Product product = productRepository.getOne(shportaProduct.getProduct().getId());
            product.setSasia(product.getSasia() + shportaProduct.getSasia());
            shportaProductRepository.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }



}
