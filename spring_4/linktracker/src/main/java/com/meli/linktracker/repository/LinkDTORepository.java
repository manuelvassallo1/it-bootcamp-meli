package com.meli.linktracker.repository;

import com.meli.linktracker.model.ResponseDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository
public class LinkDTORepository implements ILinkDTORepository {
    private final Map<Integer, ResponseDTO> linkMap = new HashMap<>();
    private Integer id = 0;

    @Override
    public ResponseDTO save(ResponseDTO responseDTO) {
        responseDTO.setId(id);
        linkMap.put(id, responseDTO);
        id++;
        return responseDTO;
    }

    @Override
    public ResponseDTO getByLinkId(Integer id) {
        return linkMap.get(id);
    }

    @Override
    public ResponseDTO changeLinkStatus(boolean isActive, ResponseDTO dto) {
        dto.setActive(isActive);
        return dto;
    }

    @Override
    public Boolean isDuplicate(String url) {
        return getAll().stream().anyMatch(l -> l.getUrl().equals(url));
    }

    private Set<ResponseDTO> getAll() {
        return new HashSet<>(linkMap.values());
    }

}
