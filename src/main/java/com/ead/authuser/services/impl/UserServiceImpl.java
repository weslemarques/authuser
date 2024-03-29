package com.ead.authuser.services.impl;

import com.ead.authuser.dtos.UserCreateDTO;
import com.ead.authuser.enums.UserStatus;
import com.ead.authuser.enums.UserType;
import com.ead.authuser.models.UserModel;
import com.ead.authuser.repositories.UserRepository;
import com.ead.authuser.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService
{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserModel> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserModel> findById(UUID userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void delete(UserModel userModel) {
        userRepository.delete(userModel);
    }

    @Override
    public Object save(UserCreateDTO userCreateDTO) {
        var user = new UserModel();
        BeanUtils.copyProperties(userCreateDTO,user);
        user.setUserType(UserType.STUDENT);
        user.setUserStatus(UserStatus.ACTIVE);
        user = userRepository.save(user);
        return user;
    }
}
