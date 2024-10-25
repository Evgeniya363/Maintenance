package ru.gb.maintenance.services;

import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.Post;
import ru.gb.maintenance.model.dtos.PostDto;

@Service
public interface PostService extends BaseEntityService<Post, PostDto> {
}
