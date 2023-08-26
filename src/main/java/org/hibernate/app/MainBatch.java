package org.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.app.config.HibernateConfig;
import org.hibernate.app.model.StudentEntity;

import java.util.List;

public class MainBatch {
    public static void main(String[] args) {

        StudentEntity student1 = new StudentEntity(1,"Test1","NYK");
        StudentEntity student2 = new StudentEntity(2,"Deepak","CDG");
        StudentEntity student3 = new StudentEntity(3,"Bikash","India");
        StudentEntity student4 = new StudentEntity(4,"Amit","India");
        StudentEntity student5 = new StudentEntity(5,"Deepak","US");
        StudentEntity student6 = new StudentEntity(6,"Niraj","SA");
        StudentEntity student7 = new StudentEntity(7,"Test3","LKO");
        StudentEntity student8 = new StudentEntity(8,"Test4","India");
        StudentEntity student9 = new StudentEntity(9,"Test3","LKO");
        StudentEntity student10 = new StudentEntity(10,"Test4","India");

        List<StudentEntity> entityList = List.of(student1,student2,student3,student4,student5,student6,student7,student8,student9,student10);

        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction  = session.beginTransaction();
       // int i=0;

        for(int j=0;j<10000000; j++){
            StudentEntity studentEntity = new StudentEntity(j,"Test"+j,"Address"+j);
            session.save(studentEntity);
        }


        /*for(StudentEntity stu : entityList) {
            i++;
            session.save(stu);
            if(i % 5 == 0){
                session.flush();
                session.clear();
                System.out.println("session cleared and query will execute in next batch");
            }
        }*/
        transaction.commit();
        sessionFactory.close();
    }
}