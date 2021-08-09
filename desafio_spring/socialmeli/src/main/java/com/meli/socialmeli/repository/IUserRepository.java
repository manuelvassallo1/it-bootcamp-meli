package com.meli.socialmeli.repository;

import com.meli.socialmeli.model.UserDTO;

import java.util.List;

public interface IUserRepository {
    void addFollower(Integer userId, Integer userIdToFollow, List<UserDTO> users);

    void addFollowed(Integer userId, Integer followerId, List<UserDTO> users);

    List<UserDTO> getAllFollowersByUserId(Integer userId);

    List<UserDTO> getAllFollowedByUserId(Integer userId);

    UserDTO getUserById(Integer userId);

    void removeFollower(Integer userId, Integer userIdToUnfollow);

    void removeFollowed(Integer userId, Integer userIdToUnfollow);
}
