package it.unimol.pwmanager.models.dto.password;

import it.unimol.pwmanager.models.entities.Password;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PasswordDto {
    private Long id;
    private String password;
    private String title;
    private Boolean used;
    private Boolean expired;
    private Instant createdOn;
    private Instant updatedOn;
    private Instant expiresOn;

    private String websiteProfileId;
    private String websiteProfileEmail;

    private String groupId;
    private String groupName;



    public PasswordDto(Password password) {
        this.id = password.getId();
        this.password = password.getPassword();
        this.title = password.getTitle();
        this.used = password.getUsed();
        this.expired = password.getExpired();
        this.createdOn = password.getCreatedOn();
        this.updatedOn = password.getUpdatedOn();
        this.expiresOn = password.getExpiresOn();

        this.websiteProfileId = password.getWebsiteProfile().getId().toString();
        this.websiteProfileEmail = password.getWebsiteProfile().getEmail();

        this.groupId = password.getGroup().getId().toString();
        this.groupName = password.getGroup().getName();
        
    }
}
