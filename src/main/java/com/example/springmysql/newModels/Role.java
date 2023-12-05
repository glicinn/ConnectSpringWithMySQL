package com.example.springmysql.newModels;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roleID;

    @Column(name = "Role_Name")
    @NotBlank(message = "Название роли не может быть пустым")
    @Size(max = 30, message = "Название роли должно быть не более 30 символов")
    private String Role_Name;



    public Role(){}
    public Role(int roleID, String Role_Name) {
        this.roleID = roleID;
        this.Role_Name = Role_Name;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return Role_Name;
    }

    public void setRoleName(String Role_Name) {
        this.Role_Name = Role_Name;
    }


}

