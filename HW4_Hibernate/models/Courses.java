package HW4_Hibernate.models;

import javax.persistence.*;
import java.util.Random;

/*
Создайте базу данных (например, SchoolDB).
В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.
Настройте Hibernate для работы с вашей базой данных.
Создайте Java-класс Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.
Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.
Убедитесь, что каждая операция выполняется в отдельной транзакции.
 */
@Entity
@Table(name = "Courses")
public class Courses {
    private static final Random rand = new Random();
    private static final String[] titles = new String[] {"Geography", "English", "Economy", "Public Relations"};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int duration;

    public Courses(String title, int duration){
        this.title = title;
        this.duration = duration;
    }

    public Courses(){}

    public Courses(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public void updateDuration(){
        duration = rand.nextInt(30, 60);
    }

    public void updateTitle(){
        title = titles[rand.nextInt(titles.length)];
    }

    public static Courses create(){
        return new Courses(titles[rand.nextInt(titles.length)], rand.nextInt(30, 60));
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
