package org.example.springblogrestful.repository;

import org.example.springblogrestful.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findAllByNameContains(String keyWord);

}
