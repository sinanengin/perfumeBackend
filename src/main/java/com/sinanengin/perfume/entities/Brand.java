package com.sinanengin.perfume.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInıtializer","handler","products"})
@Entity
@Table(name = "brand")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private int brandId;


    @NotEmpty(message = "Kategori ismi boş geçilemez!")
    @Column(name = "brand_Name")
    private String brandName;

    @OneToMany(mappedBy = "brand")
    private List<Product> products = new ArrayList<>();
}
