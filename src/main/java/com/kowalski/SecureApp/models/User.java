package com.kowalski.SecureApp.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Фамилия не должна быть пустой!")
    @Size(min = 2,max = 100, message = "Фамилия должна содержать от 2 до 100 знаков.")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotEmpty(message = "Имя не должно быть пустым!")
    @Size(min = 2,max = 100, message = "Имя должно содержать от 2 до 100 знаков.")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Size(min = 2,max = 100, message = "Отчество должно содержать от 2 до 100 знаков.")
    @Column(name = "middle_name")
    private String middleName;

    @Min(value = 1900,message = "Укажите год рождения(больше чем 1900)")
    @Column(name = "birth_year")
    private Integer birthYear;

    @NotEmpty(message = "Укажите город!")
    @Column(name = "residence")
    private String residence;

    @Column(name = "info", columnDefinition = "text")
    private String info;

    @Column(name = "password")
    private String password;

    public User() {
    }


    public User(String lastName, String firstName, Integer birthYear, String residence) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthYear = birthYear;
        this.residence = residence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthYear=" + birthYear +
                ", residence='" + residence + '\'' +
                ", info='" + info + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
