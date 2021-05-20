package com.day;


class C1{
    static int static_variable = 1;
    int instance_variable = 2;
    static void static_static(){
        System.out.println("static static : "+static_variable);
    }
    static void static_instance(){
        // Ŭ���� �޼ҵ忡���� �ν��Ͻ� ������ ���� �� �� ����. 
        System.out.println("static instance : ");
    }
    void instance_static(){
        // �ν��Ͻ� �޼ҵ忡���� Ŭ���� ������ ���� �� �� �ִ�.
        System.out.println("void static : "+static_variable);
    }
    void instance_instance(){        
        System.out.println("void instance : "+instance_variable);
    }
}

public class Study {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		C1 c = new C1();
		
		c.static_static();
		
		c.static_instance();
		
		c.instance_static();
		
		c.instance_instance();
		System.out.println("-------");
		
		
		int r = c.instance_variable;
		System.out.println(r);

	}

}
