package ru.gb.maintenance.service;

import org.springframework.stereotype.Service;
import ru.gb.maintenance.model.Post;
import ru.gb.maintenance.model.dto.PostDto;
import ru.gb.maintenance.model.map.PostMapper;

@Service
public interface PostService extends BaseEntityService<Post, PostDto> {
}
