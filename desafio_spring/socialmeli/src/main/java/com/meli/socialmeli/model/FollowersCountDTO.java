package com.meli.socialmeli.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder()
public class FollowersCountDTO {
    private Integer userId;
    private String userName;
    private Integer followers_count;
}
