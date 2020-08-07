package 循环引用问题;

public class Parent extends AbstractAnimal {

	@Override
	public void eat() {
		System.out.println("父类的调用开始了");
		sleep();
	}

	@Override
	public void sleep() {
		
	}

}
