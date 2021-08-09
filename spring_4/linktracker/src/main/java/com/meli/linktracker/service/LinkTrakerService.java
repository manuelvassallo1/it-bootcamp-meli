package com.meli.linktracker.service;

import com.meli.linktracker.exceptions.*;
import com.meli.linktracker.model.MetricsDTO;
import com.meli.linktracker.model.RequestDTO;
import com.meli.linktracker.model.ResponseDTO;
import com.meli.linktracker.repository.ILinkDTORepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LinkTrakerService implements ILinkTrackerService {

    private final ILinkDTORepository repository;
    private final UrlValidator urlValidator = new UrlValidator();

    @Override
    public ResponseDTO createLink(RequestDTO request, String password) {
        String url = request.getUrl();
        checkUrl(url);
        ResponseDTO responseDTO = new ResponseDTO(url, password);
        return repository.save(responseDTO);
    }

    @Override
    public String getRedirectUrl(Integer id, String pass) {
        ResponseDTO dto = repository.getByLinkId(id);

        checkActiveLink(dto, id);
        checkPassword(dto.getPassword(), pass);

        MetricsDTO metricsDTO = dto.getMetricsDTO();
        metricsDTO.setRedirections(metricsDTO.getRedirections() + 1);
        return dto.getUrl();
    }

    @Override
    public MetricsDTO getRedirections(Integer id) {
        ResponseDTO dto = repository.getByLinkId(id);
        checkActiveLink(dto, id);
        return dto.getMetricsDTO();
    }

    @Override
    public ResponseDTO invalidateLink(Integer id) {
        return changeLinkStatus(false, id);
    }

    @Override
    public ResponseDTO validateLink(Integer id) {
        return changeLinkStatus(true, id);
    }

    private void checkUrl(String url) {
        if (!urlValidator.isValid(url)) {
            throw new NotValidException(url);
        }
        if (isDuplicate(url)) {
            throw new AlreadyInDatabaseException(url);
        }
    }

    private void checkActiveLink(ResponseDTO dto, Integer id) {
        if (dto == null) {
            throw new NotFoundException(id);
        }
        if (!dto.isActive()) {
            throw new NotActiveException(id);
        }
    }

    private ResponseDTO changeLinkStatus(boolean validate, Integer id) {
        ResponseDTO dto = repository.getByLinkId(id);
        if (dto == null) {
            throw new NotFoundException(id);
        }
        if (validate && dto.isActive()) {
            throw new AlreadyActiveException(id);
        } else if (!dto.isActive() && !validate) {
            throw new NotActiveException(id);
        }

        return repository.changeLinkStatus(validate, dto);
    }

    private boolean isDuplicate(String url) {
        return repository.isDuplicate(url);
    }

    private void checkPassword(String dtoPass, String pass) {
        if (!Objects.equals(dtoPass, pass)) {
            throw new InvalidPasswordException();
        }
    }
}
