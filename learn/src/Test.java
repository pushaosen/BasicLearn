import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
	
	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();
		list.add(new Person(1,"jay"));
		list.add(new Person(2,"jay"));
		list.add(new Person(3,"tom"));
		list.add(new Person(4,"jay"));
		list.add(new Person(5,"tom"));
		Map<String, List<Person>> collect = list.stream().collect(Collectors.groupingBy(Person::getName));
		
		System.out.println(collect);
		
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
