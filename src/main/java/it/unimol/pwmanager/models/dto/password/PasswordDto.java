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
    private String value;
    private String description;
    private Boolean completed;
    private Instant createdOn;
    private Instant updatedOn;
    private Instant expiresOn;


    public PasswordDto(Password password) {
        this.id = password.getId();
        this.value = password.getDescription();
        this.description = password.getDescription();
        this.completed = password.getCompleted();
        this.createdOn = password.getCreatedOn();
        this.updatedOn = password.getUpdatedOn();
        this.completedOn = password.getExpiresOn();
        this.tagName = password.getGroup().getName();
    }
}
