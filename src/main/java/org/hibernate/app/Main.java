package org.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.app.config.HibernateConfig;
import org.hibernate.app.model.StudentEntity;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StudentEntity student1 = new StudentEntity("Test","US"); //transisent state
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction  = session.beginTransaction();

        //StudentEntity stu = session.get(StudentEntity.class,17);  // o/p null  // hit database // eager loading
        //StudentEntity stu1 = session.load(StudentEntity.class,5); // exception // lazy loading  // if present in cache ,will return that

        session.save(student1);  // Persistent state

       // System.out.println(stu1.getName());


        transaction.commit();
        sessionFactory.close();  // Detached state

    }
}