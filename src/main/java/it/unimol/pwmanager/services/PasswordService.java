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
import org.apache.commons.crypto.utils.AES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
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

    private final SecretKeySpec key = AES.newSecretKeySpec(getUTF8Bytes("1234567890123456"));
    private final IvParameterSpec iv = new IvParameterSpec(getUTF8Bytes("1234567890123456"));
    private final String transform = AES.CBC_PKCS5_PADDING;
    private static final String TEXT_REGEX = "";
    private static final String NAME_AND_SURNAME_REGEX = "";
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

    // to-do CRUD operations

    public PasswordDto readPassword(Long id) {

        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    public List<PasswordShortInfoDto> readPassword() {

        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    public void deletePassword(Long id) {

        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    public void updatePassword(Long id, EditPasswordRequest editPasswordRequest) {

        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    public void patchPasswordExpiredStatus(Long id) {

        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
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