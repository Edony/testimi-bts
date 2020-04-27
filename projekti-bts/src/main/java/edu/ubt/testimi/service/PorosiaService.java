package edu.ubt.testimi.service;

import edu.ubt.testimi.data.*;
import edu.ubt.testimi.entity.Porosia;
import edu.ubt.testimi.entity.ShportaProduct;
import edu.ubt.testimi.entity.ShportaProductPorosia;
import edu.ubt.testimi.entity.type.PorosiaStatus;
import edu.ubt.testimi.repository.PorosiaRepository;
import edu.ubt.testimi.repository.ShportaProductPorosiaRepository;
import edu.ubt.testimi.repository.ShportaProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PorosiaService {

    @Autowired
    private PorosiaRepository porosiaRepository;

    @Autowired
    private ShportaProductRepository shportaProductRepository;

    @Autowired
    private ShportaProductPorosiaService shportaProductPorosiaService;

    @Autowired
    private ShportaProductPorosiaRepository shportaProductPorosiaRepository;

    public Boolean create(PorosiaDTO porosiaDTO){
        Boolean result = false;
        try {
            Porosia porosia = new Porosia();
            porosia.setEmri(porosiaDTO.getEmri());
            porosia.setMbiemri(porosiaDTO.getMbiemri());
            porosia.setEmail(porosiaDTO.getEmail());
            porosia.setNumriTelefonit(porosiaDTO.getNumriTelefonit());
            porosia.setRruga(porosiaDTO.getRruga());
            porosia.setZipKodi(porosiaDTO.getZipKodi());
            porosia.setQyteti(porosiaDTO.getQyteti());
            porosia.setData(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
            porosia.setStatus(PorosiaStatus.PENDING);

            Porosia newPorosia = porosiaRepository.save(porosia);
            Long newPorosiaID = newPorosia.getId();
            Double cmimiTotalIPorosise = 0.0;

            List<ShportaProduct> shportaProducts = shportaProductRepository.findAll();
            for (ShportaProduct shportaProduct : shportaProducts){
                ShportaProductPorosiaDTO shportaProductPorosiaDTO = new ShportaProductPorosiaDTO();
                cmimiTotalIPorosise += shportaProduct.getCmimiTotal();

                shportaProductPorosiaDTO.setProduct_id(shportaProduct.getProduct().getId());
                shportaProductPorosiaDTO.setPorosia_id(newPorosiaID);
                shportaProductPorosiaDTO.setSasia(shportaProduct.getSasia());
                shportaProductPorosiaDTO.setCmimiProduktit(shportaProduct.getCmimiProduktit());
                shportaProductPorosiaDTO.setCmimiTotal(shportaProduct.getCmimiTotal());

                shportaProductPorosiaService.create(shportaProductPorosiaDTO);
            }
            porosia.setCmimiTotal(cmimiTotalIPorosise);
            porosiaRepository.save(porosia);
            shportaProductRepository.deleteAll();
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    public List<PorosiaListViewDTO> getAll(){
        List<PorosiaListViewDTO> porosiaListViewDTOS = null;
        try {
            porosiaListViewDTOS = new ArrayList<>();
            List<Porosia> porosias = porosiaRepository.findAll();
            for (Porosia porosia : porosias){
                PorosiaListViewDTO porosiaListViewDTO = new PorosiaListViewDTO();

                porosiaListViewDTO.setId(porosia.getId());
                porosiaListViewDTO.setEmri(porosia.getEmri());
                porosiaListViewDTO.setMbiemri(porosia.getMbiemri());
                porosiaListViewDTO.setEmail(porosia.getEmail());
                porosiaListViewDTO.setNumriTelefonit(porosia.getNumriTelefonit());
                porosiaListViewDTO.setRruga(porosia.getRruga());
                porosiaListViewDTO.setZipKodi(porosia.getZipKodi());
                porosiaListViewDTO.setQyteti(porosia.getQyteti());
                porosiaListViewDTO.setData(porosia.getData());
                porosiaListViewDTO.setStatus(porosia.getStatus());
                porosiaListViewDTO.setSasia(shportaProductPorosiaRepository.countByPorosiaId(porosia.getId()));
//                porosiaListViewDTO.setCmimiTotal(Math.round(porosia.getCmimiTotal() * 100.0) / 100.0);
                porosiaListViewDTO.setCmimiTotal(porosia.getCmimiTotal());
                porosiaListViewDTOS.add(porosiaListViewDTO);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return porosiaListViewDTOS;
    }

    public PorosiaDetajetViewDTO getOne(Long id){
        PorosiaDetajetViewDTO porosiaDetajetViewDTO = null;
        try {
            porosiaDetajetViewDTO = new PorosiaDetajetViewDTO();
            if (porosiaRepository.existsById(id)){

                Porosia porosia = porosiaRepository.getOne(id);

                porosiaDetajetViewDTO.setId(porosia.getId());
                porosiaDetajetViewDTO.setEmri(porosia.getEmri());
                porosiaDetajetViewDTO.setMbiemri(porosia.getMbiemri());
                porosiaDetajetViewDTO.setEmail(porosia.getEmail());
                porosiaDetajetViewDTO.setNumriTelefonit(porosia.getNumriTelefonit());
                porosiaDetajetViewDTO.setRruga(porosia.getRruga());
                porosiaDetajetViewDTO.setZipKodi(porosia.getZipKodi());
                porosiaDetajetViewDTO.setQyteti(porosia.getQyteti());
                porosiaDetajetViewDTO.setCmimiTotal(Math.round(porosia.getCmimiTotal() * 100.0) / 100.0);
                porosiaDetajetViewDTO.setStatusi(porosia.getStatus());

                List<ShportaProductPorosia> shportaProductPorosias = shportaProductPorosiaRepository.findAllByPorosiaId(id);
                List<PorosiaProduktiDTO> listaPorosive = new ArrayList<>();

                for (ShportaProductPorosia shportaProductPorosia : shportaProductPorosias){
                    PorosiaProduktiDTO porosiaProduktiDTO = new PorosiaProduktiDTO();
                    porosiaProduktiDTO.setFoto(shportaProductPorosia.getProduct().getFoto());
                    porosiaProduktiDTO.setCmimi(shportaProductPorosia.getCmimiProduktit());
                    porosiaProduktiDTO.setCmimiTotal(Math.round(shportaProductPorosia.getCmimiTotal() * 100.0) / 100.0);
                    porosiaProduktiDTO.setEmriProduktit(shportaProductPorosia.getProduct().getEmri());
                    porosiaProduktiDTO.setKodiIProduktit(shportaProductPorosia.getProduct().getKodi());
                    porosiaProduktiDTO.setSasia(Long.valueOf(shportaProductPorosia.getSasia()));
                    listaPorosive.add(porosiaProduktiDTO);
                }

                porosiaDetajetViewDTO.setListaPorosive(listaPorosive);
                return porosiaDetajetViewDTO;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    public Boolean dergoPorosine(Long id){
        try{
            Porosia porosia = porosiaRepository.getOne(id);
            if (porosia.getStatus().equals(PorosiaStatus.PENDING)){
                porosia.setStatus(PorosiaStatus.SENT);
                porosiaRepository.save(porosia);
                return true;
            }
            return false;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Boolean anuloPorosine(Long id){
        try{
            Porosia porosia = porosiaRepository.getOne(id);
            if (porosia.getStatus().equals(PorosiaStatus.PENDING)){
                porosia.setStatus(PorosiaStatus.CANCELED);
                porosiaRepository.save(porosia);
                return true;
            }
            return false;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }





}
