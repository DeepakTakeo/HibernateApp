package org.hibernate.app;

import org.hibernate.*;
import org.hibernate.app.config.HibernateConfig;
import org.hibernate.app.model.StudentEntity;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainEntityNativeSQL {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction  = session.beginTransaction();

        String nativeSQLQuery = "select * from public.student";
        SQLQuery query = session.createSQLQuery(nativeSQLQuery);
        query.addEntity(StudentEntity.class);
        List list = query.list();

        Iterator iterator = list.iterator();

        while (iterator.hasNext()){
            StudentEntity stu = (StudentEntity) iterator.next();
            System.out.println(stu.getAddress());


        }


        transaction.commit();
        sessionFactory.close();

    }
}
