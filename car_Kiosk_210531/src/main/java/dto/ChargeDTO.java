package dto;

public class ChargeDTO {
	
	private String car_Size; // 차량 크기
	private int ten_Min;     // 10분당 가격
	private int one_Hour;    // 1시간당 가격
	private int three_Hour;  // 3시간당 가격
	private int six_Hour;    // 6시간당 가격
	private int one_Day;     // 1일당 가격
	private int three_Day;   // 3일당 가격
	
	private static ChargeDTO chargeDTO = new ChargeDTO();
	
	public static ChargeDTO getInstance() {
		if(chargeDTO == null){ //최초 한번만 new 연산자를 통하여 메모리에 할당한다.
			chargeDTO = new ChargeDTO();
		}		
		return chargeDTO;
	}

	public ChargeDTO() {
	}

	public ChargeDTO(String car_Size, int ten_Min, int one_Hour, int three_Hour, int six_Hour, int one_Day,
			int three_Day) {
		super();
		this.car_Size = car_Size;
		this.ten_Min = ten_Min;
		this.one_Hour = one_Hour;
		this.three_Hour = three_Hour;
		this.six_Hour = six_Hour;
		this.one_Day = one_Day;
		this.three_Day = three_Day;
	}
	
	public String getCar_Size() {
		return car_Size;
	}

	public void setCar_Size(String car_Size) {
		this.car_Size = car_Size;
	}

	public int getTen_Min() {
		return ten_Min;
	}

	public void setTen_Min(int ten_Min) {
		this.ten_Min = ten_Min;
	}

	public int getOne_Hour() {
		return one_Hour;
	}

	public void setOne_Hour(int one_Hour) {
		this.one_Hour = one_Hour;
	}

	public int getThree_Hour() {
		return three_Hour;
	}

	public void setThree_Hour(int three_Hour) {
		this.three_Hour = three_Hour;
	}

	public int getSix_Hour() {
		return six_Hour;
	}

	public void setSix_Hour(int six_Hour) {
		this.six_Hour = six_Hour;
	}

	public int getOne_Day() {
		return one_Day;
	}

	public void setOne_Day(int one_Day) {
		this.one_Day = one_Day;
	}

	public int getThree_Day() {
		return three_Day;
	}

	public void setThree_Day(int three_Day) {
		this.three_Day = three_Day;
	}
	
	@Override
	public String toString() {
		return "ChargeDTO [car_Size = " + car_Size + ", ten_Min = " + ten_Min + ", one_Hour = " + one_Hour + ", three_Hour = "
				+ three_Hour + ", six_Hour = " + six_Hour + ", one_Day = " + one_Day + ", three_Day = " + three_Day + "]";
	}
	

}