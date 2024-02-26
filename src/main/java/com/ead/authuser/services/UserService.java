package com.ead.authuser.services;

import com.ead.authuser.dtos.UserCreateDTO;
import com.ead.authuser.models.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<UserModel> getAll();

    Optional<UserModel> findById(UUID userId);

    void delete(UserModel userModel);

    Object save(UserCreateDTO userCreateDTO);
}
