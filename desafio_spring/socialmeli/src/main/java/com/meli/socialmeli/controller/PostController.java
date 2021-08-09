package com.meli.socialmeli.controller;

import com.meli.socialmeli.model.FollowedPostsDTO;
import com.meli.socialmeli.model.PostDTO;
import com.meli.socialmeli.model.UserPromoPostsDTO;
import com.meli.socialmeli.service.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final IPostService postService;

    @PostMapping("/products/newpost")
    @ResponseStatus(HttpStatus.OK)
    public void addPost(@Valid @RequestBody PostDTO request) {
        postService.addPost(request);
    }

    @GetMapping("/products/followed/{userId}/list")
    public FollowedPostsDTO getFollowedPosts(@PathVariable Integer userId,
                                             @RequestParam(required = false) String order) {
        return postService.getFollowedPostsByUserId(userId, order);
    }

    @PostMapping("/products/newpromopost")
    @ResponseStatus(HttpStatus.OK)
    public void addPromoPost(@RequestBody PostDTO request) {
        postService.addPost(request);
    }

    @GetMapping("/products/{userId}/countPromo/")
    public UserPromoPostsDTO getCountPromo(@PathVariable Integer userId) {
        return postService.getCountPromo(userId);
    }

    @GetMapping("/products/{userId}/list/")
    public UserPromoPostsDTO getPromoPostsByUserId(@PathVariable Integer userId,
                                                   @RequestParam(required = false) String order) {
        return postService.getPromoPostsByUserId(userId, order);
    }
}
