import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class �̳߳� {
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
//	    // ����map��keyset
//	    Set<String>  conditionKeys = conditions.keySet();
//
//	    List<String> result = datas.stream()
//	            // չ��map��key��ͨ��map��keySet��collection�ӿ��ṩ��stream()
//	            // ������ȡ��Щset��steam�����ǻ�ϲ�Ϊһ��stream��
//	            .flatMap(mp -> mp.values().stream())
//	            // ����ѡ����conditionKeys�а�����key�����ȡ�Ǿ��ǲ������������key
//	            .filter(dataKey -> conditionKeys.contains(dataKey))
//	            // �ۺ�Ϊlist
//	            .collect(Collectors.toList());
//
//	    return  result;
//	}
	
}
