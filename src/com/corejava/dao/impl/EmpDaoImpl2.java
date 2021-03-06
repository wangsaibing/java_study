package com.corejava.dao.impl;

import com.corejava.dao.EmpDao;
import com.corejava.entity.Emp;
import com.corejava.util.MySQLDBUtil;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by wangsaibing on 21/3/14.
 */
public class EmpDaoImpl2 implements EmpDao {
    @Override
    public void insert(Emp emp) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = MySQLDBUtil.getConnection();
            String sql = "INSERT INTO emp (empno, ename, job, mrg, hiredate, sal, comm, deptno) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,emp.getEmpno());
            statement.setString(2,emp.getEname());
            statement.setString(3,emp.getJob());
            statement.setInt(4,emp.getMrg());
            statement.setDate(5,new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse(emp.getHiredate()).getTime()));
            statement.setDouble(6,emp.getSal());
            statement.setDouble(7,emp.getComm());
            statement.setInt(8,emp.getDeptno());
            //返回值表示受影响的行数
            int i = statement.executeUpdate();
            System.out.println("受影响的行数是：" + i);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            MySQLDBUtil.closeConnection(connection, statement);
        }
    }

    @Override
    public void delete(Emp emp) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = MySQLDBUtil.getConnection();
            //设置事务是否自动提交，true表示自动提交，false表示不是自动提交
//            connection.setAutoCommit(true);
            String sql = "delete from emp where empno = ?" ;
            statement = connection.prepareStatement(sql);
            statement.setInt(1,emp.getEmpno());
            //拼接sql语句
            System.out.println(sql);
            //返回值表示受影响的行数
            int i = statement.executeUpdate();
            System.out.println("受影响的行数是：" + i);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySQLDBUtil.closeConnection(connection, statement);
        }
    }

    @Override
    public void update(Emp emp) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = MySQLDBUtil.getConnection();
            //设置事务是否自动提交，true表示自动提交，false表示不是自动提交
//            connection.setAutoCommit(true);
            statement = connection.createStatement();
            //拼接sql语句
            String sql = "update emp set job = '" + emp.getJob() + "' where empno = " + emp.getEmpno();
            System.out.println(sql);
            //返回值表示受影响的行数
            int i = statement.executeUpdate(sql);
            System.out.println("受影响的行数是：" + i);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySQLDBUtil.closeConnection(connection, statement);
        }
    }

    @Override
    public Emp getEmpByEmpno(Integer empno) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Emp emp = null;
        try {
            connection = MySQLDBUtil.getConnection();
            //设置事务是否自动提交，true表示自动提交，false表示不是自动提交
//            connection.setAutoCommit(true);
            statement = connection.createStatement();
            //拼接sql语句
            String sql = "select * from emp where empno = " + empno;
            System.out.println(sql);
            //返回值表示受影响的行数
            resultSet = statement.executeQuery(sql);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            while (resultSet.next()) {
                emp = new Emp(resultSet.getInt("empno"), resultSet.getString("ename"), resultSet.getString("job"),
                        resultSet.getInt("mgr"), sdf.format(resultSet.getDate("hiredate")), resultSet.getDouble("sal"),
                        resultSet.getDouble("comm"), resultSet.getInt("deptno"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySQLDBUtil.closeConnection(connection, statement,resultSet);
        }
        return emp;
    }

    @Override
    public Emp getEmpByEname(String name) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        Emp emp = null;
        try {
            connection = MySQLDBUtil.getConnection();
            //设置事务是否自动提交，true表示自动提交，false表示不是自动提交
//            connection.setAutoCommit(true);
            //拼接sql语句
            String sql = "select * from emp where ename = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,name);
            System.out.println(sql);
            //返回值表示受影响的行数
            resultSet = pstmt.executeQuery();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            while (resultSet.next()) {
                emp = new Emp(resultSet.getInt("empno"), resultSet.getString("ename"), resultSet.getString("job"),
                        resultSet.getInt("mgr"), sdf.format(resultSet.getDate("hiredate")), resultSet.getDouble("sal"),
                        resultSet.getDouble("comm"), resultSet.getInt("deptno"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySQLDBUtil.closeConnection(connection, pstmt,resultSet);
        }
        return emp;
    }

    public static void main(String[] args) {
        EmpDao empDao = new EmpDaoImpl2();
        Emp emp = new Emp(3333, "sisi", "SALES", 1111, "2019-11-09", 1500.0, 500.0, 10);
        empDao.insert(emp);
//        empDao.delete(emp);
        empDao.update(emp);
        Emp emp2 = empDao.getEmpByEmpno(7369);
        //sql注入
//        Emp emp2 = empDao.getEmpByEname("'SMITH' or 1 = 1");
//        System.out.println(emp2);
    }
}
