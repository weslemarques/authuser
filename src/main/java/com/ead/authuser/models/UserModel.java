package com.ead.authuser.models;

import com.ead.authuser.enums.UserStatus;
import com.ead.authuser.enums.UserType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_USERS")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    @Column(unique = true,length = 50, nullable = false)
    private String username;
    @Column(unique = true,length = 50, nullable = false)
    private String  email;
    @Column(length = 150, nullable = false)
    private String fullName;
    @Column(length = 255, nullable = false)
    @JsonIgnore
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserStatus userStatus;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType userType;

    @Column(length = 20)
    private String phoneNumber;
    @Column(length = 20)
    private String cpf;

    private String imageUrl;
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime creationDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(nullable = false)
    private LocalDateTime lastUpdateDate;

}
