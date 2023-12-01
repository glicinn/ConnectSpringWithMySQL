package com.example.springmysql.newModels;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID;

    @Column(name = "User_Login")
    @NotBlank(message = "Логин не может быть пустым")
    @Size(max = 30, message = "Логин должен быть не более 30 символов")
    private String User_Login;

    @Column(name = "User_Password")
    @NotBlank(message = "Пароль не может быть пустым")
    @Size(max = 30, message = "Пароль должен быть не более 30 символов")
    private String User_Password;

    @Column(name = "Email")
    @NotBlank(message = "Почта не может быть пустой")
    @Size(max = 30, message = "Почта должна быть не более 30 символов")
    private String Email;

    @Column(name = "Balance")
    @Min(value = 0, message = "Баланс не может быть отрицательным")
    private int Balance;

    @Column(name = "Role")
    @NotBlank(message = "Роль не может быть пустой")
    @Size(max = 30, message = "Роль должна быть не более 30 символов")
    private String Role;


    public User(){}
    public User(int userID, String User_Login, String User_Password, String Email, int Balance, String Role) {
        this.userID = userID;
        this.User_Login = User_Login;
        this.User_Password = User_Password;
        this.Email = Email;
        this.Balance = Balance;
        this.Role = Role;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserLogin() {
        return User_Login;
    }

    public void setUserLogin(String User_Login) {
        this.User_Login = User_Login;
    }

    public String getUserPassword() {
        return User_Password;
    }

    public void setUserPassword(String User_Password) {
        this.User_Password = User_Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int Balance) {
        this.Balance = Balance;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

}

