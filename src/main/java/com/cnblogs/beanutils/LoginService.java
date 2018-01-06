package com.cnblogs.beanutils;

import com.cnblogs.json.pojo.Person;

public class LoginService {
    //这是我的业务层

    @SuppressWarnings("unused")
	public Person login(Person u) {
    	Person existu = new Person("xa","1");
        if (existu == null) {
            throw new RuntimeException("没有该用户");
        }
        if (!existu.getFamilyName().equals(u.getFamilyName())) {
            throw new RuntimeException("密码不正确");
        }

        return existu;

    }
}
