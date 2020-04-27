package edu.ubt.testimi.data;

import edu.ubt.testimi.entity.type.PorosiaStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PorosiaDetajetViewDTO {

    private Long id;

    private String emri;

    private String mbiemri;

    private String email;

    private String numriTelefonit;

    private String rruga;

    private Integer zipKodi;

    private String qyteti;

    private Double cmimiTotal;

    private PorosiaStatus statusi;

    private List<PorosiaProduktiDTO> listaPorosive;
}
