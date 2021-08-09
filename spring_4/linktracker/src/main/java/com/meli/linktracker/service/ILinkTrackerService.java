package com.meli.linktracker.service;

import com.meli.linktracker.model.MetricsDTO;
import com.meli.linktracker.model.RequestDTO;
import com.meli.linktracker.model.ResponseDTO;

public interface ILinkTrackerService {
    ResponseDTO createLink(RequestDTO request, String password);

    String getRedirectUrl(Integer id, String password);

    MetricsDTO getRedirections(Integer id);

    ResponseDTO invalidateLink(Integer id);

    ResponseDTO validateLink(Integer id);
}
