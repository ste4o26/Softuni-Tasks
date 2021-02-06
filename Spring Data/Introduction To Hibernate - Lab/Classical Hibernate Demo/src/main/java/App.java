import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        //tozi obekt sluji za izpulnenie na hibenrate.cfg.xml faila
        //metoda configure tursi v paketa resourses za fail s tova
        //ime ako sum mu zadal drugo ime ima razlichni overloadi na
        //metoda s koito moga da mu tam pyt do faila
        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student student = new Student("Stefan", 21, 204582041);
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }
}
