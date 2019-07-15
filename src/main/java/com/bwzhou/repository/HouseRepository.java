package com.bwzhou.repository;

import com.bwzhou.domain.House;
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
public class HouseRepository {

    @Resource
    SessionFactory sessionFactory;

    private Session session;

    public void init(){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
    }

    public void destory(){
        session=null;
    }

    public void addHouse(House house){
        session.save(house);
    }

    public List<House> getHouses(Integer pageIndex, Integer pageSize){
        List<House> list=new ArrayList<>();
            String hql="FROM House";
            Query query = session.createQuery(hql);
            query.setFirstResult((pageIndex-1)*pageSize);
            query.setMaxResults(pageSize);
            list=query.list();
            return list;
    }


}
