package com.ruoyi.common.core.domain;

import java.io.Serializable;


public class IdNamePair implements Serializable {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "IdNamePair{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
