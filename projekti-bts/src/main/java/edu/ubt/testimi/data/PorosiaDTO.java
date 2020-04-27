package edu.ubt.testimi.data;

import edu.ubt.testimi.entity.type.PorosiaStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PorosiaDTO {

    @NotNull
    private String emri;

    @NotNull
    private String mbiemri;

    @NotNull
    private String email;

    @NotNull
    private String numriTelefonit;

    @NotNull
    private String rruga;

    @NotNull
    private Integer zipKodi;

    @NotNull
    private String qyteti;
}
