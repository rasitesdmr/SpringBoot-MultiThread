package com.example.springbootmultithread.service;

import com.example.springbootmultithread.model.User;
import com.example.springbootmultithread.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;


    @Override
    @Async
    public CompletableFuture<List<User>> createUser(MultipartFile multipartFile) throws Exception {
        long start = System.currentTimeMillis();
        List<User> users = parseCSVFile(multipartFile);
        log.info("saving list of users of size {}", users.size(), "" + Thread.currentThread().getName());
        users = userRepository.saveAll(users);
        long end = System.currentTimeMillis();
        log.info("Toplam Geçen Zaman :" +( end - start));
        return CompletableFuture.completedFuture(users);
    }

    @Override
    @Async
    public CompletableFuture<List<User>> findAllUsers() {
        log.info(Thread.currentThread().getName());
        List<User> users = userRepository.findAll();
        return CompletableFuture.completedFuture(users);
    }

    private List<User> parseCSVFile(final MultipartFile multipartFile) throws Exception{
         List<User> users = new ArrayList<>();
        try {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()));
            String line ;
            while((line = bufferedReader.readLine()) != null){
            final String[] data = line.split(",");
            final User  user = new User();
            user.setUsername(data[0]);
            user.setEmail(data[1]);
            user.setGender(data[2]);
            users.add(user);
            }
            return users;

        }catch (final Exception exception){
            log.error("CSV dosyası ayrıştırılamadı {}" , exception);
            throw new Exception("CSV dosyası ayrıştırılamadı {}" , exception);

        }
    }
}
