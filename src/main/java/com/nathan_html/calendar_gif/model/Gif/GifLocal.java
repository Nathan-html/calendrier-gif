package com.nathan_html.calendar_git.model.Gif;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class GifLocal extends Gif {

    private String gifName;

}
