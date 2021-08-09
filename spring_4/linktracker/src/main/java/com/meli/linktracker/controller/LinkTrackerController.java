package com.meli.linktracker.controller;

import com.meli.linktracker.model.MetricsDTO;
import com.meli.linktracker.model.RequestDTO;
import com.meli.linktracker.model.ResponseDTO;
import com.meli.linktracker.service.ILinkTrackerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RequiredArgsConstructor
@RestController
public class LinkTrackerController {

    private final ILinkTrackerService service;

    @PostMapping("/createLink")
    public ResponseDTO createLink(@RequestBody RequestDTO request,
                                  @RequestParam(required = false) String password) {
        return service.createLink(request, password);
    }

    @GetMapping("/link/{id}")
    public RedirectView redirect(@PathVariable Integer id,
                                 @RequestParam(required = false) String password) {
        String urlToRedirect = service.getRedirectUrl(id, password);
        return new RedirectView(urlToRedirect);
    }

    @GetMapping("/metrics/{linkID}")
    public MetricsDTO metrics(@PathVariable Integer linkID) {
        return service.getRedirections(linkID);
    }

    @PostMapping("/invalidate/{linkID}")
    public ResponseDTO invalidate(@PathVariable Integer linkID) {
        return service.invalidateLink(linkID);
    }

    @PostMapping("/validate/{linkID}")
    public ResponseDTO validate(@PathVariable Integer linkID) {
        return service.validateLink(linkID);
    }
}
