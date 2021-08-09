package com.meli.socialmeli.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class UserPromoPostsDTO {
    private Integer userId;
    private String userName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer promoProductsCount;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<PostDTO> posts;
}
