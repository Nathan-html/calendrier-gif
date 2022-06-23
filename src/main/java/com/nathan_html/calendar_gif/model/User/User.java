package com.nathan_html.calendar_git.model.User;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nathan_html.calendar_git.model.Gif.Gif;
import com.nathan_html.calendar_git.model.Reaction;
import com.nathan_html.calendar_git.model.Theme;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "users")
public class User {

    private static final int INITIAL_POINTS = 500;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;

    @Email
    @NotBlank
    @Column(unique=true)
    @Pattern(regexp="^([A-Za-z0-9-])+(.[A-Za-z0-9-]+)*@sparks.fr$")
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min=3)
    private String password;

    @ManyToOne
    @NotNull(message="Merci de choisir un thème")
    private Theme theme;

    private int pointsNumber;

    private LocalDateTime createAt;

    @OneToMany(mappedBy="user")
    private List<Gif> gifs;

    @OneToMany(mappedBy="user")
    private List<Reaction> reactions;

    public User() {
        pointsNumber = INITIAL_POINTS;
        createAt = LocalDateTime.now();
    }
}
