package 循环引用问题;

public class TestMethod {

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractAnimal parent = new Dog();
		parent.eat();
	}
}
