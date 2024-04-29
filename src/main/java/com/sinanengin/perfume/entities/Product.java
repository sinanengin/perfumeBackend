package com.sinanengin.perfume.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
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


    @NotEmpty(message = "Ürün adı boş geçilemez!")
    @Column(name = "product_name")
    private String productName;

    @NotEmpty(message = "Ürün açıklaması boş geçilemez!")
    @Column(name = "product_description")
    private String productDescription;

    @NotEmpty(message = "Ürün fiyatı boş geçilemez!")
    @Positive
    @Column(name = "product_price")
    private int productPrice;

    @NotEmpty(message = "Ürünün stok adedi boş geçilemez!")
    @Positive
    @Column(name = "product_stock_amount")
    private int productStockAmount;

    @NotEmpty(message = "Ürün fotoğrafı boş geçilemez!")
    @Column(name = "product_image_url")
    private String productImageUrl;

    @Column(name = "product_is_bestseller")
    private boolean productIsBestSeller;


    @ManyToOne
    @NotEmpty(message = "Kategori seçimi boş geçilemez!")
    @JoinColumn(name = "category_id")
    private Category category;


    @ManyToOne
    @NotEmpty(message = "Marka seçimi boş geçilemez!")
    @JoinColumn(name = "brand_id")
    private Brand brand;


    @ManyToOne
    @NotEmpty(message = "Ürün boyutu boş geçilemez!")
    @JoinColumn(name = "product_volume_id")
    private Volume volume;


    @ManyToOne
    @NotEmpty(message = "Cinsiyet seçimi boş geçilemez!")
    @JoinColumn(name = "product_gender_id")
    private Gender gender;
}
