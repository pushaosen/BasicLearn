package 接口和继承组合测试;

public abstract class OperateAbstract {
	
	public void fun1() {
		System.out.println("顶级抽象类开始工作了");
		
		// 调用子类的实现方法
		fun2();
	}
	
	abstract void fun2();

}
