import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();
		list.add(new Person(1,"jay"));
		list.add(new Person(2,"jay"));
		list.add(new Person(3,"tom"));
		list.add(new Person(4,"jay"));
		list.add(new Person(5,"tom"));
		Map<String, List<Person>> collect = list.stream().collect(Collectors.groupingBy(Person::getName));
		
		System.out.println(collect);
		
		BigDecimal b = new BigDecimal("0");
		b = b.add(new BigDecimal(3));
		System.out.println(b);
		b = b.add(new BigDecimal(3));
		System.out.println(b);
		
		String path = "qtfyrdqkList(other-qtfy-3)--qtfyqk(object)";
		String pathPrefix = path.substring(0, path.indexOf(")") + 1);
        path = path.indexOf("--") > -1 ? path.substring(path.indexOf("--") + 2) : "";
        //获取key
        String key = pathPrefix.substring(0, pathPrefix.indexOf("("));

        // 拿到后序的路径
        pathPrefix = pathPrefix.substring(pathPrefix.indexOf("(") + 1, pathPrefix.indexOf(")"));

        int position = pathPrefix.indexOf("-");
        String type = position > -1 ? pathPrefix.substring(0, position) : pathPrefix;
        String lastPath = position > 0 ? pathPrefix.substring(position + 1) : "";
		
		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			Calendar cl = Calendar.getInstance(); 
			cl.add(Calendar.DAY_OF_MONTH, -7 * 2); 
			int year = cl.get(Calendar.WEEK_OF_YEAR);
			System.out.println(year);
			System.out.println(cl.get(Calendar.MONTH));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
