package edu.ubt.testimi.data;

import edu.ubt.testimi.entity.Product;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ShportaProductDTO {

    @NotNull
    private Long product_id;

    @Min(value = 0L, message = "Sasia duhet te jete vlere pozitive")
    private Integer sasia;

}
