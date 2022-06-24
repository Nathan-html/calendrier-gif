package com.nathan_html.calendar_gif.model;

import com.nathan_html.calendar_gif.model.Gif.Gif;
import com.nathan_html.calendar_gif.model.User.User;
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
