package ru.gb.maintenance.model.maps;

import org.mapstruct.Mapper;
import ru.gb.maintenance.model.Post;
import ru.gb.maintenance.model.dtos.PostDto;

@Mapper(config = MappingConfiguration.class)
public interface PostMapper extends BaseMapper<Post, PostDto> {
    PostDto toDto(Post department);
}