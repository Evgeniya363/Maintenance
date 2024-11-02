package ru.gb.maintenance.services;

import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.Post;
import ru.gb.maintenance.model.dtos.PostDto;
import ru.gb.maintenance.model.maps.PostMapper;
import ru.gb.maintenance.repositories.PostRepository;

@Service
public class PostServiceImpl extends BaseEntityServiceImpl<Post, PostDto, PostMapper> implements PostService {
    public PostServiceImpl(PostRepository postRepository, PostMapper mapper) {
        super(postRepository, mapper);
    }
}
