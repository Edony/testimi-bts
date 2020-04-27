package edu.ubt.testimi.data;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ShportaProductPorosiaDTO {

    @NotBlank
    private Long porosia_id;

    @NotBlank
    private Long product_id;

    @NotBlank
    private Double cmimiProduktit;

    @NotBlank
    private Integer sasia;

    @NotBlank
    private Double cmimiTotal;

}
