package com.meli.socialmeli.service;

import com.meli.socialmeli.model.FollowedPostsDTO;
import com.meli.socialmeli.model.PostDTO;
import com.meli.socialmeli.model.UserPromoPostsDTO;

public interface IPostService {
    void addPost(PostDTO post);

    FollowedPostsDTO getFollowedPostsByUserId(Integer userId, String order);

    UserPromoPostsDTO getCountPromo(Integer userId);

    UserPromoPostsDTO getPromoPostsByUserId(Integer userId, String order);
}
