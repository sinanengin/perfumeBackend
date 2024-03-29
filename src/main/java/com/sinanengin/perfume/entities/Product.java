package com.sinanengin.perfume.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_description")
    private String productDescription;
    @Column(name = "product_price")
    private int productPrice;
    @Column(name = "product_stock_amount")
    private int productStockAmount;
    @Column(name = "product_image_url")
    private String productImageUrl;
    @Column(name = "product_is_bestseller")
    private boolean productIsBestSeller;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;


    @ManyToOne
    @JoinColumn(name = "product_volume_id")
    private Volume volume;


    @ManyToOne
    @JoinColumn(name = "product_gender_id")
    private Gender gender;
}
