package com.example.springbootmultithread.service;

import com.example.springbootmultithread.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface UserService {

    CompletableFuture<List<User>> createUser(MultipartFile multipartFile) throws Exception;
    CompletableFuture<List<User>> findAllUsers();
}
