package com.day;

import java.util.ArrayList;
import java.util.HashMap;



public class Movie2 implements I{
	
	
	String[] title = {"레옹", "쉰들러리스트","타이타닉","기생충","클래식"};
	String[] director= {"룩배송","스필버그","카메론","봉준호","곽제영"};
	String[] genre= {"액션","드라마","드라마","스릴러","멜로드라마"};
	String[] count= {"100만","300만","900만","1000만","150만"};
	String[] actor= {"장르노","리암니슨","디카프리오","송강호","조승우"};
	String[] actress= {"나탈리","엠베스","케이트","조여정","손예진"};
	String[] time= {"120분","200분","160분","120분","120분"};
	
	@Override
	public ArrayList<String> GetList() {

				ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < title.length; i++) {
			list.add(title[i]);
			
		}
		
		return list;
	}
	
	
	
}
