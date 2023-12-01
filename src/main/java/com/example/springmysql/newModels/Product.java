package com.example.springmysql.newModels;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productID;

    @Column(name = "Product_Name")
    @NotBlank(message = "Название товара не может быть пустым")
    @Size(max = 80, message = "Название товара должно быть не более 80 символов")
    private String Product_Name;

    @Column(name = "Product_Description")
    @NotBlank(message = "Описание товара не может быть пустым")
    @Size(max = 500, message = "Описание товара должно быть не более 500 символов")
    private String Product_Description;


    public Product(){}
    public Product(int productID, String Product_Name, String Product_Description) {
        this.productID = productID;
        this.Product_Name = Product_Name;
        this.Product_Description = Product_Description;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return Product_Name;
    }

    public void setProductName(String Product_Name) {
        this.Product_Name = Product_Name;
    }

    public String getProductDescription() {
        return Product_Description;
    }

    public void setProductDescription(String Product_Description) {
        this.Product_Description = Product_Description;
    }

}

