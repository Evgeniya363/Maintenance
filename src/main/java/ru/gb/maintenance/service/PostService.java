package ru.gb.maintenance.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.Post;
import ru.gb.maintenance.repositiry.PostRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static java.lang.String.format;

@Service
public class PostService  extends EntityService<Post, PostRepository>{

    public PostService(PostRepository repository) {
        super(repository);
    }
}
