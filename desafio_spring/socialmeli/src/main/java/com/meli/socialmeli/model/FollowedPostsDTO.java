package com.meli.socialmeli.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class FollowedPostsDTO {
    private Integer userId;
    private List<PostDTO> posts;
}
