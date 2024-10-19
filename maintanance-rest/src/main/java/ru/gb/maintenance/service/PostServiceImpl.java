package ru.gb.maintenance.service;

import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.Post;
import ru.gb.maintenance.model.dto.PostDto;
import ru.gb.maintenance.model.map.PostMapperImpl;
import ru.gb.maintenance.repositiry.BaseEntityRepository;
import ru.gb.maintenance.repositiry.PostRepository;

@Service
public class PostServiceImpl extends BaseEntityServiceImpl<Post, PostDto, PostMapperImpl> implements PostService {

    public PostServiceImpl(PostRepository postRepository, PostMapperImpl mapper) {
        super(postRepository, mapper);
    }
}
