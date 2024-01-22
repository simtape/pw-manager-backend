package it.unimol.pwmanager.controllers;

import it.unimol.pwmanager.models.dto.password.PasswordDto;
import it.unimol.pwmanager.models.dto.password.PasswordShortInfoDto;
import it.unimol.pwmanager.models.request.password.EditPasswordRequest;
import it.unimol.pwmanager.models.request.password.PatchPasswordGroup;
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
@RequestMapping("/password")
public class PasswordController {
    private final PasswordService passwordService;

    @Autowired
    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("")
    public Response<?> create(@Valid @RequestBody EditPasswordRequest editPasswordRequest) {
        this.passwordService.createPassword(editPasswordRequest);
        return new Response<>();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response<List<PasswordShortInfoDto>> read() {
        return new Response<>(this.passwordService.readPassword());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Response<PasswordDto> read(@PathVariable Long id) {
        return new Response<>(this.passwordService.readPassword(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Response<?> update(@PathVariable Long id, @Valid @RequestBody EditPasswordRequest editPasswordRequest) {
        this.passwordService.updatePassword(id, editPasswordRequest);
        return new Response<>();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public Response<?> delete(@PathVariable Long id) {
        this.passwordService.deletePassword(id);
        return new Response<>();
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}/expired")
    public Response<?> patchExpiredStatus(@PathVariable Long id) {
        this.passwordService.patchPasswordExpiredStatus(id);
        return new Response<>();
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}/group")
    public Response<?> patchGroup(@PathVariable Long id, @Valid @RequestBody PatchPasswordGroup patchPasswordGroup) {
        this.passwordService.patchPasswordGroup(id, patchPasswordGroup);
        return new Response<>();
    }
}