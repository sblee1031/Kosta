package com.day;

public class C extends Cs{
	
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
