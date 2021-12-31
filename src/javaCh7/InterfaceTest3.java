package javaCh7;

public class InterfaceTest3 {
	public static void main(String[] args) {
		A2 a = new A2();
		a.methodA();
	}
}

class A2 {
	void methodA() {
		I2 i = InstanceManager.getInstance();
		i.methodB();
		System.out.println(i.toString());
	}
}

interface I2 {
	public abstract void methodB();
}

class B2 implements I2 {
	public void methodB() {
		System.out.println("methodB in B2 class");
	}
	public String toString() {
		return "class B2";
	}
}

class InstanceManager {
	public static I2 getInstance() {
		return new B2();
	}
}