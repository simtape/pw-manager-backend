package it.unimol.pwmanager.controllers;

import it.unimol.pwmanager.models.dto.group.GroupDto;
import it.unimol.pwmanager.models.dto.group.GroupShortInfoDto;
import it.unimol.pwmanager.models.request.group.EditGroupRequest;
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
@RequestMapping("/tag")
public class GroupController {
    private final PasswordService passwordService;

    @Autowired
    public GroupController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("")
    public Response<?> create(@Valid @RequestBody EditGroupRequest editGroupRequest) {
        this.passwordService.createGroup(editGroupRequest);
        return new Response<>();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response<List<GroupShortInfoDto>> read() {
        return new Response<>(this.passwordService.readGroup());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Response<GroupDto> read(@PathVariable Long id) {
        return new Response<>(this.passwordService.readGroup(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Response<?> update(@PathVariable Long id, @Valid @RequestBody EditGroupRequest editGroupRequest) {
        this.passwordService.updateGroup(id, editGroupRequest);
        return new Response<>();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public Response<?> delete(@PathVariable Long id) {
        this.passwordService.deleteGroup(id);
        return new Response<>();
    }
}
