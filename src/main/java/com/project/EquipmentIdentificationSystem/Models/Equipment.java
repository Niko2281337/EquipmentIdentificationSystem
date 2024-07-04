package com.project.EquipmentIdentificationSystem.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String Category,Line,Name, Description, Comments;
    private int SerialNumber, MarketPrice,PurchasePrice;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public int getPurchasePrice() {
        return PurchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        PurchasePrice = purchasePrice;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getLine() {
        return Line;
    }

    public void setLine(String line) {
        Line = line;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getSerialNumber() {
        return SerialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        SerialNumber = serialNumber;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }

    public int getMarketPrice() {
        return MarketPrice;
    }

    public void setMarketPrice(int marketPrice) {
        MarketPrice = marketPrice;
    }

    public Equipment() {
    }

    public Equipment(String name,String category,String description, String line, int marketPrice, int purchasePrice, int serialNumber) {
        Category = category;
        Line = line;
        Name = name;
        Description = description;
        SerialNumber = serialNumber;
        MarketPrice = marketPrice;
        PurchasePrice = purchasePrice;
    }
}

