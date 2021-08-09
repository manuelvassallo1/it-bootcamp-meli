package com.meli.socialmeli.service;

import com.meli.socialmeli.model.FollowedDTO;
import com.meli.socialmeli.model.FollowersCountDTO;
import com.meli.socialmeli.model.FollowersDTO;
import com.meli.socialmeli.model.UserDTO;

import java.util.List;

public interface IUserService {
    void followUser(Integer userId, Integer userIdToFollow);

    FollowersCountDTO getFollowersCountByUserId(Integer userId);

    FollowersDTO getAllFollowersByUserId(Integer userId, String order);

    FollowedDTO getAllFollowedByUserId(Integer userId, String order);

    void unfollowUser(Integer userId, Integer userIdToUnfollow);

    List<UserDTO> getUsers(Integer userId, String source);
}
