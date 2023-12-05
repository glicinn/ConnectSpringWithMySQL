package com.example.springmysql.newModels;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Benefit")
public class Benefit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int benefitID;

    @Column(name = "Benefit_Name")
    @NotBlank(message = "Название льготы не может быть пустым")
    @Size(max = 100, message = "Название льготы должно быть не более 100 символов")
    private String Benefit_Name;

    @Column(name = "Benefit_Discount")
    @Min(value = 0, message = "Размер скидки не может быть отрицательным")
    private int Benefit_Discount;



    public Benefit(){}
    public Benefit(int benefitID, String Benefit_Name, int Benefit_Discount) {
        this.benefitID = benefitID;
        this.Benefit_Name = Benefit_Name;
        this.Benefit_Discount = Benefit_Discount;
    }

    public int getBenefitID() {
        return benefitID;
    }

    public void setBenefitID(int benefitID) {
        this.benefitID = benefitID;
    }

    public String getBenefitName() {
        return Benefit_Name;
    }

    public void setBenefitName(String Benefit_Name) {
        this.Benefit_Name = Benefit_Name;
    }

    public int getBenefitDiscount() {
        return Benefit_Discount;
    }

    public void setBenefitDiscount(int Benefit_Discount) {
        this.Benefit_Discount = Benefit_Discount;
    }


}

