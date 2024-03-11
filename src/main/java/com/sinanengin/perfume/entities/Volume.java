package com.sinanengin.perfume.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    private int volume;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();
}
