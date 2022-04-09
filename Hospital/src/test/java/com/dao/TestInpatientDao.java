package com.dao;

import com.dao.impl.InpatientDaoImpl;
import com.entity.Inpatient;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class TestInpatientDao {
    InpatientDaoImpl dao = new InpatientDao();

    @Test
    public void testUpdate() {
        System.out.println("测试更新住院患者信息");
        try {
            Inpatient inpatient = new Inpatient(1, "小米", "5", "30");
            dao.update(inpatient);
            System.out.println("住院患者信息修改成功！");
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("服务器正在维护！");
        }
    }
}
