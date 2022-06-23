package com.nathan_html.calendar_git.model;

import com.nathan_html.calendar_git.model.Gif.Gif;
import com.nathan_html.calendar_git.model.User.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class Reaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Gif gif;

    @ManyToOne
    private User user;

    @ManyToOne
    private Emotion emotion;

    private LocalDateTime createAt;

    public Reaction() {
        createAt = LocalDateTime.now();
    }
}
