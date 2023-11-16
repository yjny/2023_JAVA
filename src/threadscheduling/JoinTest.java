//예제: 2개의 스레드 t1, t2를 만들어서 t1이 종료되기를 기다렸다가(join 이용) t2를 시작하는 예제
package threadscheduling;
public class JoinTest extends Thread {
	public void run() {
		for (int i=0; i<=3; i++) {
			System.out.println(getName()+" "+ i); //스레드의 이름을 반환하고 i를 덧붙여 출력함
		}
	}
	
	public static void main(String args[]) {
		JoinTest t1 = new JoinTest();
		JoinTest t2 = new JoinTest();
		
		t1.setName("duksung01"); //t1의 이름 설정
		t2.setName("duksung02"); //t2의 이름 설정
		
		t1.start();
		try {
			t1.join();
		}catch (Exception e) {
			System.out.println(e);
		}
		t2.start();
	}
}

//getName() : 스레드의 이름을 반환
//setName(String name) : 스레드의 이름을 설정/변경