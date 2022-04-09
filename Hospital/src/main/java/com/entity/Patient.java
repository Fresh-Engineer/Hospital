package com.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author 买热孜亚
 * 1.一组private属性
 * 2.setter和getter
 * 3.一组构造器
 * 4.重写equals(),hashCode(),toString()
 * 5.实现Serializable接口
 */
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer p_id; 		//患者编号
    private String p_name;  	//患者姓名
    private String sex;  		//患者性别
    private String age; 		//年龄
    private String phone; 		// 联系方式
    private Timestamp created;  //挂号时间
    public Patient() {}
    public Integer getP_id() {
        return p_id;
    }
    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }
    public String getP_name() {
        return p_name;
    }
    public void setP_name(String p_name) {
        this.p_name = p_name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Timestamp getCreated() {
        return created;
    }
    public void setCreated(Timestamp created) {
        this.created = created;
    }
}
