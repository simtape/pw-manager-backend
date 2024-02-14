package it.unimol.pwmanager.services;

import it.unimol.pwmanager.models.dto.group.GroupDto;
import it.unimol.pwmanager.models.dto.group.GroupShortInfoDto;
import it.unimol.pwmanager.models.dto.password.PasswordDto;
import it.unimol.pwmanager.models.dto.password.PasswordShortInfoDto;
import it.unimol.pwmanager.models.entities.Group;
import it.unimol.pwmanager.models.entities.Password;
import it.unimol.pwmanager.models.entities.WebsiteProfile;
import it.unimol.pwmanager.models.request.group.EditGroupRequest;
import it.unimol.pwmanager.models.request.password.EditPasswordRequest;
import it.unimol.pwmanager.models.request.password.PatchPasswordGroup;
import it.unimol.pwmanager.models.request.websiteprofile.EditWebsiteProfileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class PasswordService {
    private List<Password> passwords = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();
    private List<WebsiteProfile> websiteProfiles = new ArrayList<>();
    private int passwordIdCounter;
    private int doerIdCounter;
    private int tagIdCounter;
    private ByteArrayOutputStream outputStream;

    @Autowired()
    public PasswordService() {
        this.passwordIdCounter = 0;
        this.doerIdCounter = 0;
        this.tagIdCounter = 0;
    }

    public void createPassword(EditPasswordRequest editPasswordRequest) {
        Group group = groups.stream()
                .filter(g -> g.getId().equals(editPasswordRequest.getGroupId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Group not found"));

        WebsiteProfile websiteProfile = websiteProfiles.stream()
                .filter(wp -> wp.getId().equals(editPasswordRequest.getWebsiteProfileId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Website profile not found"));

        Password password = new Password(passwordIdCounter++,
                editPasswordRequest.getTitle(),
                editPasswordRequest.getPassword(),
                group,
                websiteProfile);
        passwords.add(password);

        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    public PasswordDto readPassword(Long id) {
        return passwords.stream()
                .filter(p -> p.getId().equals(id))
                .map(PasswordDto::new)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Password not found"));
    }

    public List<PasswordShortInfoDto> readPassword() {
        return passwords.stream()
                .map(PasswordShortInfoDto::new)
                .toList();
    }

    public void deletePassword(Long id) {
        Password password = passwords.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Password not found"));
        passwords.remove(password);
    }

    public void updatePassword(Long id, EditPasswordRequest editPasswordRequest) {
        // check if password is at least 8 characters long and max 20 characters long,
        // has at least one uppercase letter, one lowercase letter, one number and one
        // special character
        if (!editPasswordRequest
                .getPassword()
                .matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$")) {
            throw new RuntimeException(
                    "Password must be at least 8 characters long and max 20 characters long, has at least one uppercase letter, one lowercase letter, one number and one special character");
        }

        // name can't be blank, must be max 50 characters long, çan't be blank cant only contain numbers or special letters
        if (editPasswordRequest.getTitle().isBlank() || editPasswordRequest.getTitle().length() > 50
                || !editPasswordRequest.getTitle().matches("^[a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]*$")) {
            throw new RuntimeException("Name can't be blank, must be max 50 characters long, çan't be blank cant only contain numbers or special letters");
        }

        // find group id, if not exists throw exception
        Group group = groups.stream()
                .filter(g -> g.getId().equals(editPasswordRequest.getGroupId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Group not found"));

        // find website profile id, if not exists throw exception
        WebsiteProfile websiteProfile = websiteProfiles.stream()
                .filter(wp -> wp.getId().equals(editPasswordRequest.getWebsiteProfileId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Website profile not found"));

        // find password, then update and resave it
        Password password = passwords.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Password not found"));

        password.setTitle(editPasswordRequest.getTitle());
        password.setPassword(editPasswordRequest.getPassword());
        password.setGroup(group);
        password.setWebsiteProfile(websiteProfile);

        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    public void patchPasswordExpiredStatus(Long id) {
        // throw exception if password not found
        if (passwords.stream().noneMatch(p -> p.getId().equals(id))) {
            throw new RuntimeException("Password not found");
        }

        passwords.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .ifPresent(p -> p.setExpired(true));


    }

    public void patchPasswordGroup(Long id, PatchPasswordGroup patchPasswordGroup) {

        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    // tag CRUD operations
    public void createGroup(EditGroupRequest editGroupRequest) {
        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    public void updateGroup(Long id, EditGroupRequest editGroupRequest) {
        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    public GroupDto readGroup(Long id) {

        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    public List<GroupShortInfoDto> readGroup() {

        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    public void deleteGroup(Long id) {
        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");

    }

    // WebsiteProfile CRUD operations
    public void createWebsiteProfile(EditWebsiteProfileRequest editWebsiteProfileRequest) {

        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    public void updateWebsiteProfile(Long id, EditWebsiteProfileRequest editWebsiteProfileRequest) {

        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    public void deleteWebsiteProfile(Long id) {

        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    private static byte[] getUTF8Bytes(final String input) {
        return input.getBytes(StandardCharsets.UTF_8);
    }

}