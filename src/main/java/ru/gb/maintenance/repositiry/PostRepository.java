package ru.gb.maintenance.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.maintenance.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
