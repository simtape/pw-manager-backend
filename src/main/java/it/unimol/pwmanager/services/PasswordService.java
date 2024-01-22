package it.unimol.pwmanager.services;

import it.unimol.pwmanager.models.dto.group.GroupDto;
import it.unimol.pwmanager.models.dto.group.GroupShortInfoDto;
import it.unimol.pwmanager.models.dto.password.PasswordDto;
import it.unimol.pwmanager.models.dto.password.PasswordShortInfoDto;
import it.unimol.pwmanager.models.entities.Group;
import it.unimol.pwmanager.models.entities.Password;
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
    private int todoIdCounter;
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
        this.todoIdCounter = 0;
        this.doerIdCounter = 0;
        this.tagIdCounter = 0;
    }

    // password CRUD operations

    public void createPassword(EditPasswordRequest editPasswordRequest) {
        /*
         * Implement here the password creation
         * Create a password using the entity Password and add it to the password collection of its class
         * and to the password collection of the group
         *
         *
         *
         * A password can be created only if exists a group by id and a websiteProfile by id
         * if the group does not exist by id, throw an exception
         * if the websiteProfile does not exist by id, throw an exception
         *
         * The value of the password must be encrypted with AES using the Apache Commons Crypto library
         * and the password has to respect the following rules:
         * - The password must be at least 8 characters long
         * - The password must contain at least one uppercase letter
         * - The password must contain at least one lowercase letter
         * throw a runtime exception if the password does not respect the rules
         *
         * When saving the password to the collection,
         * set to default the following fields:
         * - expired: false
         * - createdOn: now
         * - updatedOn: now
         * - expiresOn: now + 30 days
         * - used: true
         * The id of the password must be auto-generated starting from the idCounter provided in this service
         *
         *
         * */
        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    // to-do CRUD operations

    public PasswordDto readPassword(Long id) {
        /*
         * Implement here the password reading.
         * Read the password from the collection of password and return it
         * The password can be read only if exists by id
         * Map the password to the PasswordDto
         * Throw a runtime exception if the password does not exist
         *
         * */

        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    public List<PasswordShortInfoDto> readPassword() {
        /*
         * Implement here the reading of all passwords.
         * By default, the password must be ordered by the following rules:
         * First, the starred password must be on top of the list
         * Following, the password must be ordered by not expired and title first,
         * then by expired date and title
         * */
        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    public void deletePassword(Long id) {
        /*
         * Implement here the password deletion.
         * Remove the password from the collection of password and without creating inconsistence
         * The password can be removed only if is expired and not used anymore
         */

        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    public void updatePassword(Long id, EditPasswordRequest editPasswordRequest) {
        /* Implement here the password update.
         * The password can be be always updated
         * if the password not exists by id, throw an exception
         *
         *
         * */

        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    public void patchPasswordExpiredStatus(Long id) {
        /* Implement here the password update.
         * The expired status can be always patched.
         * When the password is set to be expired, set the expiredOnActual to now
         * When the password is set to be not expired, set the expiredOnActual to null
         *
         * throw an exception if the password does not exist by id
         * */
        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    public void patchPasswordGroup(Long id, PatchPasswordGroup patchPasswordGroup) {
        /* Implement here the password update.
         * The group can be always patched.
         * Find the group by its id from the patchPasswordGroup request
         *
         *
         * throw an exception if the password does not exist by id
         * throw an exception if the group does not exist by id
         * */
        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    // tag CRUD operations
    public void createGroup(EditGroupRequest editGroupRequest) {
        /*
         *  Implement here the Group creation
         * Create a Group using the entity Group and add it to the Group collection of its class
         * The id of the Group must be auto-generated starting from the idCounter provided in this service
         * The name of the group must be validated according to the following rules:
         * - The name must be at least 3 characters long
         * - The name must contain only letters
         * throw a runtime exception if the name does not respect the rules
         *
         * When saving the Group to the collection,
         * set to default the following fields:
         * - createdOn: now
         * - updatedOn: now
         *
         *
         *
         * */

        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    public void updateGroup(Long id, EditGroupRequest editGroupRequest) {
        /*
         * Implement here the Group update
         * A group can be updated only
         * if the group exists by id
         *  The name must be validated according to the following rules:
         * - The name must be at least 3 characters long
         * - The name must contain only letters
         * throw a runtime exception if the name does not respect the rules
         *
         *
         * */

        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    public GroupDto readGroup(Long id) {
        /*
         * Implement here the Group reading.
         * Read the Group from the collection of Group and return it
         * The Group can be read only if exists by id
         * Map the Group to the GroupDto
         * Throw a runtime exception if the Group does not exist
         * */

        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    public List<GroupShortInfoDto> readGroup() {
        /*
         * Implement here the reading of all Groups.
         * By default, the Group must be ordered by the following rule:
         * the Group must be ordered by biggest number of password by group first.
         *
         * Map each Group to GroupShortInfoDto
         * */
        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    public void deleteGroup(Long id) {
        /*
         * Implement here the Group deletion.
         * Remove the Group from the collection of Group and without creating inconsistence
         * The Group can be removed only if is not used anymore
         * */

        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");

    }

    // WebsiteProfile CRUD operations
    public void createWebsiteProfile(EditWebsiteProfileRequest editWebsiteProfileRequest) {
        /*
         *  Implement here the WebsiteProfile creation
         * Create a WebsiteProfile using the entity WebsiteProfile and add it to the WebsiteProfile collection of its class
         * The id of the WebsiteProfile must be auto-generated starting from the idCounter provided in this service
         * The username of the WebsiteProfile must be validated according to the following rules:
         * - The username must be max 30 characters long
         * - The username must contain only letters
         * throw a runtime exception if the username does not respect the rules
         *
         * The mail of the WebsiteProfile must be validated according to the following rules:
         * - The mail must be max 30 characters long
         * - the mail has to be a valid mail
         * throw a runtime exception if the mail does not respect the rules
         *
         * The websiteUrl of the WebsiteProfile must be validated according to the following rules:
         * - the websiteUrl has to be a valid websiteUrl
         * throw a runtime exception if the websiteUrl does not respect the rules
         *
         *
         * When saving the WebsiteProfile to the collection,
         * set to default the following fields:
         * - createdOn: now
         * - updatedOn: now
         * */

        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    public void updateWebsiteProfile(Long id, EditWebsiteProfileRequest editWebsiteProfileRequest) {
        /*
         * Implement here the WebsiteProfile update
         * A WebsiteProfile can be updated only
         * if the WebsiteProfile exists by id
         *  The name must be validated according to the following rules:
         * - The name must be at least 3 characters long
         * - The name must contain only letters
         * throw a runtime exception if the name does not respect the rules
         *
         *
         * */

        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }

    public void deleteWebsiteProfile(Long id) {
        /*
         * Implement here the WebsiteProfile deletion.
         * Remove the WebsiteProfile from the collection of WebsiteProfile and without creating inconsistence
         * The WebsiteProfile can be removed only if is not used anymore
         *
         * throw a runtime exception if the WebsiteProfile does not exist by id
         * */

        throw new RuntimeException("Not implemented yet. Remove me when you´re done :)");
    }


    private static byte[] getUTF8Bytes(final String input) {
        return input.getBytes(StandardCharsets.UTF_8);
    }

}