package org.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.app.config.HibernateConfig;
import org.hibernate.app.model.StudentEntity;

import javax.persistence.Query;

public class MainHQL {
    public static void main(String[] args) {

        StudentEntity student1 = new StudentEntity(1,"Deepak","India");
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction  = session.beginTransaction();

        //update record corresponding to student Id 1

        String hqlQuery = " update StudentEntity set name = :name where id = :id";
        Query query = session.createQuery(hqlQuery);
        query.setParameter("name", "HQLStudentName");
        query.setParameter("id", 1);
        int result = query.executeUpdate();
        System.out.println("rows affected : "+ result);


        transaction.commit();
        sessionFactory.close();

    }
}