package study01.test08;

class Father2{
	int a;
	Father2(){
		System.out.println("I'm a constructor in Father Constructor!");
	}
}

// Constructor = 생성자
public class Constructor2 extends Father2 {
	int b = 10;
	
	Constructor2(){
		System.out.println(b);
		System.out.println(a);
		System.out.println("I'm a constructor in Class Constructor!");
	}
	
	Constructor2(int c){
		System.out.println("b : " + b);
		System.out.println("a : " + a);
		System.out.println("I'm a constructor in Class Constructor with a number!");
	}
	
	public static void main(String[] args) {
		Constructor2 c = new Constructor2();
	}
}