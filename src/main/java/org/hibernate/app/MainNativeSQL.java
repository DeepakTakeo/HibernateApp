package org.hibernate.app;

import org.hibernate.*;
import org.hibernate.app.config.HibernateConfig;
import org.hibernate.app.model.StudentEntity;
import org.hibernate.loader.custom.sql.SQLQueryParser;

import java.util.List;
import java.util.Map;

public class MainNativeSQL {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction  = session.beginTransaction();

        String nativeSQLQuery = "select name,address from public.student";
        SQLQuery query = session.createSQLQuery(nativeSQLQuery);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List result = query.list();

        for(Object obj : result){
            Map mapObject = (Map) obj;
            System.out.println(mapObject.get("name") + "-------" + mapObject.get("address"));
        }
        transaction.commit();
        sessionFactory.close();

    }
}
