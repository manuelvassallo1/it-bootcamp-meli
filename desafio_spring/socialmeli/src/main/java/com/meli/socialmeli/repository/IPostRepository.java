package com.meli.socialmeli.repository;

import com.meli.socialmeli.model.PostDTO;
import com.meli.socialmeli.model.UserDTO;

import java.util.List;

public interface IPostRepository {
    void addPost(PostDTO post);

    List<PostDTO> getFollowedPosts(List<UserDTO> users);

    List<PostDTO> getPostsByUserId(Integer userId);
}
