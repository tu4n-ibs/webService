package org.example.springblogrestful.service;

import org.example.springblogrestful.model.Blog;
import org.example.springblogrestful.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return iBlogRepository.findAll();
    }


    @Override
    public Optional<Blog> findById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return iBlogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        iBlogRepository.deleteById(id);
    }

    public List<Blog> findByNameContaining(String name) {
        return iBlogRepository.findAllByNameContains(name);
    }
}
