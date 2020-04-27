package edu.ubt.testimi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emri", length = 45, nullable = false)
    private String emri;

    @Column(name = "kodi", length = 45, nullable = false, unique = true)
    private String kodi;

    @Column(columnDefinition = "TEXT")
    private String pershkrimi;

    @Column(nullable = false)
    private int sasia;

    @Column(nullable = false)
    private double cmimi;

    @Column(name = "foto", columnDefinition = "LONGTEXT", nullable = true)
    private String foto;

}
