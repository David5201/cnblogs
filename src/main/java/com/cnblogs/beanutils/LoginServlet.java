package com.cnblogs.beanutils;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.cnblogs.json.pojo.Person;



public class LoginServlet extends HttpServlet {
    private LoginService Ls;
    
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        
        //1.处理中文乱码这是我的web层
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //2.封装数据以及对数据进行强转
        Person u = new Person();
        try {
            BeanUtils.populate(u, request.getParameterMap());
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace(); 
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //调用service
        Person existu = null;
        //调用dao包中的方法
        try {
        	if(Ls == null){
        		Ls = new LoginService();
        	}
            existu =Ls.login(u);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
        // 4.向session中加入登录标识
        request.getSession().setAttribute("user", existu);
    
    }

}