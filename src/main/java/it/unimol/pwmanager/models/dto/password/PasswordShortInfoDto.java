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
public class PasswordShortInfoDto {
    private Long id;
    private String title;
    private Instant createdOn;
    private Boolean completed;

    public PasswordShortInfoDto(Password password) {
        this.id = password.getId();
        this.title = password.getTitle();
        this.createdOn = password.getCreatedOn();
        this.completed = password.getCompleted();
    }

}
