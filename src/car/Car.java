package car;

public class Car{
	private String name;
	private int winCount = 0;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWinCount() {
		return winCount;
	}

	public void setWinCount(int winCount) {
		this.winCount = winCount;
	}

	public Car(String name) {
		super();
		this.name = name;
	}

}
