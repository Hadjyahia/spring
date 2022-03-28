package com.example.test.models;

import lombok.*;


@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class RegistrationRequest {

    private final String username;
    private final String email;
    private final String phone;
    private final String password;
    private final AppUserRole appUserRole;

}
