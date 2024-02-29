package com.ead.authuser.dtos;

import com.ead.authuser.enums.UserStatus;
import com.ead.authuser.enums.UserType;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserCreateDTO implements Serializable {
    private String username;
    private String  email;
    private String fullName;
    private String password;
    private UserStatus userStatus;
    private UserType userType;
    private String phoneNumber;
    private String cpf;
    private String imageUrl;
}
