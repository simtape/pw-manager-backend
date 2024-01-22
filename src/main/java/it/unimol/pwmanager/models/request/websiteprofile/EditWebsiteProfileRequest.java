package it.unimol.pwmanager.models.request.websiteprofile;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EditWebsiteProfileRequest {
    @NotBlank(message = "Username is mandatory")
    private String username;
    @NotBlank(message = "Username is mandatory")
    private String email;
    @NotBlank(message = "Username is mandatory")
    private String websiteUrl;

}
