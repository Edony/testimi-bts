package edu.ubt.testimi.data;

import edu.ubt.testimi.entity.type.PorosiaStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PorosiaListViewDTO {

    private Long id;

    private String emri;

    private String mbiemri;

    private String email;

    private String numriTelefonit;

    private String rruga;

    private Integer zipKodi;

    private String qyteti;

    private String data;

    private PorosiaStatus status;

    private Long sasia;

    private Double cmimiTotal;
}
