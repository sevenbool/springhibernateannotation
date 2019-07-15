package com.bwzhou.repository;

import com.bwzhou.domain.Street;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class StreetRepository {

    @Resource
    SessionFactory sessionFactory;

    public List<Street> getStreets(Integer pageIndex, Integer pageSize){
        List<Street> list=new ArrayList<>();
        Session currentSession = sessionFactory.getCurrentSession();
        boolean open = currentSession.isOpen();
        System.out.println(open);
        Transaction ts = currentSession.beginTransaction();
        try {
            String hql="FROM Street";
            Query query = currentSession.createQuery(hql);
            query.setFirstResult((pageIndex-1)*pageSize);
            query.setMaxResults(pageSize);
            ts.commit();
            list=query.list();
        } catch (Exception e) {
            e.printStackTrace();
            ts.rollback();
        } finally {
            return list;
        }
    }
}
