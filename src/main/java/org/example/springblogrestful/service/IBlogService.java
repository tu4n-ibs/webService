package org.example.springblogrestful.service;

import org.example.springblogrestful.model.Blog;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog> {
    List<Blog> findByNameContaining(String name);
}
