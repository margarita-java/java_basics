import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Purchaselist.class);
        configuration.addAnnotatedClass(Students.class);
        configuration.addAnnotatedClass(Courses.class);
        configuration.addAnnotatedClass(LinkedPurchaseList.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();


        Transaction transaction = session.beginTransaction();


        List<Purchaselist> purchaseLists = session.createQuery("from Purchaselist", Purchaselist.class).getResultList();

        for (Purchaselist purchase : purchaseLists) {

            Integer studentId = session.createQuery("select s.id from Students s where s.name = :name", Integer.class)
                    .setParameter("name", purchase.getStudentName())
                    .uniqueResult();


            Integer courseId = session.createQuery("select c.id from Courses c where c.name = :name", Integer.class)
                    .setParameter("name", purchase.getCourseName())
                    .uniqueResult();


            if (studentId != null && courseId != null) {
                LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList(studentId, courseId);
                session.save(linkedPurchaseList);
            }
        }

        transaction.commit();

        session.close();
        sessionFactory.close();

        System.out.println("Данные успешно сконвертированы!");
    }
}






