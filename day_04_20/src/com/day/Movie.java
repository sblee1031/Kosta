package com.day;

public class Movie implements Comparable<Movie>{
	
	MovieS s = null;
	String[] title = {"����", "���鷯����Ʈ","Ÿ��Ÿ��","�����","Ŭ����"};
	String[] director= {"����","���ʹ���","ī�޷�","����ȣ","������"};
	String[] genre= {"�׼�","���","���","������","��ε��"};
	String[] count= {"100��","300��","900��","1000��","150��"};
	String[] actor= {"�帣��","���ϴϽ�","��ī������","�۰�ȣ","���¿�"};
	String[] actress= {"��Ż��","������","����Ʈ","������","�տ���"};
	String[] time= {"120��","200��","160��","120��","120��"};
	
	
	public Movie(int i) {
		s = new MovieS();
		s.setTitle(title[i]);
		s.setDirector(director[i]);
		s.setGenere(genre[i]);
		s.setCount(count[i]);
		s.setActor(actor[i]);
		s.setActress(actress[i]);
		s.setTime(time[i]);
		
	}


	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return this.s.getTitle().compareTo(o.s.getTitle()) ;
	}
	
}
