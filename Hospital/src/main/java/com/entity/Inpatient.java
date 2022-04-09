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
public class Inpatient implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer ward_id;    //病房号
    private String p_name;  	//患者姓名
    private String bed_id;		//床位号
    private String cost; 		// 费用
    private Timestamp indated;  //住院时间
    public Inpatient() {}

    public Inpatient(Integer ward_id, String p_name, String bed_id, String cost) {
        this.ward_id = ward_id;
        this.p_name = p_name;
        this.bed_id = bed_id;
        this.cost = cost;
    }

    public Integer getWard_id() {
        return ward_id;
    }
    public void setWard_id(Integer ward_id) {
        this.ward_id = ward_id;
    }
    public String getP_name() {
        return p_name;
    }
    public void setP_name(String p_name) {
        this.p_name = p_name;
    }
    public String getBed_id() {
        return bed_id;
    }
    public void setBed_id(String bed_id) {
        this.bed_id = bed_id;
    }
    public String getCost() {
        return cost;
    }
    public void setCost(String cost) {
        this.cost = cost;
    }
    public Timestamp getIndated() {
        return indated;
    }
    public void setIndated(Timestamp indated) {
        this.indated = indated;
    }

}
