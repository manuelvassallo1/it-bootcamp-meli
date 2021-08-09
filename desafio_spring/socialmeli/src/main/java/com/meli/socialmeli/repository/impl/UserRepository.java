package com.meli.socialmeli.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.socialmeli.exceptions.user.SameUserException;
import com.meli.socialmeli.exceptions.user.UserAlreadyFollowedException;
import com.meli.socialmeli.exceptions.user.UserNotFollowed;
import com.meli.socialmeli.exceptions.user.UserNotFoundException;
import com.meli.socialmeli.model.UserDTO;
import com.meli.socialmeli.repository.IUserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository implements IUserRepository {
    private static final String DB_PATH = "classpath:usersDB.json";
    private List<UserDTO> userDb = new ArrayList<>();
    private final Map<Integer, List<UserDTO>> followersMap = new HashMap<>();
    private final Map<Integer, List<UserDTO>> followedMap = new HashMap<>();

    public UserRepository() {
        File file = null;
        try {
            file = ResourceUtils.getFile(DB_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<UserDTO>> typeRef = new TypeReference<>() {
        };

        try {
            userDb = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addFollower(Integer userId, Integer userIdToFollow, List<UserDTO> users) {
        processFollow(userIdToFollow, userId, users, followersMap);
    }

    @Override
    public void addFollowed(Integer userId, Integer followerId, List<UserDTO> users) {
        processFollow(userId, followerId, users, followedMap);
    }

    private void processFollow(Integer u1, Integer u2, List<UserDTO> list, Map<Integer, List<UserDTO>> map) {
        if (u1.equals(u2)) {
            throw new SameUserException();
        }

        UserDTO user = getUserById(u2);
        if (list != null) {
            if (list.contains(user)) {
                throw new UserAlreadyFollowedException(u2, u1);
            }
            list.add(user);
        } else {
            List<UserDTO> newList = new ArrayList<>();
            newList.add(user);
            map.put(u1, newList);
        }
    }

    @Override
    public List<UserDTO> getAllFollowersByUserId(Integer userId) {
        return followersMap.get(userId);
    }

    @Override
    public List<UserDTO> getAllFollowedByUserId(Integer userId) {
        return followedMap.get(userId);
    }

    @Override
    public UserDTO getUserById(Integer userId) {
        return userDb.stream()
                .filter(u -> u.getUserId().equals(userId))
                .findAny()
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    @Override
    public void removeFollower(Integer userId, Integer userIdToUnfollow) {
        getUserById(userIdToUnfollow);
        processUnfollow(userIdToUnfollow, userId, followersMap);
    }

    @Override
    public void removeFollowed(Integer userId, Integer userIdToUnfollow) {
        getUserById(userId);
        processUnfollow(userId, userIdToUnfollow, followedMap);
    }

    private void processUnfollow(Integer id1, Integer id2, Map<Integer, List<UserDTO>> map) {
        if (id1.equals(id2)) {
            throw new SameUserException();
        }
        UserDTO user2 = getUserById(id2);
        List<UserDTO> users = map.get(id1);

        if (users != null) {
            users.remove(user2);
        } else {
            throw new UserNotFollowed(id2, id1);
        }

        if (map.get(id1).isEmpty()) {
            map.remove(id1);
        }
    }
}
