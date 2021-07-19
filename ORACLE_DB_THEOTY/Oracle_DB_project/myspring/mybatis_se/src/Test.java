import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.day.dto.Customer;
import com.day.dto.OrderInfo;
import com.day.dto.OrderLine;
import com.day.dto.Product;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String resource = "mybatis-config.xml"; //"org/mybatis/example/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession(); //jdbc MyConnetion 역할.
			//-------------
			Product p = session.selectOne("com.day.dto.ProductMapper.selectByNo", "C0001");
			System.out.println(p);
			
			//-----------
//			List<Product> list = session.selectList("com.day.dto.ProductMapper.selectAll");
//			System.out.println(list);
			
			//-----------
//			HashMap<String, Integer> map = new HashMap<>();
//			map.put("currentPage",2);//보여줄 페이지
//			map.put("cnt_per_page",4);//페이지별 보여줄 목록
//			List<Product> listCurrentPage = session.selectList("com.day.dto.ProductMapper.selectAllPage",map);
//			System.out.println(listCurrentPage);
//			for (Product product : listCurrentPage) {
//				System.out.println(product);
//			}
			//-----------------
//			List<Product> listName = session.selectList("com.day.dto.ProductMapper.selectByName", "%아%");
//			List<Product> listName = session.selectList("com.day.dto.ProductMapper.selectByName", "아");
//			HashMap<String, String> map1 = new HashMap<>();
//			map1.put("word", "아");
//			map1.put("ordermethod", "prod_name DESC");
//			List<Product> listName = session.selectList("com.day.dto.ProductMapper.selectByName", map1);
//			System.out.println(listName);
			
			//-------------
//			System.out.println("고객추가");
//			HashMap<String, Object> mapCustomer = new HashMap<>();
//			mapCustomer.put("id", "id11");
//			mapCustomer.put("pwd", "pwd10");
//			mapCustomer.put("name", "이름10");
//			mapCustomer.put("buildingno", "1");
			
//			Customer c = new Customer();
//			c.setId("id10");
//			c.setPwd("pwd10");
//			c.setName("이름10");
//			c.setBuildingno("1");
//			session.insert("com.day.dto.CustomerMapper.insert", c);
//			session.commit();//마이바티스는 기본오토커밋이 아님
			//----------------
//			System.out.println("고객정보수정");
//			Customer c1 = new Customer();
//			c1.setId("id11");
//			c1.setEnabled(0);//탈퇴처리
//			c1.setPwd("p122");//비밀번호 변경
//			session.update("com.day.dto.CustomerMapper.update",c1);
//			session.commit();
			
			//--------------
//			System.out.println("고객정보 삭제");
//			String id = "id11";
//			int rowcnt = session.delete("com.day.dto.CustomerMapper.delete", id);
//			if(rowcnt==1) {
//				System.out.println(id+"삭제 완료");
//			}else if(rowcnt <1) {
//				System.out.println(id+"가 없어 삭제 불가");
//			}
//			session.commit();
			
//			Customer c2 = session.selectOne("com.day.dto.CustomerMapper.selectById","id1");
//			System.out.println(c2);

			OrderInfo info = new OrderInfo();
			Customer order_c = new Customer();
			order_c.setId("id1");
			info.setOrder_c(order_c);
			
			List<OrderLine> lines1 = new ArrayList<>();
			OrderLine line1 = new OrderLine();
			Product order_p = new Product();
			order_p.setProd_no("G0001");
			line1.setOrder_p(order_p);
			line1.setOrder_quantity(10);
			lines1.add(line1);
			
			OrderLine line2 = new OrderLine();
			Product order_p2 = new Product();
			order_p2.setProd_no("G0002");
			line2.setOrder_p(order_p2);
			line2.setOrder_quantity(20);
			lines1.add(line2);
			info.setLines(lines1);
			
			session.insert("com.day.dto.OrderMapper.insertInfo", info);
			
			for (OrderLine Line3 : info.getLines()) {
				session.insert("com.day.dto.OrderMapper.insertLine", Line3);
			}
			session.commit();
			
			
			List<OrderInfo> list = session.selectList("com.day.dto.OrderMapper.selectById", "id1");
			System.out.println("id1고객의 주문목록");
			for (OrderInfo orderInfo : list) {
				int order_no = orderInfo.getOrder_no();
				Date order_dt = orderInfo.getOrder_dt();
				List<OrderLine> lines = orderInfo.getLines();
				for (OrderLine line : lines) {
					Product p1 = line.getOrder_p();
					int quantity = line.getOrder_quantity();
					System.out.println("상품번호 : " + p1.getProd_no()+", 상품명 : " + p1.getProd_name()+"가격 : "+p1.getProd_price()+", 주문수량 :"+quantity);
					}
			}
			System.out.println("=================");
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
