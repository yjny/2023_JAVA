//예제16-3: sleep()을 이용하여 4초 간격으로 메시지를 출력하는 예제
package threadscheduling;
public class SleepTest {
	public static void main(String[] args) throws InterruptedException{ 
		String messages[] = {"Prides wil have a fall.",
				"Power is dangerous unless you have humility.",
				"Office changes manners.",
				"Empty vessels make the most sound."
		};
		
		//for문을 사용하여 배열의 항목 출력하기
		for (int i = 0; i < messages.length; i++) {	//문자열 배열 messages 항목 개수(4)만큼 반복, i=0,1,2,3
			Thread.sleep(4000);  //4000밀리초, 즉 4초 동안 실행을 중지한다.
			System.out.println(messages[i]);
		}
	}
}

//throws는 Java에서 사용되는 예외 처리 관련 키워드입니다. 
//throws 키워드는 메서드나 생성자 선언 부분에서 사용되며, 해당 메서드가 어떤 예외를 던질 수 있는지를 나타냅니다. 
//예외가 발생할 수 있는 메서드를 호출한 곳에서는 해당 예외에 대한 처리를 해야 합니다.