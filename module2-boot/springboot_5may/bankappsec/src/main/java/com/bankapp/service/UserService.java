package com.bankapp.service;

import com.bankapp.entites.UserEntity;

public interface UserService {
    public UserEntity findByUsername(String username);
    public void  addUserEntity(UserEntity userEntity);
}
