import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap();
//		fun(map);
		System.out.println(map);
		System.out.println(map.isEmpty());
		
		List<String> list = new ArrayList<>();
		list.add("ÕÅÈý");
		List<String> temp = Collections.unmodifiableList(list);

		System.out.println(temp);
		
		BigDecimal nBj = new BigDecimal(222);
		System.out.println(nBj);
		nBj = nBj.subtract(BigDecimal.ZERO);
		System.out.println(nBj);
		
	}
	
	public static void fun(Map<String, String> map) {
		map.put("name", "zhangsan");
	}

}
