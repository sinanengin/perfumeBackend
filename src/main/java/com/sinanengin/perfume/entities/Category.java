package com.sinanengin.perfume.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties({"hibernateLazyInıtializer","handler","products"})
@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "category_name")
    private String categoryName;


    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();
}
