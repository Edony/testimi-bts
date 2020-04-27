package edu.ubt.testimi.service;

import edu.ubt.testimi.data.PorosiaDTO;
import edu.ubt.testimi.data.PorosiaListViewDTO;
import edu.ubt.testimi.data.ShportaProductPorosiaDTO;
import edu.ubt.testimi.entity.Porosia;
import edu.ubt.testimi.entity.Product;
import edu.ubt.testimi.entity.ShportaProduct;
import edu.ubt.testimi.entity.type.PorosiaStatus;
import edu.ubt.testimi.repository.PorosiaRepository;
import edu.ubt.testimi.repository.ShportaProductPorosiaRepository;
import edu.ubt.testimi.repository.ShportaProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class PorosiaServiceTest {

    @Autowired
    PorosiaService porosiaService;

    @MockBean
    private PorosiaRepository porosiaRepository;

    @MockBean
    private ShportaProductRepository shportaProductRepository;

    @MockBean
    private ShportaProductPorosiaService shportaProductPorosiaService;

    @MockBean
    private ShportaProductPorosiaRepository shportaProductPorosiaRepository;

    @Test
    void create() {

    }

    @Test
    void getAll() {
        List<Porosia> porosias = porosiasMock();

        when(porosiaRepository.findAll()).thenReturn(porosias);
        assertEquals(2,porosiaService.getAll().size());
    }

    @Test
    void getOne() {
    }

    @Test
    void dergoPorosine() {
//        Porosia porosia = porosiasMock().get(1);
//
//        when(porosiaRepository.getOne(porosia.getId())).thenReturn(porosia);
//        when(porosiaRepository.save(porosia)).thenReturn(porosia);
//        assertEquals(true, porosiaService.dergoPorosine(porosia.getId()));
    }

    @Test
    void anuloPorosine() {

    }

    private List<Porosia> porosiasMock (){
        List<Porosia> porosias = new ArrayList<>();

        Porosia porosia1 = new Porosia();
        porosia1.setId(1l);
        porosia1.setEmri("Edon");
        porosia1.setMbiemri("Gjergji");
        porosia1.setEmail("edony@live.com");
        porosia1.setNumriTelefonit("4894984984");
        porosia1.setRruga("Adem Jashari");
        porosia1.setZipKodi(56000);
        porosia1.setQyteti("Prizren");
        porosia1.setStatus(PorosiaStatus.PENDING);
        porosia1.setCmimiTotal(500.00);
        porosia1.setData(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));

        Porosia porosia2 = new Porosia();
        porosia1.setId(2l);
        porosia1.setEmri("Edin");
        porosia1.setMbiemri("Bula");
        porosia1.setEmail("dini@hotmail.com");
        porosia1.setNumriTelefonit("4894984984");
        porosia1.setRruga("Adem Jashari");
        porosia1.setZipKodi(56000);
        porosia1.setQyteti("Prizren");
        porosia1.setStatus(PorosiaStatus.PENDING);
        porosia1.setCmimiTotal(500.00);
        porosia1.setData(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));

        porosias.add(porosia1);
        porosias.add(porosia2);

        return porosias;
    }


    private List<PorosiaListViewDTO> porosiaListViewDTOSMock(){
        List<PorosiaListViewDTO> porosiaListViewDTOS = new ArrayList<>();

        PorosiaListViewDTO porosiaListViewDTO1 = new PorosiaListViewDTO();
        porosiaListViewDTO1.setId(1l);
        porosiaListViewDTO1.setEmri("Edon");
        porosiaListViewDTO1.setMbiemri("Gjergji");
        porosiaListViewDTO1.setEmail("edony@live.com");
        porosiaListViewDTO1.setNumriTelefonit("4894984984");
        porosiaListViewDTO1.setRruga("Adem Jashari");
        porosiaListViewDTO1.setZipKodi(56000);
        porosiaListViewDTO1.setQyteti("Prizren");
        porosiaListViewDTO1.setStatus(PorosiaStatus.PENDING);
        porosiaListViewDTO1.setSasia(4l);
        porosiaListViewDTO1.setCmimiTotal(500.00);
        porosiaListViewDTO1.setData(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));

        PorosiaListViewDTO porosiaListViewDTO2= new PorosiaListViewDTO();
        porosiaListViewDTO2.setId(1l);
        porosiaListViewDTO2.setEmri("Edin");
        porosiaListViewDTO2.setMbiemri("Bula");
        porosiaListViewDTO2.setEmail("edini@hotmail.com");
        porosiaListViewDTO2.setNumriTelefonit("4894984984");
        porosiaListViewDTO2.setRruga("Sheshi Skenderbeu");
        porosiaListViewDTO2.setZipKodi(56000);
        porosiaListViewDTO2.setQyteti("Prishtine");
        porosiaListViewDTO2.setStatus(PorosiaStatus.PENDING);
        porosiaListViewDTO2.setSasia(1l);
        porosiaListViewDTO2.setCmimiTotal(200.00);
        porosiaListViewDTO2.setData(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));

        porosiaListViewDTOS.add(porosiaListViewDTO1);
        porosiaListViewDTOS.add(porosiaListViewDTO2);

        return porosiaListViewDTOS;

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