package com.nathan_html.calendar_gif.dao.Gif;

import com.nathan_html.calendar_gif.model.Gif.Gif;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GifDAO extends JpaRepository<Gif, Long> {
}
