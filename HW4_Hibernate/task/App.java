package HW4_Hibernate.task;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import HW4_Hibernate.models.Courses;
public class App {
    public static void main(String[] args) {
        //Смотря сколько фэбрикс, смотря сколько дитейлс (Фабрика сессий)
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Courses.class).buildSessionFactory();

        //Connect to DB:
        try (Session session = sessionFactory.getCurrentSession()){

            //Start transaction
            session.beginTransaction();

            //Creating object
            Courses courses = new Courses();

            //Save object in BD:
            session.save(courses);

            //Write obj from BD:
            Courses newCourses = session.get(Courses.class, courses.getId());
            System.out.println("Object courses retrieved successfully");

            //Update the object:
            newCourses.updateDuration();
            newCourses.updateTitle();
            session.update(newCourses);
            System.out.println("Object courses update successfully");

            Courses newCourses2 = session.get(Courses.class, 7);
            //Delete obj:
            session.delete(newCourses2);
            System.out.println("Object courses delete successfully");

            //Commit transaction:
            session.getTransaction().commit();
            System.out.println("Transaction commit successfully");
        }
    }
}

