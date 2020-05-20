package 负载均衡算法.Server;

/**
 * 模拟编号获取工具
 * @author wb-pss576863
 *
 */
public class Sequence {
	public static Integer num = 0;
	public static Integer getAndIncrement() {
		return ++num;
	}
}
