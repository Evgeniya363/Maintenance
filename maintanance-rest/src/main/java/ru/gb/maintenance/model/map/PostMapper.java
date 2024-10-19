package ru.gb.maintenance.model.map;

import org.mapstruct.Mapper;
import ru.gb.maintenance.model.Post;
import ru.gb.maintenance.model.dto.PostDto;

@Mapper(config = MappingConfiguration.class)
public interface PostMapper extends BaseMapper<Post, PostDto> {

    PostDto toDto(Post department);

}