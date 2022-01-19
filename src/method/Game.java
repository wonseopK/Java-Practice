package method;

import java.util.Arrays;
import java.util.Scanner;

import car.Car;

public class Game {
	public static String getPlayerNames() {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을,로구분하여 입력해주세요");
		return sc.nextLine();
	}
	
	public static String[] splitPlayerNames(String names) {
		String[] playerList = names.split(",");
		return playerList;
	}
	
	public static Car[] setPlayerCars(String[] playerList) {
		Car[] playerCars = new Car[playerList.length];
		for(int i=0; i<playerCars.length; i++) {
			playerCars[i] = new Car(playerList[i]);		
		}
		return playerCars;
	}
	
	public static int getPlayCount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("시도할 횟수를 입력해주세요");
		return sc.nextInt();
	}
	
	public static int getRandomDiceNumber() {
		return (int)(Math.random()*6); 
	}
	
	public static boolean isWin() {
		return (Game.getRandomDiceNumber() > 4);
	}
	
	public static void plusWinCount(Car[] playerCars) {
		for(int i=0; i<playerCars.length; i++) {
			int winCount = playerCars[i].getWinCount(); 
			if(Game.isWin()) {
				playerCars[i].setWinCount(winCount+1);
			}
		}
	}
	
	public static StringBuilder getCurrentPosition(int winCount) {
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0; i<winCount; i++) {
			stringBuilder.append("-");
		}
		return stringBuilder;
	}
	
	public static void printPlayerPosition(Car[] playerCars) {
		for(Car playerCar:playerCars) {
			System.out.println(playerCar.getName() + " : " + Game.getCurrentPosition(playerCar.getWinCount()));
		}
		System.out.println();
	}
	
	public static void playGame(int count, Car[] playerCars) {
		for(int i=0; i<count; i++) {
			System.out.println("Round"+(i+1));
			Game.plusWinCount(playerCars);
			Game.printPlayerPosition(playerCars);
		}
	}
	
	public static boolean isWinner(int winnerNum, Car playerCar) {
		return (playerCar.getWinCount() == winnerNum);
	}
	
	public static StringBuilder getWinnerNameList(int winnerNum, Car[] playerCars) {
		StringBuilder stringBuilder = new StringBuilder();
		int countWinner = 0;
		for(Car playerCar:playerCars) {
			if(isWinner(winnerNum, playerCar)) {
				stringBuilder.append(countWinner == 0 ? "" : ",");
				stringBuilder.append(playerCar.getName());
				countWinner++;
			}
		}
		return stringBuilder;
	}
	
	
	public static StringBuilder getWinnerName(Car[] playerCars) {
		System.out.println("우승자");
		int[] winCountArray = new int[playerCars.length];
		for(int i=0; i<playerCars.length; i++) {
			winCountArray[i] = playerCars[i].getWinCount();
		}
		Arrays.sort(winCountArray);
		int winnerNum = winCountArray[winCountArray.length-1];
		return Game.getWinnerNameList(winnerNum, playerCars);
	}
	
	public static void main(String[] args) {
		Car[] playerCars = Game.setPlayerCars(splitPlayerNames(Game.getPlayerNames()));
		Game.playGame(Game.getPlayCount(), playerCars);
		System.out.println(Game.getWinnerName(playerCars));
	}
}
