package com.bwzhou;

import static org.junit.Assert.assertTrue;

import com.bwzhou.domain.House;
import com.bwzhou.repository.HouseRepository;
import com.bwzhou.repository.StreetRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AppTest 
{
    @Autowired
    HouseRepository houseRepository;

    @Autowired
    StreetRepository streetRepository;

    @Test
   public void houseTest1(){
        houseRepository.init();
        List<House> houses = houseRepository.getHouses(1, 5);
        houseRepository.destory();
    }

    @Test
    public void houseTest2(){
        House house=new House();
        houseRepository.init();
        houseRepository.addHouse(house);
        houseRepository.destory();
    }

    @Test
    public void houseTest3(){
        houseRepository.init();
        House house=new House();
        houseRepository.addHouse(house);
        houseRepository.getHouses(1,4);
        houseRepository.destory();
    }
}
