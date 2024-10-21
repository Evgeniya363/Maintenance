package ru.gb.maintenance.service;

import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.Post;
import ru.gb.maintenance.model.dto.PostDto;
import ru.gb.maintenance.model.map.PostMapper;
import ru.gb.maintenance.repositiry.PostRepository;

@Service
public class PostServiceImpl extends BaseEntityServiceImpl<Post, PostDto, PostMapper> implements PostService {

    public PostServiceImpl(PostRepository postRepository, PostMapper mapper) {
        super(postRepository, mapper);
    }
}
