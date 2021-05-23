package bt210521.Ex01;
public class AccountDtoCho {
	
	private String dateTime;	// 날짜 -> Calendar, Date		2021-05-21-14-41-23(년월일시분초)
	private String use;			// 용도 -> 제목(쇼핑, 식사)
	private String classify;	// 수입/지출
	private int money;			// 금액
	private String memo;		// 내용 (비워놔도 된다)
	
	public AccountDtoCho() {
		
	}

	public AccountDtoCho(String dateTime, String classify, String use, int money, String memo) {
		this.dateTime = dateTime;
		this.use = use;
		this.classify = classify;
		this.money = money;
		this.memo = memo;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return dateTime+" "+classify+" "+"용도:"+use+" "+money+" "+memo;
	}
	
	
	
	
	
	
}
