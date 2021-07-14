package com.day.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.day.dto.Customer;

@WebListener
public class MySessionAttributeListener implements HttpSessionAttributeListener {
	private int loginedCnt;//로그인된 고객수
    public MySessionAttributeListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	String attrName = se.getName();
    	//String attrValue = se.get
    	if("loginInfo".equals(attrName)) {
    		Customer c = (Customer)se.getValue();
    		loginedCnt++;//로그인된 고객수 1증가
    		System.out.println(c.getId()+"님의 로그인했습니다. 현재로그인된 총고객수 : "+loginedCnt);
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	if("loginInfo".equals(se.getName())) {
    		Customer c = (Customer)se.getValue();
    		loginedCnt--;//로그인된 고객수 1증가
    		System.out.println(c.getId()+"님의 로그아웃 했습니다. 현재로그인된 총고객수 : "+loginedCnt);
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
