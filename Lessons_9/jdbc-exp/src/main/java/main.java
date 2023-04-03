import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.rmi.dgc.Lease;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import static org.hibernate.id.PersistentIdentifierGenerator.PK;

public class main {
    public static void main(String[] args) {

        // -------------------------- jdbc Соединение, запросы, получение данных из БД --------------------------------
//        String url = "jdbc:mysql://localhost:3306/skillbox?useSSL=false&serverTimezone=UTC";
//        String user = "root";
//        String pass = "11111111";
//        try {
//            Connection conection = DriverManager.getConnection(url, user, pass);
//            System.out.println("---------------------------------");
//            System.out.println("Соединение успешно установлено!!!");
//            System.out.println("---------------------------------");
//            Statement statement = conection.createStatement();
//            statement.execute("UPDATE Courses SET name='Веб разработчик c нуля до PRO' where id ='1'");
//            String search = "Frontend-разработчик";
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM Courses WHERE name='" + search + "'");
//            while (resultSet.next()) {
//                String courseName = resultSet.getString("name");
//                String courseDescription = resultSet.getString("description");
//                System.out.println("Результат поиска: " + courseName + " - " + courseDescription);
//            }
//            resultSet.close();
//            statement.close();
//            resultSet.close();
//        } catch (Exception ex) {
//
//        }


        // ----------------------------------------- Задание №10.1 -------------------------------------------------
//        String url = "jdbc:mysql://localhost:3306/skillbox?useSSL=false&serverTimezone=UTC";
//        String user = "root";
//        String pass = "11111111";
//        try {
//            Connection conection = DriverManager.getConnection(url, user, pass);
//            System.out.println("---------------------------------");
//            System.out.println("Соединение успешно установлено!!!");
//            System.out.println("---------------------------------");
//            Statement statement = conection.createStatement();
//           // ResultSet resultSet = statement.executeQuery("SELECT FROM purchaselist WHERE course_name = 'Frontend-разработчик' ORDER BY purchaselist.subscription_date");
//            ResultSet resultSet = statement.executeQuery("SELECT course_name, COUNT(course_name)/(MAX(MONTH(subscription_date)) - MIN(MONTH(subscription_date))) AS Coefficient FROM PurchaseList GROUP BY course_name");
//            while (resultSet.next()) {
//                String courseName = resultSet.getString("course_name");
//                String coefficient = resultSet.getString("Coefficient");
//                System.out.println("Название курса: " + courseName + ".  Среднее число покупок в месяц: " + coefficient);
//            }
//            resultSet.close();
//            statement.close();
//            resultSet.close();
//        } catch (Exception ex) {
//
//        }


        // ------------------------------- Hibernate - подключение и настройка -------------------------------------

//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure("hibernate.cfg.xml").build();
//        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
//        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
//
//        Session session = sessionFactory.openSession();
//
//        Course course = session.get(Course.class, 1);
//        System.out.println(course.getName());
//
//        sessionFactory.close();


        // ---------------------------- Hibernate - изменения даных в базе -------------------------------------

//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure("hibernate.cfg.xml").build();
//        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
//        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
//
//        Session session = sessionFactory.openSession();
//
//        Transaction transaction = session.beginTransaction();
//
//        //Course course = new Course();
//
//        Course course = session.get(Course.class, 48);
//
//        course.setName("Новый курс 2");
//
//        course.setType(CourseType.BUSINESS);
//
//        course.setTeacherId(1);
//
//        session.delete(course);
//
//        session.save(course);
//
//        transaction.commit();
//
//        sessionFactory.close();
//


        // ---------------------------- Hibernate - связи manyToOne и OneToMany -------------------------------------

//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure("hibernate.cfg.xml").build();
//        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
//        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
//
//        Session session = sessionFactory.openSession();
//
//        Transaction transaction = session.beginTransaction();
//
//
//        Course course = session.get(Course.class, 1);
//
//        System.out.println(course.getTeacher().getName());
//        transaction.commit();
//
//        sessionFactory.close();


        // ---------------------------- Hibernate - связи ManyToMany -------------------------------------

//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure("hibernate.cfg.xml").build();
//        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
//        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
//
//        Session session = sessionFactory.openSession();
//
//        Transaction transaction = session.beginTransaction();
//
//        Course course = session.get(Course.class, 1);
//
//        System.out.println(course.getStudents().size());
//
//        List<Student> studentsList = course.getStudents();
//
//        studentsList.forEach(student -> System.out.println(student.getName()));
//
//        transaction.commit();
//
//        sessionFactory.close();


        // ---------------------------- Hibernate query builder -------------------------------------

//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure("hibernate.cfg.xml").build();
//        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
//        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
//
//        Session session = sessionFactory.openSession();
//
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Course> query = builder.createQuery(Course.class);
//        Root<Course> root = query.from(Course.class);
//        query.select(root);
//        List<Course> coursesList = session.createQuery(query).getResultList();
//        for (Course course : coursesList) {
//            System.out.println(course.getName() + " - " + course.getTeacher().getName());
//        }
//        sessionFactory.close();

        // ---------------------------- Hibernate Where и OrderBy -------------------------------------

//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure("hibernate.cfg.xml").build();
//        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
//        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
//
//        Session session = sessionFactory.openSession();
//
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Course> query = builder.createQuery(Course.class);
//        Root<Course> root = query.from(Course.class);
//        query.select(root).where(builder.greaterThan(root.get("price"), 100000))
//                .orderBy(builder.asc(root.get("price")));
//        List<Course> coursesList = session.createQuery(query).setMaxResults(5).getResultList();
//
//        for (Course course : coursesList) {
//            System.out.println(course.getName() + " - " + course.getTeacher().getName() + "стоимость курса: " + course.getPrice() + "");
//        }
//
//        sessionFactory.close();

        // --------------------------------------------- HQL -----------------------------------------------------

//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure("hibernate.cfg.xml").build();
//        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
//        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
//
//        Session session = sessionFactory.openSession();
//
//        String hql = "From " + Course.class.getSimpleName() + " Where price > 120000";
//        List<Course> coursesList =  session.createQuery(hql).getResultList();
//
//        for (Course course : coursesList) {
//            System.out.println(course.getName() + " - " + course.getPrice());
//        }
//
//        sessionFactory.close();

        // ----------------------------------------- Задание №10.4 -------------------------------------------------

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PurchaseList> purchaseListQuery = builder.createQuery(PurchaseList.class);
        Root<PurchaseList> root = purchaseListQuery.from(PurchaseList.class);
        purchaseListQuery.select(root);
        List<PurchaseList> purchaseList = session.createQuery(purchaseListQuery).getResultList();

        for (PurchaseList purchase : purchaseList) {

            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList(
                    new Key(course.getId, student.getId), purchase.getStudentName(), purchase.getCourseName());
            session.save(linkedPurchaseList);
       }

        sessionFactory.close();

    }
}
