package edu.ubt.testimi.service;

import edu.ubt.testimi.data.ProductDTO;
import edu.ubt.testimi.data.ProductViewDTO;
import edu.ubt.testimi.entity.Product;
import edu.ubt.testimi.repository.ProductRepository;
import edu.ubt.testimi.repository.ShportaProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShportaProductRepository shportaProductRepository;


    public Product create(ProductDTO productDTO){
        Product result = null;
        Integer sasia = productDTO.getSasia();
        if (sasia <= 0){
            sasia = 1;
        }
        try {
            Product product = new Product();
            product.setEmri(productDTO.getEmri());
            product.setKodi(productDTO.getKodi());
            product.setPershkrimi(productDTO.getPershkrimi());
            product.setSasia(sasia);
            product.setCmimi(productDTO.getCmimi());
            product.setFoto(productDTO.getFoto());
            productRepository.save(product);
            result = product;

        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    public Product update(ProductViewDTO productViewDTO){
        Product result = null;
        Integer sasia = productViewDTO.getSasia();
        if (sasia < 0){
            sasia = 1;
        }
        try {
            Product product = productRepository.getOne(productViewDTO.getId());
            product.setEmri(productViewDTO.getEmri());
            product.setKodi(productViewDTO.getKodi());
            product.setPershkrimi(productViewDTO.getPershkrimi());
            product.setSasia(sasia);
            product.setCmimi(productViewDTO.getCmimi());
            product.setFoto(productViewDTO.getFoto());

            productRepository.save(product);
            result = product;
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    public List<ProductViewDTO> getAll(){
        List<ProductViewDTO> productViewDTOS = null;
        try {
            productViewDTOS = new ArrayList<>();
            List<Product> products = productRepository.findAll();
            for (Product product : products){
                ProductViewDTO productViewDTO = new ProductViewDTO();

                Boolean checkShportaProductExists = shportaProductRepository.existsByProduct(product);

                productViewDTO.setId(product.getId());
                productViewDTO.setEmri(product.getEmri());
                productViewDTO.setKodi(product.getKodi());
                productViewDTO.setPershkrimi(product.getPershkrimi());
                productViewDTO.setCmimi(product.getCmimi());
                productViewDTO.setSasia(product.getSasia());
                productViewDTO.setFoto(product.getFoto());
                if (checkShportaProductExists){
                    productViewDTO.setEshteNeStok(true);
                }else {
                    productViewDTO.setEshteNeStok(false);
                }

                productViewDTOS.add(productViewDTO);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return productViewDTOS;
    }

    public ProductViewDTO getOne(Long id){
        ProductViewDTO productViewDTO = new ProductViewDTO();
        try {
            Product product = productRepository.getOne(id);

            productViewDTO.setId(product.getId());
            productViewDTO.setEmri(product.getEmri());
            productViewDTO.setCmimi(product.getCmimi());
            productViewDTO.setSasia(product.getSasia());
            productViewDTO.setPershkrimi(product.getPershkrimi());
            productViewDTO.setFoto(product.getFoto());
            productViewDTO.setKodi(product.getKodi());

        }catch (Exception e){
            e.printStackTrace();
        }
        return productViewDTO;
    }

}
