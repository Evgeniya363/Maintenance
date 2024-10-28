package ru.gb.maintenance.model.maps;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.gb.maintenance.model.Post;
import ru.gb.maintenance.model.dtos.PostDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-28T22:58:19+0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public Post toEntity(PostDto d) {
        if ( d == null ) {
            return null;
        }

        Post post = new Post();

        post.setId( d.getId() );
        post.setName( d.getName() );

        return post;
    }

    @Override
    public List<PostDto> toDtoS(List<Post> listT) {
        if ( listT == null ) {
            return null;
        }

        List<PostDto> list = new ArrayList<PostDto>( listT.size() );
        for ( Post post : listT ) {
            list.add( toDto( post ) );
        }

        return list;
    }

    @Override
    public PostDto toDto(Post department) {
        if ( department == null ) {
            return null;
        }

        PostDto postDto = new PostDto();

        postDto.setId( department.getId() );
        postDto.setName( department.getName() );

        return postDto;
    }
}
