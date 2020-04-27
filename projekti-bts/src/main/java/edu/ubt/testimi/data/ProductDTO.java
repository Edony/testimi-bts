package edu.ubt.testimi.data;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductDTO {

    @NotBlank
    private String emri;

    @NotBlank
    private String kodi;

    @NotBlank
    private String pershkrimi;

    @NotNull
    private Integer sasia;

    @NotNull
    private Double cmimi;

    private String foto;

}
