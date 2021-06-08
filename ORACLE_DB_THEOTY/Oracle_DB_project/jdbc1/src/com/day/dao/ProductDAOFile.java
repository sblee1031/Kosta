package com.day.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.day.dto.Product;
import com.day.exception.FindException;

public class ProductDAOFile implements ProductDAO {
	private String fileName = "products.txt";//S0001:갤럭시노트:1000:200101
											 //S0002:갤럭시탭:1500:210401
											 //I0001:아이폰:1000:201201
		@Override
		public List<Product> selectAll() throws FindException {
			//파일에서 데이터 읽기
			//바이트단위, 문자단위처리(o)
//			FileReader fr = null;
			List<Product> list = new ArrayList<>();
			Scanner sc = null;
			try {
				//fr = new FileReader(fileName);
				//fr.read(); //1문자씩 읽기
				//fr.read(cbuf) //배열크기만큼의 문자개수 읽기
				sc = new Scanner(new FileInputStream(fileName));
				while(true) { //파일내용 ex : S0001:갤럭시 노트::200101:4개카메라를 내장한 갤럭시노트는~~
					String line = sc.nextLine(); //S0001:갤럭시노트:1000:200101
					String[] data = line.split(":", 5);
//					System.out.println(data[0]);
					//data[0]-상품번호
					//data[1]-상품이름
					//data[2]-상품가격
					//data[3]-제조일자
					//data[4]-상세설명
//					StringTokenizer st = new StringTokenizer(line,":");
//					while(st.hasMoreElements()) {
//						String token = st.nextToken();
//					}
						String prod_no = data[0];
						String prod_name = data[1];
						int prod_price = -1;
						try {
							prod_price =Integer.parseInt(data[2]);
						} catch (NumberFormatException e) {
							e.printStackTrace();
						}
						
						Date prod_mf_dt = new Date();
						try {
							prod_mf_dt =new SimpleDateFormat("yyMMdd").parse(data[3]);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						String prod_detail = data[4];
						
						Product p = new Product(prod_no
								,prod_name
								,prod_price
								,prod_mf_dt
								,prod_detail);
						list.add(p);
				}
		} catch (FileNotFoundException e) {//Exception으로 에러잡아서 중복된것 같슴돠
			e.printStackTrace();
			throw new FindException("파일을 찾을 수 없습니다.");
		} catch(NoSuchElementException | IllegalStateException e) {
			e.getMessage();
		}finally {
			if(sc != null) {
				sc.close();
			}
		}
		return list;

	}


	@Override
	public List<Product> selectByName(String word) throws FindException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> selectAll(int currentPage) throws FindException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product selectByNo(String prod_no) throws FindException {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {
		ProductDAO dao = new ProductDAOFile();
		try {
			List<Product> all = dao.selectAll();
			System.out.println(all);
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

