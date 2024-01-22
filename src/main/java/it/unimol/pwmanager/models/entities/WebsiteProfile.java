package it.unimol.pwmanager.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WebsiteProfile {
    private Long id;
    private String username;
    private String email;
    private String websiteUrl;
}