package com.example.Wishlist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID of wish
    private String name;
    private String description;
    private Double price;
    private String link;
    private String img;

    public Wish() { // --- Why do we have an empty constructor? ---
    }

    public Wish(Long id, String name, String description, Double price, String link, String img) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.link = link;
        this.img = img;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}