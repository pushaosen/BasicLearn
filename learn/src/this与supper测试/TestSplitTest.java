package thisÓësupper²âÊÔ;

public class TestSplitTest {
	
	public static void main(String[] args) {
		String str = "123¡¢234¡¢)567¡¢";
		if(str.endsWith("¡¢")) {
			str = str.substring(0, str.length() - 1);
		}
		while(str.contains("¡¢)")) {
			int index = str.indexOf("¡¢)");
			String prefix = str.substring(0, index);
			String pre = str.substring(index + "¡¢)".length(), str.length());
			str = prefix + ")" + pre;
		}
		System.out.println(str);
	}

}
