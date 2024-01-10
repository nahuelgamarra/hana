package org.ngamarra.hana.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.ngamarra.hana.enums.Unit;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private Float width;
    private String composition;
    private Float rinde;

    @Enumerated(EnumType.STRING)
    private Unit unit;

}
