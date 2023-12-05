package com.example.springmysql.newModels;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int supplierID;

    @Column(name = "Supplier_Name")
    @NotBlank(message = "Название поставщика не может быть пустым")
    @Size(max = 100, message = "Название поставщика должно быть не более 100 символов")
    private String Supplier_Name;



    public Supplier(){}
    public Supplier(int supplierID, String Supplier_Name) {
        this.supplierID = supplierID;
        this.Supplier_Name = Supplier_Name;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return Supplier_Name;
    }

    public void setSupplierName(String Supplier_Name) {
        this.Supplier_Name = Supplier_Name;
    }


}

