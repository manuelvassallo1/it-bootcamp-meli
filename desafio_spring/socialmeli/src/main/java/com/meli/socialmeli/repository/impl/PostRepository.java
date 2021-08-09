package com.meli.socialmeli.repository.impl;

import com.meli.socialmeli.model.PostDTO;
import com.meli.socialmeli.model.UserDTO;
import com.meli.socialmeli.repository.IPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PostRepository implements IPostRepository {
    private final List<PostDTO> posts = new ArrayList<>();

    @Override
    public void addPost(PostDTO post) {
        posts.add(post);
    }

    @Override
    public List<PostDTO> getFollowedPosts(List<UserDTO> users) {
        List<Integer> uList = users.stream()
                .map(UserDTO::getUserId)
                .collect(Collectors.toList());

        LocalDate after = LocalDate.now().minusDays(13);
        LocalDate now = LocalDate.now().plusDays(1);

        return posts.stream()
                .filter(p -> uList.contains(p.getUserId()) &&
                        p.getDate().isBefore(now) &&
                        p.getDate().isAfter(after))
                .sorted(Comparator.comparing(PostDTO::getDate).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDTO> getPostsByUserId(Integer userId) {

        return posts.stream()
                .filter(p -> p.getUserId().equals(userId) &&
                        p.getHasPromo() != null && p.getHasPromo())
                .collect(Collectors.toList());
    }
}
