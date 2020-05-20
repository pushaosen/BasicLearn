import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class 线程池 {
	@SuppressWarnings("unused")
	private static final ExecutorService executorService  = new ThreadPoolExecutor(60,100,0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024));
	
	public static void main(String[] args) {
//		List<Long> list = new ArrayList<>();
//		list.add(100L);
//		System.out.println(list.indexOf(100L));
		
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("a1", "a1");
		
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("a1", "a2");
		
		list.add(map);
		list.add(map1);
		
		List<Map<String, String>> filterList = list.stream().filter(m -> m.values().equals("a1")).collect(Collectors.toList());
		System.out.println(filterList.size());
		
	}
	
//	private List   flatMap(List<Map<String,String>> datas,String doctorName){
//	    Map<String,String> conditions = new HashMap<>(16);
//	    conditions.put("DoctorName",doctorName);
//	    // 条件map的keyset
//	    Set<String>  conditionKeys = conditions.keySet();
//
//	    List<String> result = datas.stream()
//	            // 展开map的key，通过map的keySet中collection接口提供的stream()
//	            // 方法获取这些set的steam，他们会合并为一个stream。
//	            .flatMap(mp -> mp.values().stream())
//	            // 仅仅选择在conditionKeys中包含的key，如果取非就是不包含在里面的key
//	            .filter(dataKey -> conditionKeys.contains(dataKey))
//	            // 聚合为list
//	            .collect(Collectors.toList());
//
//	    return  result;
//	}
	
}
