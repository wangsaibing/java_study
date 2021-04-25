package com.corejava.dao;

import com.corejava.entity.Emp;

/**
 * Created by wangsaibing on 21/3/14.
 */
public interface EmpDao {

    //插入数据
    public void insert(Emp emp);

    //删除数据
    public void delete(Emp emp);

    //修改数据
    public void update(Emp emp);

    //查找数据
    public Emp getEmpByEmpno(Integer empno);

    public Emp getEmpByEname(String name);
}
