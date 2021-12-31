package javaCh7;

import java.util.Vector;

class Product3 {
	int price;
	int bonusPoint;
	
	Product3 (int price){
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
	
	Product3() {
		price = 0;
		bonusPoint = 0;
	}
}

class Tv3 extends Product3 {
	Tv3() {
		super(100);
	}
	public String toString() {
		return "Tv";
	}
}

class Computer3 extends Product3 {
	Computer3() {
		super(200);
	}
	public String toString() {
		return "Computer";
	}
}

class Audio3 extends Product3 {
	Audio3() {
		super(50);
	}
	
	public String toString() {
		return "Audio";
	}
}

class Buyer3 {
	int money = 1000;
	int BonusPoint = 0;
	Vector item = new Vector();
	
	void buy(Product3 p) {
		if(money < p.price) {
			System.out.println("�ܾ��� �����Ͽ� ������ ��� �����ϴ�.");
			return;
		}
		
		money -= p.price;
		BonusPoint += p.bonusPoint;
		item.add(p);
		System.out.println(p + "��/�� �����ϼ̽��ϴ�.");
	}
	
	void refund (Product3 p) {
		if(item.remove(p)) {
			money += p.price;
			BonusPoint -= p.bonusPoint;
			System.out.println(p + "��/�� ��ǰ�ϼ̽��ϴ�.");
		} else {
			System.out.println("�����Ͻ� ��ǰ �� �ش� ��ǰ�� �����ϴ�.");
		}
	}
	
	void summary() {
		int sum = 0;
		String itemList = "";
		
		if(item.isEmpty()) {
			System.out.println("�����Ͻ� ��ǰ�� �����ϴ�.");
			return;
		}
		for(int i=0; i<item.size(); i++) {
			Product3 p = (Product3) item.get(i);
			sum += p.price;
			itemList += (i==0) ? "" + p : ", " + p;
		}
		System.out.println("�����Ͻ� ��ǰ�� �ѱݾ��� " + sum + "�����Դϴ�.");
		System.out.println("�����Ͻ� ��ǰ�� " + itemList + "�Դϴ�.");
	}
}

public class PolyArgumentTest3 {
	public static void main(String[] args) {
		Buyer3 b = new Buyer3();
		Tv3 tv = new Tv3();
		Computer3 com = new Computer3();
		Audio3 audio = new Audio3();
		
		b.buy(tv);
		b.buy(com);
		b.buy(audio);
		b.summary();
		System.err.println();
		b.refund(com);
		b.summary();
	}
}
