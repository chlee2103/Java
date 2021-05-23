package AdressProject;

public class AdressDto {
	private String name;
	private String number;
	private String group;
	private String adress;
	private String memo;
	
	public AdressDto() {
		
	}
	
	public AdressDto(String name, String number, String group, String adress, String memo) {
		this.name = name;
		this.number = number;
		this.group = group;
		this.adress = adress;
		this.memo = memo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	@Override
	public String toString() {
		
		return name +number + group + adress + memo;
	}
	
}
