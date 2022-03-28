package com.example.test.models;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Data
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="token_id")
    private long tokenid;

    @Column(name="confirmation_token")
    private String confirmationToken;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    //@OneToOne(targetEntity = AppUser.class, fetch = FetchType.EAGER)
    //@JoinColumn(nullable = false, name = "user_id")
    @OneToOne
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;

    public ConfirmationToken() {}

    public ConfirmationToken(AppUser appUser) {
        this.appUser = appUser;
        createdDate = new Date();
        confirmationToken = UUID.randomUUID().toString();
    }
}