package com.flhscl.springbootscrafhold.entity.datasource1;

import java.io.Serializable;

public class User implements Serializable{

    private static final long serialVersionUID = -1L;
    /**
     * 
     * 表字段：user.id
     */
    private Integer id;

    /**
     * 
     * 表字段：user.name
     */
    private String name;

    /**
     * 
     * 表字段：user.age
     */
    private Integer age;

    /**
     * 获取  字段：user.id
     *
     * @return user.id, 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:user.id
     *
     * @param id the value for user.id, 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取  字段：user.name
     *
     * @return user.name, 
     */
    public String getName() {
        return name;
    }

    /**
     * 设置  字段:user.name
     *
     * @param name the value for user.name, 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取  字段：user.age
     *
     * @return user.age, 
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置  字段:user.age
     *
     * @param age the value for user.age, 
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|id:"+ this.getId());
        stringBuilder.append("|name:" + this.getName());
        stringBuilder.append("|age:" + this.getAge());
        return stringBuilder.toString();
    }
}