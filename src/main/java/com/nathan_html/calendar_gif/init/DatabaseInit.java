package com.nathan_html.calendar_gif.init;

import com.nathan_html.calendar_gif.dao.DayDAO;
import com.nathan_html.calendar_gif.dao.EmotionDAO;
import com.nathan_html.calendar_gif.dao.ThemeDAO;
import com.nathan_html.calendar_gif.dao.User.UserDAO;
import com.nathan_html.calendar_gif.model.Day;
import com.nathan_html.calendar_gif.model.Emotion;
import com.nathan_html.calendar_gif.model.Theme;
import com.nathan_html.calendar_gif.model.User.User;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Component
@AllArgsConstructor
public class DatabaseInit implements CommandLineRunner {

    private final EmotionDAO emotionDAO;
    private final ThemeDAO themeDAO;
    private final UserDAO userDAO;
    private final DayDAO dayDAO;
    private static Random random = new Random();
    private static FakeValuesService fakeValuesService = new FakeValuesService(new Locale("fr-FR"), new RandomService());
    private static Faker faker = new Faker(new Locale("fr-FR"));

    @Override
    public void run(String... args) throws Exception {
        addEmotions();
        addThemes();
        addDays();
        addUser();
    }

    private void addEmotions() {
        if(emotionDAO.count() == 0) {
            emotionDAO.save(new Emotion("coeur", "&#x2764;"));
            emotionDAO.save(new Emotion("mdr", "&#x1F602;"));
            emotionDAO.save(new Emotion("choquer", "&#x1F632;"));
        }
    }

    private void addThemes() {
        if(themeDAO.count()==0) {
            themeDAO.save(new Theme("light"));
            themeDAO.save(new Theme("dark"));
        }
    }

    private void addDays() {
        if(dayDAO.count()==0) {
            int currentYear = LocalDate.now().getYear();
            int currentMonth = LocalDate.now().getMonthValue();
            LocalDate date = LocalDate.of(currentYear, currentMonth, 1);
            int lengthOfCurrentMonth = date.lengthOfMonth();
            Day day = new Day();
            for (int i = 1; i <= lengthOfCurrentMonth; i++) {
                dayDAO.save(new Day(date));
                date = date.plusDays(1);
            }
        }
    }

    public void addUser() {
        if (userDAO.count()==0) {
            List<Theme> themes = themeDAO.findAll();
            Map<String, User> map = new HashMap<>();
            Calendar calendar = Calendar.getInstance();
            int count = 0;

            while (map.size() != 10) {
                count++;
                User user = new User();
                user.setFirstname(faker.name().lastName());
                user.setLastname(faker.name().firstName());
                user.setEmail(fakeValuesService.letterify("?????@sparks.fr"));
                user.setPassword(faker.internet().password(3, 8));
                calendar.set(2021, 1, 1);
                Date dateDebut = calendar.getTime();
                calendar = Calendar.getInstance();
                Date dateFin = calendar.getTime();
                Date dateAleatoire = faker.date().between(dateDebut, dateFin);
                calendar.setTime(dateAleatoire);
                user.setCreateAt(dateAleatoire.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
                user.setTheme(themes.get(random.nextInt(themes.size())));
                map.put(user.getEmail(), user);
            }
            userDAO.saveAll(map.values());
            System.out.println("Nombre d'itérations=" + count);
        }
    }

}
