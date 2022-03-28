package com.example.test.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class AppUser {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private int id;
    private String username;
    private String email;
    private String phone;
    private String password;
    @Enumerated(EnumType.STRING)
    private Region region;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private String urlImage;

    private Boolean enabled=false;

    public AppUser(String username, String email, String phone, String password, AppUserRole appUserRole) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.appUserRole =appUserRole;
    }

}
