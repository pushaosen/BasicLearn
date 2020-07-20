package StringBuilder����;

public class TestStringBuilder {
	
	private static StringBuilder sdf = new StringBuilder("old String");

	public static void main(String[] args) {
		fun(sdf, sdf);
		System.out.println(sdf.toString());
		
		StringBuilder sdff = new StringBuilder("old String");
		StringBuilder sdff2 = new StringBuilder("new String");
		
		fun2(sdff, sdff2);
		System.out.println(sdff.toString());
		System.out.println(sdff2.toString());
		
		Person p1 = new Person("����1");
		Person p2 = new Person("����1");
		fun3(p1, p2);
		System.out.println(p1.name);
		System.out.println(p2.name);
		
	}
	
	private static void fun(StringBuilder sdf1, StringBuilder sdf2) {
		sdf1.append(".first method--");
		sdf2.append(".second method--");
		
		StringBuilder sdff = new StringBuilder("new String");
		sdff.append("������");
	}
	
	private static void fun2(StringBuilder sdf1, StringBuilder sdf2) {
		sdf1.append(".first method--");
		sdf2.append(".second method--");
		
		sdf2 = sdf1;
	}
	
	private static void fun3(Person p1, Person p2) {
		p1.name = "����";
		p2.name = "����";
		p1 = new Person("wangwu");
	}
}
