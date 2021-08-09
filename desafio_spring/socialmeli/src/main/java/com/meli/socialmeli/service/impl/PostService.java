package com.meli.socialmeli.service.impl;

import com.meli.socialmeli.exceptions.post.PostsNotFound;
import com.meli.socialmeli.model.FollowedPostsDTO;
import com.meli.socialmeli.model.PostDTO;
import com.meli.socialmeli.model.UserDTO;
import com.meli.socialmeli.model.UserPromoPostsDTO;
import com.meli.socialmeli.repository.IPostRepository;
import com.meli.socialmeli.repository.IUserRepository;
import com.meli.socialmeli.service.IPostService;
import com.meli.socialmeli.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {
    private final IUserRepository userRepository;
    private final IPostRepository postRepository;
    private static final String FOLLOWED = "followed";
    private final IUserService userService;
    private static final List<String> ORDER = Arrays.asList("date_asc", "date_desc", "productName_asc", "productName_desc");


    @Override
    public void addPost(PostDTO post) {
        postRepository.addPost(post);
    }

    @Override
    public FollowedPostsDTO getFollowedPostsByUserId(Integer userId, String order) {
        List<UserDTO> fwd = userService.getUsers(userId, FOLLOWED);
        List<PostDTO> posts = postRepository.getFollowedPosts(fwd);

        if (posts.isEmpty()) {
            throw new PostsNotFound(userId);
        }

        return FollowedPostsDTO.builder()
                .userId(userId)
                .posts(sortPosts(order, posts))
                .build();
    }

    @Override
    public UserPromoPostsDTO getCountPromo(Integer userId) {
        UserDTO user = userRepository.getUserById(userId);
        List<PostDTO> posts = postRepository.getPostsByUserId(userId);

        return UserPromoPostsDTO.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .promoProductsCount(posts.size())
                .build();
    }

    @Override
    public UserPromoPostsDTO getPromoPostsByUserId(Integer userId, String order) {
        UserDTO user = userRepository.getUserById(userId);
        List<PostDTO> posts = postRepository.getPostsByUserId(userId);

        if (posts.isEmpty()) {
            throw new PostsNotFound();
        }

        return UserPromoPostsDTO.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .posts(sortPosts(order, posts))
                .build();
    }

    private List<PostDTO> sortPosts(String order, List<PostDTO> posts) {
        if (!ORDER.contains(order)) {
            return posts;
        }

        switch (order) {
            case "date_asc":
                posts.sort(Comparator.comparing(PostDTO::getDate));
                break;
            case "date_desc":
                posts.sort(Comparator.comparing(PostDTO::getDate).reversed());
                break;
            case "productName_asc":
                posts.sort(Comparator.comparing(p -> p.getDetail().getProductName()));
                break;
            case "productName_desc":
                posts.sort(Comparator.comparing(p -> p.getDetail().getProductName(), Comparator.reverseOrder()));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + order);
        }
        return posts;
    }
}
