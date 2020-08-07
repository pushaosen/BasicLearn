package 循环引用问题;

public class Dog extends Parent {

	@Override
	public void sleep() {
		System.out.println("子类重写父类的睡觉的方法了");
		AbstractAnimal parent = new Parent();
		parent.eat();
	}
}
