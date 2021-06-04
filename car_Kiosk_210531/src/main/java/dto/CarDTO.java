package dto;

public class CarDTO {
	
	private String car_Name; // 차량 이름
	private String car_Num;  // 차량 번호
	private boolean isKey;   // 차키 유무
	private String car_Url;  // 차량 이미지 주소
	private String size;     // 차량 크기
	
	public CarDTO() {
	}

	public CarDTO(String car_Name, String car_Num, boolean isKey, String car_Url, String size) {
		super();
		this.car_Name = car_Name;
		this.car_Num = car_Num;
		this.isKey = isKey;
		this.car_Url = car_Url;
		this.size = size;
	}

	public String getCar_Name() {
		return car_Name;
	}

	public void setCar_Name(String car_Name) {
		this.car_Name = car_Name;
	}

	public String getCar_Num() {
		return car_Num;
	}

	public void setCar_Num(String car_Num) {
		this.car_Num = car_Num;
	}

	public boolean isKey() {
		return isKey;
	}
	
	public boolean getIsKey() {//프런트 car-table.html 타임리프 구동불가로 메서드추가
		return isKey;
	}

	public void setKey(boolean isKey) {
		this.isKey = isKey;
	}

	public String getCar_Url() {
		return car_Url;
	}

	public void setCar_Url(String car_Url) {
		this.car_Url = car_Url;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "CarDTO [car_Name=" + car_Name + ", car_Num=" + car_Num + ", isKey=" + isKey + ", car_Url=" + car_Url
				+ ", size=" + size + "]";
	}

}
