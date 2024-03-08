package org.example.springblogrestful.controller;

import com.google.protobuf.Internal;
import org.example.springblogrestful.model.Blog;
import org.example.springblogrestful.repository.IBlogRepository;
import org.example.springblogrestful.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping
    public ResponseEntity findAllBlog() {
        List<Blog> blogList = (List<Blog>) iBlogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findBlogById(@PathVariable int id) {
        Optional<Blog> blogOptional = iBlogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveBlog(@RequestBody Blog blog) {
        return new ResponseEntity<>(iBlogService.save(blog), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        Optional<Blog> blogOptional = iBlogService.findById(id);
        iBlogService.remove(id);
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody Blog blog) {
        Optional<Blog> blogOptional = iBlogService.findById(id);
        blog.setId(blogOptional.get().getId());
        return new ResponseEntity<>(iBlogService.save(blog), HttpStatus.OK);
    }
    @GetMapping("/findByName")
    public ResponseEntity findByName(@RequestParam String name){
        return new ResponseEntity<>(iBlogService.findByNameContaining(name), HttpStatus.OK);
    }
}
