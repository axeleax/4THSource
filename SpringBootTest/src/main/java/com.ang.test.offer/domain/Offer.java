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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "offer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Offer {

    @Id
    @GeneratedValue
    @Size(max = 20) // 20 characters
    @Column(name = "id")
    private Long id;

    @NotNull // Not null
    @Digits(integer = 1, fraction = 2) // 1 integer character, 2 decimal characters
    @Column(name = "discount_pct")
    private BigDecimal discountPct;

    @NotNull // Not null
    @Column(name = "active_from")
    private Date activeFrom;

    // Nullable (Null means that this offer will be valid for undefined time)
    @Column(name = "active_until")
    private Date activeUntil;

    @ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // Don't load it unless necessary
    @NotNull // Not null
    @Column(name = "product")
    private Product product;

    public Offer(@NotNull @Digits(integer = 1, fraction = 2) BigDecimal discountPct, @NotNull Date activeFrom, Date activeUntil, @NotNull Product product) {
        this.discountPct = discountPct;
        this.activeFrom = activeFrom;
        this.activeUntil = activeUntil;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getDiscountPct() {
        return discountPct;
    }

    public void setDiscountPct(BigDecimal discountPct) {
        this.discountPct = discountPct;
    }

    public Date getActiveFrom() {
        return activeFrom;
    }

    public void setActiveFrom(Date activeFrom) {
        this.activeFrom = activeFrom;
    }

    public Date getActiveUntil() {
        return activeUntil;
    }

    public void setActiveUntil(Date activeUntil) {
        this.activeUntil = activeUntil;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
