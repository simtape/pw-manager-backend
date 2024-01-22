package it.unimol.pwmanager.models.dto.websiteprofile;

import it.unimol.pwmanager.models.dto.group.GroupDto;
import it.unimol.pwmanager.models.dto.password.PasswordShortInfoDto;

import java.util.List;

public class WebsiteProfileDto {
    private String name;
    private String surname;
    private String email;
    private List<PasswordShortInfoDto> todoList;
    private List<GroupDto> tagList;
}
