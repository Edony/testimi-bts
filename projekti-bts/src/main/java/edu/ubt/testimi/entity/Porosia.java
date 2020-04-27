package edu.ubt.testimi.entity;

import edu.ubt.testimi.entity.type.PorosiaStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Porosia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String emri;

    private String mbiemri;

    private String email;

    private String numriTelefonit;

    private String rruga;

    private Integer zipKodi;

    private String qyteti;

    private String data;

    private Double cmimiTotal;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "ENUM('PENDING','CANCELED', 'SENT')", nullable = false)
    private PorosiaStatus status;
}
