package edu.ubt.testimi.service;

import edu.ubt.testimi.data.ShportaProductViewDTO;
import edu.ubt.testimi.entity.Product;
import edu.ubt.testimi.entity.ShportaProduct;
import edu.ubt.testimi.repository.ProductRepository;
import edu.ubt.testimi.repository.ShportaProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class ShportaProductServiceTest {

    @Autowired
    private ShportaProductService shportaProductService;

    @MockBean
    private ShportaProductRepository shportaProductRepository;

    @MockBean
    private ProductRepository productRepository;

    @Test
    void create() {

    }

    @Test
    void getAll() {
        List<ShportaProduct> shportaProducts = getShportaProductsMock();
        List<ShportaProductViewDTO> shportaProductViewDTOS = null;

            shportaProductViewDTOS = new ArrayList<>();

            for (ShportaProduct shportaProduct : shportaProducts){
                ShportaProductViewDTO shportaProductViewDTO = new ShportaProductViewDTO();

                shportaProductViewDTO.setId(shportaProduct.getId());
                shportaProductViewDTO.setCmimiTotal(shportaProduct.getCmimiTotal());
                shportaProductViewDTO.setSasia(shportaProduct.getSasia());
                shportaProductViewDTO.setProduct(shportaProduct.getProduct());

                shportaProductViewDTOS.add(shportaProductViewDTO);
            }

        when(shportaProductRepository.findAll()).thenReturn(shportaProducts);
        assertEquals(2,shportaProductService.getAll().size());
    }

    @Test
    void shtoSasi() {
        int sasia = 2;
        ShportaProduct shportaProductMock = getShportaProductsMock().get(0);

        Product product = new Product();
        product.setId(1l);
        product.setEmri("Test Product 1");
        product.setSasia(10);
        product.setCmimi(50.00);
        product.setFoto("https://cnet2.cbsistatic.com/img/rxN4Y_QwzChtDn829w_yq0w1SQg=/470x376/2019/06/22/37a6865e-001d-4598-9d89-8e96473a644c/10-dell-g5-15.jpg");
        product.setKodi("ASFJOIJASF124");
        product.setPershkrimi("Test me i mire gaming per vitin 2019");

        if(sasia > product.getSasia() + shportaProductMock.getSasia()){
            shportaProductMock.setSasia(product.getSasia() + shportaProductMock.getSasia());
            shportaProductMock.setCmimiTotal((product.getCmimi() * shportaProductMock.getSasia()));
            product.setSasia(0);
        }else {
            product.setSasia(product.getSasia() + shportaProductMock.getSasia() - sasia);
            shportaProductMock.setSasia(sasia);
            shportaProductMock.setCmimiTotal(Math.round((product.getCmimi() * sasia) * 100.0) / 100.0);
        }

        when(productRepository.getOne(shportaProductMock.getProduct().getId())).thenReturn(product);
        when(shportaProductRepository.save(shportaProductMock)).thenReturn(shportaProductMock);
        when(productRepository.save(product)).thenReturn(product);
        assertEquals(true,shportaProductService.shtoSasi(shportaProductMock.getId(),sasia));
    }

    @Test
    void delete() {
    }

    private List<ShportaProduct> getShportaProductsMock(){
        List<ShportaProduct> shportaProducts = new ArrayList<>();

        Product product1 = new Product();
        product1.setId(1l);
        product1.setEmri("Test Product 1");
        product1.setSasia(10);
        product1.setCmimi(50.00);
        product1.setFoto("https://cnet2.cbsistatic.com/img/rxN4Y_QwzChtDn829w_yq0w1SQg=/470x376/2019/06/22/37a6865e-001d-4598-9d89-8e96473a644c/10-dell-g5-15.jpg");
        product1.setKodi("ASFJOIJASF124");
        product1.setPershkrimi("Test me i mire gaming per vitin 2019");

        Product product2 = new Product();
        product1.setId(2l);
        product1.setEmri("Test Product 2");
        product1.setSasia(20);
        product1.setCmimi(20.00);
        product1.setFoto("https://cnet2.cbsistatic.com/img/rxN4Y_QwzChtDn829w_yq0w1SQg=/470x376/2019/06/22/37a6865e-001d-4598-9d89-8e96473a644c/10-dell-g5-15.jpg");
        product1.setKodi("ASFJOIJASF124");
        product1.setPershkrimi("Test product me i mire gaming per vitin 2019");

        ShportaProduct shportaProduct1 = new ShportaProduct();
        shportaProduct1.setId(1l);
        shportaProduct1.setCmimiProduktit(50.00);
        shportaProduct1.setSasia(5);
        shportaProduct1.setCmimiTotal(250.00);
        shportaProduct1.setProduct(product1);

        ShportaProduct shportaProduct2 = new ShportaProduct();
        shportaProduct2.setId(1l);
        shportaProduct2.setCmimiProduktit(20.00);
        shportaProduct2.setSasia(2);
        shportaProduct2.setCmimiTotal(100.00);
        shportaProduct2.setProduct(product2);

        shportaProducts.add(shportaProduct1);
        shportaProducts.add(shportaProduct2);

        return shportaProducts;
    }
}