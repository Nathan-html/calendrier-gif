package com.nathan_html.calendar_gif.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nathan_html.calendar_gif.model.Gif.Gif;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.Random;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Day {

    private static Random random = new Random();

    @Id
    private LocalDate date;

    @Min(value = 20)
    @Max(value = 50)
    private int pointsNumber;

    @JsonIgnore
    @OneToOne(mappedBy = "day")
    private Gif gif;

    public Day(LocalDate date) {
        this(date, 20 + random.nextInt(31));
    }

    public Day(LocalDate date, int nbPoints) {
        this.date = date;
        this.pointsNumber = nbPoints;
    }
}
