package com.meli.socialmeli.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class FollowedDTO {
    private Integer userId;
    private String userName;
    private List<UserDTO> followed;
}
