package com.day;

public class C implements I{
	

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

	@Override
	public String data_text() {
		String text = "";
		for (int i = 0; i < title.length; i++) {
			text += title[i]+" / "+director[i]+" / "+genre[i]+" / "+count[i]+" / "+actor[i]+" / "+actress[i]+" / "+time[i]+"\n";
		}
		
		return text;
	}



	
}
