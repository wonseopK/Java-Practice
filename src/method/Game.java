package method;

import car.Car;

public class Game {
	//�̸� �и�
	public static String[] splitName(String names) {
		String[] nameList = names.split(",");
		return nameList;
	}
	
	//�ֻ���
	public static int getRandomNum() {
		return (int)(Math.random()*6); 
	}
	
	//���
	public StringBuilder printPosition(int winCount) {
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0; i<winCount; i++) {
			stringBuilder.append("-");
		}
		return stringBuilder;
	}
	
	
	public static String compareWinnser(Car[] car) {
		
		
		return "";
	}
}
