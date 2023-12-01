package com.example.springmysql.newModels;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Ordering")
public class Ordering {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderingID;

    @Column(name = "Ordering_Number")
    @NotBlank(message = "Номер заказа не может быть пустым")
    @Size(max = 8, min = 8, message = "Номер заказа должен быть 8 символов")
    private String Ordering_Number;



    public Ordering(){}
    public Ordering(int orderingID, String Ordering_Number) {
        this.orderingID = orderingID;
        this.Ordering_Number = Ordering_Number;
    }

    public int getOrderingID() {
        return orderingID;
    }

    public void setOrderingID(int orderingID) {
        this.orderingID = orderingID;
    }

    public String getOrderingNumber() {
        return Ordering_Number;
    }

    public void setOrderingNumber(String Ordering_Number) {
        this.Ordering_Number = Ordering_Number;
    }

}

