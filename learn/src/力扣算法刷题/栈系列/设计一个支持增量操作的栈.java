package �����㷨ˢ��.ջϵ��;

public class ���һ��֧������������ջ {
	
	/** 
	 * ��Ŀ���������һ��֧������������ջ��
	 * CustomStack(int maxSize)���� maxSize ��ʼ������maxSize
	 *        ��ջ����������ɵ�Ԫ��������ջ�������� maxSize ֮����֧��push ������    
	 * void push(int x)�����ջ��δ������ maxSize ���ͽ� x ��ӵ�ջ����
	 * int pop()������ջ��Ԫ�أ�������ջ����ֵ����ջΪ��ʱ���� -1
	 * void inc(int k, int val)��ջ�׵� k ��Ԫ�ص�ֵ������ val�����ջ��Ԫ������С�� k ����ջ�е�����Ԫ�ض����� val
	 */
	
	/** 
	 * �ⷨһ��ģ��
	 */
	int [] stack;
	int top;
	
	public ���һ��֧������������ջ(int maxSize) {
		stack = new int[maxSize];
		top = -1;
	}
	
	public void push(int x) {
		if(top != stack.length - 1) {
			++ top;
			stack[top] = x;
		}
	}
	
	public int pop() {
		if(top == -1) {
			return -1;
		}
		-- top;
		return stack[top + 1];
	}
	
	public void increament(int k, int val) {
		int limit = Math.min(k, top + 1);
		for(int i = 0; i < limit; ++ i) {
			stack[i] += val;
		}
	}
	
	/** 
	 * �ⷨ����ģ���Ż�
	 * ʱ�临�Ӷȣ�O(1)
	 * �ռ临�Ӷȣ�O(maxSize)
	 */
	int[] stack1;
	int[] add;
	int top1;
	public ���һ��֧������������ջ(int maxSize, int x) {
		stack1 = new int[maxSize];
		add = new int[maxSize];
		top1 = -1;
	}
	
	public void push1(int x) {
		if(top != stack1.length - 1) {
			++ top;
			stack[top] = x;
		}
	}
	
	public int pop1() {
		if(top1 == -1) {
			return -1;
		}
		int ret = stack1[top1] + add[top1];
		if(top != 0) {
			add[top1 - 1] += add[top1];
		}
		add[top1] = 0;
		-- top1;
		return ret;
	}
	
	public void increment1(int k, int val) {
		int limit = Math.min(k - 1, top1);
		if(limit >= 0) {
			add[limit] += val;
		}
	}

}
