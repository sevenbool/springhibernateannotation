package com.bwzhou.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="house")
@GenericGenerator(name="idGenerator", strategy="uuid")
public class House {

    private String ID;
    private Integer typeId;
    private Integer userId;

    public House(){}

    @Id
    @GeneratedValue(generator="idGenerator")
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }


    @Column(name = "TYPE_ID")
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Column(name = "USER_ID")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
