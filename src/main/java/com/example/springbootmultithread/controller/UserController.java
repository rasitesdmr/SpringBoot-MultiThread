package com.example.springbootmultithread.controller;

import com.example.springbootmultithread.model.User;
import com.example.springbootmultithread.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/thread")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/createUser", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = "application/json")
    public ResponseEntity createUser(@RequestParam(value = "files") MultipartFile[] multipartFiles) throws Exception {
        for (MultipartFile file : multipartFiles) {
            userService.createUser(file);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping(value = "/getAllUsersList", produces = "application/json")
    public CompletableFuture<ResponseEntity> findAllUsers() {
        return  userService.findAllUsers().thenApply(ResponseEntity::ok);
    }


    @GetMapping(value = "/threeThread", produces = "application/json")
    public  ResponseEntity getThreeUsers()  {
        CompletableFuture<List<User>> users1=userService.findAllUsers();
        CompletableFuture<List<User>> users2=userService.findAllUsers();
        CompletableFuture<List<User>> users3=userService.findAllUsers();

        CompletableFuture.allOf(users1,users2,users3).join();

        return  ResponseEntity.status(HttpStatus.OK).build();
    }



    @GetMapping(value = "/sixThread", produces = "application/json")
    public  ResponseEntity getSixUsers()  {
            CompletableFuture<List<User>> users1=userService.findAllUsers();
            CompletableFuture<List<User>> users2=userService.findAllUsers();
            CompletableFuture<List<User>> users3=userService.findAllUsers();
            CompletableFuture<List<User>> users4=userService.findAllUsers();
            CompletableFuture<List<User>> users5=userService.findAllUsers();
            CompletableFuture<List<User>> users6=userService.findAllUsers();

            CompletableFuture.allOf(users1,users2,users3,users4,users5,users6).join();

        return  ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(value = "/tenThread", produces = "application/json")
    public  ResponseEntity getTenUsers()  {
        CompletableFuture<List<User>> users1=userService.findAllUsers();
        CompletableFuture<List<User>> users2=userService.findAllUsers();
        CompletableFuture<List<User>> users3=userService.findAllUsers();
        CompletableFuture<List<User>> users4=userService.findAllUsers();
        CompletableFuture<List<User>> users5=userService.findAllUsers();
        CompletableFuture<List<User>> users6=userService.findAllUsers();
        CompletableFuture<List<User>> users7=userService.findAllUsers();
        CompletableFuture<List<User>> users8=userService.findAllUsers();
        CompletableFuture<List<User>> users9=userService.findAllUsers();
        CompletableFuture<List<User>> users10=userService.findAllUsers();

        CompletableFuture.allOf(users1,users2,users3,users4,users5,users6,users7,users8,users9,users10).join();

        return  ResponseEntity.status(HttpStatus.OK).build();
    }


}
