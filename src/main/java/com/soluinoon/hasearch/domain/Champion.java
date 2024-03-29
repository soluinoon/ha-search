package com.soluinoon.hasearch.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class Champion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String imagePath;
    @Enumerated(EnumType.STRING)
    private Tier tier;
    private String tip;
    @Column(scale = 2)
    private BigDecimal winRate;

    @OneToMany(mappedBy = "champion")
    private List<Comment> comments = new ArrayList<>();
}
