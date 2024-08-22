package ru.gb.maintenance.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gb.maintenance.model.Post;
import ru.gb.maintenance.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController extends EntityController<Post, PostService>{

    public PostController(PostService service) {
        super(service);
    }
}
