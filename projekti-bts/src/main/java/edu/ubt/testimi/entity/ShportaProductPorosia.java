package edu.ubt.testimi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "shportaProduct_porosia")
public class ShportaProductPorosia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Porosia.class)
    @JoinColumn(name = "porosia_id", referencedColumnName = "id", nullable = false)
    private Porosia porosia;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;

    private Double cmimiProduktit;

    private Integer sasia;

    private Double cmimiTotal;

}
