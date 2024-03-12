package com.sinanengin.perfume.entities;

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
@Table(name = "gender")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gender_id")
    private int genderId;

    @Column(name = "gender_name")
    private String genderName;


    @OneToMany(mappedBy = "gender")
    private List<Product> products = new ArrayList<>();
}
