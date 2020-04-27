package edu.ubt.testimi.service;

import edu.ubt.testimi.data.ShportaProductDTO;
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
        ShportaProductDTO shportaProductDTO = new ShportaProductDTO();
        shportaProductDTO.setProduct_id(1l);
        shportaProductDTO.setSasia(5);

        ShportaProduct shportaProduct = getShportaProductsMock().get(0);

        Product product1 = new Product();
        product1.setId(1l);
        product1.setEmri("Test Product 1");
        product1.setSasia(10);
        product1.setCmimi(50.00);
        product1.setFoto("https://cnet2.cbsistatic.com/img/rxN4Y_QwzChtDn829w_yq0w1SQg=/470x376/2019/06/22/37a6865e-001d-4598-9d89-8e96473a644c/10-dell-g5-15.jpg");
        product1.setKodi("ASFJOIJASF124");
        product1.setPershkrimi("Test me i mire gaming per vitin 2019");


        when(productRepository.getOne(shportaProductDTO.getProduct_id())).thenReturn(product1);
        when(shportaProductRepository.save(shportaProduct)).thenReturn(shportaProduct);
        assertEquals(true,shportaProductService.create(shportaProductDTO));
    }

    @Test
    void getAll() {
        List<ShportaProduct> shportaProducts = getShportaProductsMock();
        when(shportaProductRepository.findAll()).thenReturn(shportaProducts);
        assertEquals(2,shportaProductService.getAll().size());
    }

    @Test
    void shtoSasi() {
        ShportaProduct shportaProduct = getShportaProductsMock().get(0);

        Product product = shportaProduct.getProduct();

        when(shportaProductRepository.getOne(1l)).thenReturn(shportaProduct);
        when(productRepository.getOne(shportaProduct.getProduct().getId())).thenReturn(product);

        assertEquals(true,shportaProductService.shtoSasi(1l,2));
    }

    @Test
    void shtoSasi_sasiaMaEMadheSeStoku() {
        ShportaProduct shportaProduct = getShportaProductsMock().get(0);

        Product product = shportaProduct.getProduct();

        when(shportaProductRepository.getOne(1l)).thenReturn(shportaProduct);
        when(productRepository.getOne(shportaProduct.getProduct().getId())).thenReturn(product);

        assertEquals(true,shportaProductService.shtoSasi(1l,500));
    }

    @Test
    void shtoSasi_sasiaMinus() {
        ShportaProduct shportaProduct = getShportaProductsMock().get(0);

        Product product = shportaProduct.getProduct();

        when(shportaProductRepository.getOne(1l)).thenReturn(shportaProduct);
        when(productRepository.getOne(shportaProduct.getProduct().getId())).thenReturn(product);

        assertEquals(true,shportaProductService.shtoSasi(1l,-10));
    }

    @Test
    void delete() {
        ShportaProduct shportaProduct = getShportaProductsMock().get(1);
        Product product = shportaProduct.getProduct();

        when(shportaProductRepository.getOne(1l)).thenReturn(shportaProduct);
        when(productRepository.getOne(shportaProduct.getProduct().getId())).thenReturn(product);

        assertEquals(true, shportaProductService.delete(1l));
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