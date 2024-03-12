package com.sinanengin.perfume.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties({"hibernateLazyInıtializer","handler","products"})
@Entity
@Table(name = "volume")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Volume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "volume_id")
    private int volumeId;

    @Column(name = "volume")
    private String volume;

    @OneToMany(mappedBy = "volume")
    private List<Product> products = new ArrayList<>();
}
