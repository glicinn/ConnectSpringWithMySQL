package com.example.springmysql.newModels;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryID;

    @Column(name = "Category_Name")
    @NotBlank(message = "Название категории не может быть пустым")
    @Size(max = 30, message = "Название категории должно быть не более 30 символов")
    private String Category_Name;

    @Column(name = "Age_Limit")
    @NotBlank(message = "Возрастное ограничение не может быть пустым")
    @Size(max = 3, message = "Возрастное ограничение должно быть не более 3 символов")
    private String Age_Limit;


    public Category(){}
    public Category(int categoryID, String Category_Name, String Age_Limit) {
        this.categoryID = categoryID;
        this.Category_Name = Category_Name;
        this.Age_Limit = Age_Limit;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return Category_Name;
    }

    public void setCategoryName(String Category_Name) {
        this.Category_Name = Category_Name;
    }

    public String getAgeLimit() {
        return Age_Limit;
    }

    public void setAgeLimit(String Age_Limit) {
        this.Age_Limit = Age_Limit;
    }

}

