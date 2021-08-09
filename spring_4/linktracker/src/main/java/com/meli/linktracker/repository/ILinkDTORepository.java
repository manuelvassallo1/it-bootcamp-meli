package com.meli.linktracker.repository;

import com.meli.linktracker.model.ResponseDTO;

public interface ILinkDTORepository {
    ResponseDTO save(ResponseDTO responseDTO);

    ResponseDTO getByLinkId(Integer id);

    ResponseDTO changeLinkStatus(boolean isActive, ResponseDTO dto);

    Boolean isDuplicate(String url);

}
