package ru.gb.maintenance.controller;

import org.springframework.web.bind.annotation.*;
import ru.gb.maintenance.model.Post;
import ru.gb.maintenance.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController extends EntityController<Post, PostService>{

    public PostController(PostService service) {
        super(service);
    }
}
