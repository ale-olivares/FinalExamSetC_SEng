package com.example.finalexamsetc_seng.entities;

public class SalesSummary {
    private String categoryCode;
    private String categoryDescription;
    private Double totalSales;

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public Double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Double totalSales) {
        this.totalSales = totalSales;
    }

    public SalesSummary(String categoryCode, String categoryDescription, Double totalSales) {
        this.categoryCode = categoryCode;
        this.categoryDescription = categoryDescription;
        this.totalSales = totalSales;
    }
}
