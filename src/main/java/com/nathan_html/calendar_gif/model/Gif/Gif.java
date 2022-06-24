package com.nathan_html.calendar_gif.model.Gif;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nathan_html.calendar_gif.model.Day;
import com.nathan_html.calendar_gif.model.Reaction;
import com.nathan_html.calendar_gif.model.User.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Gif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;


    protected String description;

    @OneToOne
    @JoinColumn(unique = true)
    @JsonIgnore
    protected Day day;

    @ManyToOne
    protected User user;

    @JsonIgnore
    @OneToMany(mappedBy="gif", fetch=FetchType.EAGER)
    protected List<Reaction> reactions;

    protected LocalDateTime createAt;

    public Gif() {
        createAt = LocalDateTime.now();
    }

}
