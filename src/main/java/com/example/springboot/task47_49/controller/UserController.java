package com.example.springboot.task47_49.controller;

import com.example.springboot.task47_49.dao.PostsDao;
import com.example.springboot.task47_49.dao.UsersDao;
import com.example.springboot.task47_49.model.Posts;
import com.example.springboot.task47_49.model.Users;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@RestController
@Tag(name = "APIControllers", description = "Controllers task 47-49")
public class UserController {

    @Autowired
    PostsDao postsDao;

    @Autowired
    UsersDao usersDao;


    @GetMapping("/getFindById")
    public ResponseEntity<List<Posts>> getPostById(){
        List<Posts> posts = postsDao.findAllById(2);
        System.out.println(posts.toString());
        return  ResponseEntity.ok(posts);
    }
    @GetMapping("/getPostMore500")
    public ResponseEntity<List<Posts>> getPostMore500(){
        List<Posts> posts = postsDao.getPosts();
        System.out.println(posts.toString());
        return  ResponseEntity.ok(posts);
    }

    @GetMapping("/getUsersInfoWithPostMore500")
    public  ResponseEntity<List<Users>> getUsersInfoWithPostMore500(){
        List<Users> users = usersDao.getUsers();
        System.out.println(users.toString());
        return ResponseEntity.ok(users);
    }

    @PostMapping("upload")
    public ResponseEntity<InputStreamResource> upload(@RequestParam("file") MultipartFile file)
    {
        System.out.println(file.getOriginalFilename());
        try {
            file.transferTo(Path.of("d:\\1\\"+file.getOriginalFilename()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().build();


    }

}
