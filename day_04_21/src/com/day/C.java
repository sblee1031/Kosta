package com.day;

public class C {
	
	Cs cs = null;

	String[] title = {"����", "���鷯����Ʈ","Ÿ��Ÿ��","�����","Ŭ����"};
	String[] director= {"����","���ʹ���","ī�޷�","����ȣ","������"};
	String[] genre= {"�׼�","���","���","������","��ε��"};
	String[] count= {"100��","300��","900��","1000��","150��"};
	String[] actor= {"�帣��","���ϴϽ�","��ī������","�۰�ȣ","���¿�"};
	String[] actress= {"��Ż��","������","����Ʈ","������","�տ���"};
	String[] time= {"120��","200��","160��","120��","120��"};
	
	public C() {
		super();
		// TODO Auto-generated constructor stub
	}



	public C(int i) {
		cs = new Cs();
		cs.setTitle(title[i]);
		cs.setDirector(director[i]);
		cs.setGenre(genre[i]);
		cs.setCount(count[i]);
		cs.setActor(actor[i]);
		cs.setActress(actress[i]);
		cs.setTime(time[i]);
		
		//System.out.println(as.getName());
	
		//ArrayList<String> list = new ArrayList<String>();
		//list.add(as.getName()+" / "+as.getAge()+as.getAddr()+as.getPhone()+as.getGender());
		
		//as.getList(i);
	}
}
