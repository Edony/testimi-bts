package edu.ubt.testimi.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductViewDTO {

    private Long id;

    private String emri;

    private String kodi;

    private String pershkrimi;

    private Integer sasia;

    private Double cmimi;

    private String foto;

    private Boolean eshteNeStok;
}
