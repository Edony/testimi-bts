package edu.ubt.testimi.service;

import edu.ubt.testimi.data.ShportaProductPorosiaDTO;
import edu.ubt.testimi.entity.ShportaProductPorosia;
import edu.ubt.testimi.repository.PorosiaRepository;
import edu.ubt.testimi.repository.ProductRepository;
import edu.ubt.testimi.repository.ShportaProductPorosiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShportaProductPorosiaService {


    @Autowired
    private PorosiaRepository porosiaRepository;


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShportaProductPorosiaRepository shportaProductPorosiaRepository;


    public Boolean create(ShportaProductPorosiaDTO shportaProductPorosiaDTO){
        Boolean result = false;
        try {
            ShportaProductPorosia shportaProductPorosia = new ShportaProductPorosia();

            shportaProductPorosia.setPorosia(porosiaRepository.getOne(shportaProductPorosiaDTO.getPorosia_id()));
            shportaProductPorosia.setProduct(productRepository.getOne(shportaProductPorosiaDTO.getProduct_id()));
            shportaProductPorosia.setSasia(shportaProductPorosiaDTO.getSasia());
            shportaProductPorosia.setCmimiProduktit(shportaProductPorosiaDTO.getCmimiProduktit());
            shportaProductPorosia.setCmimiTotal(shportaProductPorosiaDTO.getCmimiTotal());

            shportaProductPorosiaRepository.save(shportaProductPorosia);

            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
