import java.util.Arrays; //Week06_03
import java.util.List;
import java.util.stream.Collectors;

/*public class Test {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Kim", "Park", "Lee", "Choi", "Chee"); //(1)
		
		List<String> sublist = list.stream() //스트림생성
		.filter(s->s.startsWith("C"))	//스트림처리
		.sorted()	//스트림처리
		.collect(Collectors.toList());	//결과생성
		
	System.out.println(sublist); //결과출력
	}
}*/


enum Type {
	MEAT, FISH, OTHER
} //열거형 상수집합을 정의하는 데이터 유형

public class Test {
	public static void main(String[] args) {
		List<Food> menu = Arrays.asList(new Food("salad", true, 200, Type.OTHER),
				new Food("beef", false, 7100, Type.MEAT), new Food("chicken", false, 1400, Type.MEAT),
				new Food("rice", true, 3510, Type.OTHER), new Food("season fruit", true, 1120, Type.OTHER),
				new Food("pizza", true, 5150, Type.OTHER), new Food("salmon", false, 4150, Type.FISH));

		List<Food> list = menu.stream().filter(p -> p.calories < 300).filter(p -> p.Vege == true)
				.collect(Collectors.toList());
		System.out.println(list);

	}
}