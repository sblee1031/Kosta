package com.day;

public class C extends Cs{
	
	Cs cs = null;

	String[] title = {"레옹", "쉰들러리스트","타이타닉","기생충","클래식"};
	String[] director= {"룩배송","스필버그","카메론","봉준호","곽제영"};
	String[] genre= {"액션","드라마","드라마","스릴러","멜로드라마"};
	String[] count= {"100만","300만","900만","1000만","150만"};
	String[] actor= {"장르노","리암니슨","디카프리오","송강호","조승우"};
	String[] actress= {"나탈리","엠베스","케이트","조여정","손예진"};
	String[] time= {"120분","200분","160분","120분","120분"};
	
	public C() {
		super();
		// TODO Auto-generated constructor stub
	}

	public C(int i) {
		setTitle(title[i]);
		setDirector(director[i]);
		setGenre(genre[i]);
		setCount(count[i]);
		setActor(actor[i]);
		setActress(actress[i]);
		setTime(time[i]);
	}
	
	
	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return title.length;
	}


	
}
