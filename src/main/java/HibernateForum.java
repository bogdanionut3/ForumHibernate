import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateForum {
    private static Configuration conf;
    private static SessionFactory f;
    private static Session s;

    HibernateForum() {
        conf = new Configuration().configure();
        f = conf.buildSessionFactory();
        s = f.openSession();
    }

    public void insert(Object obj) {
        s.beginTransaction();
        s.save(obj);
        s.getTransaction().commit();
    }

    public List<Object> getAll(Class type) {//primeste o clasa ca parametru
        return s.createCriteria(type).list();
    }

}
