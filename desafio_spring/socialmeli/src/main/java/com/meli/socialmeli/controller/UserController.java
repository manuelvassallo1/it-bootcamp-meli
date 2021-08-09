package com.meli.socialmeli.controller;

import com.meli.socialmeli.model.FollowedDTO;
import com.meli.socialmeli.model.FollowersCountDTO;
import com.meli.socialmeli.model.FollowersDTO;
import com.meli.socialmeli.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    @ResponseStatus(HttpStatus.OK)
    public void followUser(@PathVariable Integer userId,
                           @PathVariable Integer userIdToFollow) {
        userService.followUser(userId, userIdToFollow);
    }

    @GetMapping("/users/{userId}/followers/count/")
    public FollowersCountDTO getFollowersCount(@PathVariable Integer userId) {
        return userService.getFollowersCountByUserId(userId);
    }

    @GetMapping("/users/{userId}/followers/list")
    public FollowersDTO getFollowers(@PathVariable Integer userId,
                                     @RequestParam(required = false) String order) {
        return userService.getAllFollowersByUserId(userId, order);
    }

    @GetMapping("/users/{userId}/followed/list")
    public FollowedDTO getFollowed(@PathVariable Integer userId,
                                   @RequestParam(required = false) String order) {
        return userService.getAllFollowedByUserId(userId, order);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    @ResponseStatus(HttpStatus.OK)
    public void unfollowUser(@PathVariable Integer userId,
                             @PathVariable Integer userIdToUnfollow) {
        userService.unfollowUser(userId, userIdToUnfollow);
    }
}
