package com.ang.test.offer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    @Size(max = 20) // 20 characters
    @Column(name = "id")
    private Long id;

    @NotNull // Not null
    @Size(max = 150) // 150 characters
    @Column(name = "name", unique = true)
    private String name;

    @Min(value = 0L)// No negative
    @Digits(integer = 10, fraction = 2) // 10 integer positions, 2 decimal positions
    private BigDecimal price;

    @OneToMany(targetEntity = Offer.class, fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    // If the product gets deleted, delete also all related offers
    private List<Offer> offers;


    public Product(@NotNull @Size(max = 150) String name, @Min(value = 0L) @Digits(integer = 10, fraction = 2) BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
}
