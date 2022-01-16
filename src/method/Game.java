package method;

import java.util.Arrays;
import java.util.Scanner;

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
	
	//�̱�Ƚ�� ���
	public static void playGame(Car[] car, int count) {
		for(int i=0; i<car.length; i++) {
			int dice = Game.getRandomNum();
			if(dice > 4) {
				int winCount = car[i].getWinCount(); 
				car[i].setWinCount(winCount+1);
			}
		}
	}
	
	//���
	public static StringBuilder printPosition(int winCount) {
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0; i<winCount; i++) {
			stringBuilder.append("-");
		}
		return stringBuilder;
	}
	
	//����� ����
	public static StringBuilder getWinner(Car[] car) {
		int[] winCountArray = new int[car.length];
		for(int i=0; i<car.length; i++) {
			winCountArray[i] = car[i].getWinCount();
		}
		Arrays.sort(winCountArray);
		int winnerNum = winCountArray[winCountArray.length-1];
		
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0; i<car.length; i++) {
			if(car[i].getWinCount() == winnerNum) {
				if(i!=0) {
					stringBuilder.append(", ");
				}
				stringBuilder.append(car[i].getName());
			}
		}
		return stringBuilder;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�̸���,�α����Ͽ� �Է����ּ���");
		String names = sc.nextLine();
		String[] nameList = splitName(names);
		//car ��ü ����
		Car[] carArray = new Car[nameList.length];
		for(int i=0; i<carArray.length; i++) {
			carArray[i] = new Car(nameList[i]);		
		}
		System.out.println("�õ��� Ƚ���� �Է����ּ���");
		int count = sc.nextInt();
		
		for(int i=0; i<count; i++) {
			Game.playGame(carArray, count);
			System.out.println("Round "+(i+1));
			for(int j=0; j<carArray.length; j++) {
				System.out.println(carArray[j].getName() + " : " + Game.printPosition(carArray[j].getWinCount()));
			}
			System.out.println();
		}
		
		System.out.println("�����");
		System.out.println(Game.getWinner(carArray));
		
	}
}
