package 接口和继承组合测试;

public class OperateServiceImpl extends OperateAbstract implements IOperateService {

	@Override
	void fun2() {
		System.out.println("子类开始工作了");
	}

}
