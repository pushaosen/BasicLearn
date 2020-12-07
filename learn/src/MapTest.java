import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
//		fun(map);
		System.out.println(map);
		System.out.println(map.isEmpty());
		
		List<String> list = new ArrayList<>();
		list.add("张三");
		List<String> temp = Collections.unmodifiableList(list);

		System.out.println(temp);
		
		BigDecimal nBj = new BigDecimal(222);
		System.out.println(nBj);
		nBj = nBj.subtract(BigDecimal.ZERO);
		System.out.println(nBj);
		
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(simpleDateFormat.format("张三"));;
	}
	
	public static void fun(Map<String, String> map) {
		map.put("name", "zhangsan");
	}

}
