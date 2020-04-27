package edu.ubt.testimi.service;

import edu.ubt.testimi.data.ShportaProductPorosiaDTO;
import edu.ubt.testimi.entity.ShportaProductPorosia;
import edu.ubt.testimi.repository.PorosiaRepository;
import edu.ubt.testimi.repository.ProductRepository;
import edu.ubt.testimi.repository.ShportaProductPorosiaRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class ShportaProductPorosiaServiceTest {

    @Autowired
    ShportaProductPorosiaService shportaProductPorosiaService;

    @Autowired
    ShportaProductPorosiaRepository shportaProductPorosiaRepository;

    @MockBean
    ShportaProductPorosiaRepository productPorosiaRepository;

    @MockBean
    PorosiaRepository porosiaRepository;

    @MockBean
    ProductRepository productRepository;

    @Test
    void create() {
        ShportaProductPorosiaDTO shportaProductPorosiaDTO = new ShportaProductPorosiaDTO();
        shportaProductPorosiaDTO.setCmimiTotal(500.00);
        shportaProductPorosiaDTO.setCmimiProduktit(50.0);
        shportaProductPorosiaDTO.setSasia(10);
        shportaProductPorosiaDTO.setPorosia_id(1l);
        shportaProductPorosiaDTO.setProduct_id(1l);

        ShportaProductPorosia shportaProductPorosia = new ShportaProductPorosia();
        shportaProductPorosia.setPorosia(porosiaRepository.getOne(shportaProductPorosiaDTO.getPorosia_id()));
        shportaProductPorosia.setProduct(productRepository.getOne(shportaProductPorosiaDTO.getProduct_id()));
        shportaProductPorosia.setSasia(shportaProductPorosiaDTO.getSasia());
        shportaProductPorosia.setCmimiProduktit(shportaProductPorosiaDTO.getCmimiProduktit());
        shportaProductPorosia.setCmimiTotal(shportaProductPorosiaDTO.getCmimiTotal());

        when(shportaProductPorosiaRepository.save(shportaProductPorosia)).thenReturn(shportaProductPorosia);
        assertEquals(true,shportaProductPorosiaService.create(shportaProductPorosiaDTO));

    }
}