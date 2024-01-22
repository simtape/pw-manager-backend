package it.unimol.pwmanager.models.dto.group;

import it.unimol.pwmanager.models.dto.password.PasswordShortInfoDto;
import it.unimol.pwmanager.models.entities.Group;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupDto {
    private Long id;
    private String name;
    private List<PasswordShortInfoDto> todos;

    public GroupDto(Group group) {
        this.id = group.getId();
        this.name = group.getName();

        if (group.getPasswords() != null) {
            this.todos = group.getPasswords()
                    .stream()
                    .map(PasswordShortInfoDto::new)
                    .toList();
        }
    }
}