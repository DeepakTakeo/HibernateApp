package org.hibernate.app;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.app.config.HibernateConfig;
import org.hibernate.app.model.StudentEntity;
import org.hibernate.criterion.Restrictions;

import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

public class MainCriteria {

    public static void main(String[] args) {


        StudentEntity student1 = new StudentEntity(1,"Deepak","India");
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction  = session.beginTransaction();

       // use criteria to fetch data from database with some restrictions
        // filter, max,min....
        Criteria cr = session.createCriteria(StudentEntity.class);
        //cr.add(Restrictions.eq("name","HQLStudentName")); // projections in criteria

        List stuList = cr.list();

        Iterator itr = stuList.iterator();

        while(itr.hasNext()){
            StudentEntity stu = (StudentEntity) itr.next();
            System.out.println(stu.getName() + "----" + stu.getId());
        }

        transaction.commit();
        sessionFactory.close();



    }
}
