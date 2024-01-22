package it.unimol.pwmanager.controllers;

import it.unimol.pwmanager.models.dto.group.GroupDto;
import it.unimol.pwmanager.models.dto.group.GroupShortInfoDto;
import it.unimol.pwmanager.models.request.group.EditGroupRequest;
import it.unimol.pwmanager.models.request.websiteprofile.EditWebsiteProfileRequest;
import it.unimol.pwmanager.models.response.Response;
import it.unimol.pwmanager.services.PasswordService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@CrossOrigin
@RestController
@RequestMapping("/website-profile")
public class WebsiteProfileController {
    private final PasswordService passwordService;

    @Autowired
    public WebsiteProfileController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("")
    public Response<?> create(@Valid @RequestBody EditWebsiteProfileRequest editWebsiteProfileRequest) {
        this.passwordService.createWebsiteProfile(editWebsiteProfileRequest);
        return new Response<>();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Response<?> update(@PathVariable Long id, @Valid @RequestBody EditWebsiteProfileRequest editWebsiteProfileRequest) {
        this.passwordService.updateWebsiteProfile(id, editWebsiteProfileRequest);
        return new Response<>();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public Response<?> delete(@PathVariable Long id) {
        this.passwordService.deleteWebsiteProfile(id);
        return new Response<>();
    }
}