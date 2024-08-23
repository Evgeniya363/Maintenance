package ru.gb.maintenance.service;

import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.Post;
import ru.gb.maintenance.repositiry.PostRepository;

@Service
public class PostService  extends EntityService<Post, PostRepository>{

    public PostService(PostRepository repository) {
        super(repository);
    }
}
