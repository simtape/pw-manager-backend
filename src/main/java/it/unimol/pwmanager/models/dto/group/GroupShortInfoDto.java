package it.unimol.pwmanager.models.dto.group;

import it.unimol.pwmanager.models.entities.Group;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupShortInfoDto {
    private Long id;
    private String name;
    private int todosCount;

    public GroupShortInfoDto(Group group) {
        this.id = group.getId();
        this.name = group.getName();

        if (group.getPasswords() != null) {
            this.todosCount = group.getPasswords().size();
        }
    }
}
