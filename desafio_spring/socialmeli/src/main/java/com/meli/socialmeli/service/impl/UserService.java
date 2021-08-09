package com.meli.socialmeli.service.impl;

import com.meli.socialmeli.exceptions.user.FollowersNotFound;
import com.meli.socialmeli.model.FollowedDTO;
import com.meli.socialmeli.model.FollowersCountDTO;
import com.meli.socialmeli.model.FollowersDTO;
import com.meli.socialmeli.model.UserDTO;
import com.meli.socialmeli.repository.IUserRepository;
import com.meli.socialmeli.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private static final String FOLLOWERS = "followers";
    private static final String FOLLOWED = "followed";
    private static final List<String> ORDER = Arrays.asList("name_asc", "name_desc");

    @Override
    public void followUser(Integer userId, Integer userIdToFollow) {
        userRepository.addFollower(userId, userIdToFollow, userRepository.getAllFollowersByUserId(userIdToFollow));
        userRepository.addFollowed(userId, userIdToFollow, userRepository.getAllFollowedByUserId(userId));
    }

    @Override
    public FollowersCountDTO getFollowersCountByUserId(Integer userId) {
        UserDTO user = userRepository.getUserById(userId);
        List<UserDTO> fws = getUsers(userId, FOLLOWERS);

        return FollowersCountDTO.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .followers_count(fws.size())
                .build();
    }

    @Override
    public FollowersDTO getAllFollowersByUserId(Integer userId, String order) {
        UserDTO user = userRepository.getUserById(userId);
        List<UserDTO> fws = getUsers(userId, FOLLOWERS);

        return FollowersDTO.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .followers(sortUsers(order, fws))
                .build();
    }

    @Override
    public FollowedDTO getAllFollowedByUserId(Integer userId, String order) {
        UserDTO user = userRepository.getUserById(userId);
        List<UserDTO> fwd = getUsers(userId, FOLLOWED);

        return FollowedDTO.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .followed(sortUsers(order, fwd))
                .build();
    }

    @Override
    public void unfollowUser(Integer userId, Integer userIdToUnfollow) {
        userRepository.removeFollower(userId, userIdToUnfollow);
        userRepository.removeFollowed(userId, userIdToUnfollow);
    }

    @Override
    public List<UserDTO> getUsers(Integer userId, String source) {
        List<UserDTO> users = new ArrayList<>();

        if (FOLLOWERS.equals(source)) {
            users = userRepository.getAllFollowersByUserId(userId);
        } else if (FOLLOWED.equals(source)) {
            users = userRepository.getAllFollowedByUserId(userId);
        }

        if (users == null) {
            throw new FollowersNotFound();
        }
        return users;
    }

    private List<UserDTO> sortUsers(String order, List<UserDTO> users) {
        if (!ORDER.contains(order)) {
            return users;
        }

        if ("name_asc".equals(order)) {
            users.sort(Comparator.comparing(UserDTO::getUserName));

        } else if ("name_desc".equals(order)) {
            users.sort(Comparator.comparing(UserDTO::getUserName).reversed());
        }
        return users;
    }
}
