package it.unimol.pwmanager.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Password {

    private Long id;

    private String password;

    private String title;
    private Boolean used;

    private Boolean expired;

    private Instant createdOn;

    private Instant updatedOn;

    private Instant expiresOn;

    private Instant expiredOnActual;

    private WebsiteProfile websiteProfile;
    private Group group;

    public Password(long id,
    String title,
                    String password,
                    Group group,
                    WebsiteProfile websiteProfile){
        this.id = id;
        this.title = title;
        this.password = password;
        this.used = false;
        this.expired = false;
        this.createdOn = Instant.now();
        this.updatedOn = Instant.now();
        this.expiresOn = Instant.now();
        this.expiredOnActual = Instant.now();
        this.websiteProfile = websiteProfile;
        this.group = group;
    }
}