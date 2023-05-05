package com.kowalski.SecureApp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email", nullable = false)
    @NotBlank
    @Size(max = 128)
    private String email;

    @NotEmpty(message = "Фамилия не должна быть пустой!")
    @Size(min = 2, max = 100, message = "Фамилия должна содержать от 2 до 100 знаков.")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotEmpty(message = "Имя не должно быть пустым!")
    @Size(min = 2, max = 100, message = "Имя должно содержать от 2 до 100 знаков.")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Size(min = 2, max = 100, message = "Отчество должно содержать от 2 до 100 знаков.")
    @Column(name = "middle_name")
    private String middleName;

    @Min(value = 1900, message = "Укажите год рождения(больше чем 1900)")
    @Column(name = "birth_year")
    private Integer birthYear;

    @NotEmpty(message = "Укажите город!")
    @Column(name = "residence")
    private String residence;

    @Column(name = "info", columnDefinition = "text")
    private String info;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "role"}, name = "uk_user_role"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinColumn
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Role> roles;

    public User(String lastName, String firstName, Integer birthYear, String residence) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthYear = birthYear;
        this.residence = residence;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ? EnumSet.noneOf(Role.class) : EnumSet.copyOf(roles);
    }
    public boolean hasRole(Role role) {
        return roles != null && roles.contains(role);
    }
}
