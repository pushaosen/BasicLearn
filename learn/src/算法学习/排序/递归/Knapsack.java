package �㷨ѧϰ.����.�ݹ�;

/**
 * ��������
 * @author lenovo
 *
 */
public class Knapsack {
	
	private int[] weights;   // �ɹ�ѡ�������
	private boolean[] selects;   // ��¼�Ƿ�ѡ��
	
	public Knapsack(int[] weights) {
		this.weights = weights;
		selects = new boolean[weights.length];
	}
	
	public void knapsack(int total, int index) {
		if(total < 0 || total > 0 && index >= weights.length) {
			return;   //û�ҵ�����취��ֱ��
		}
		if(total == 0){//������Ϊ0�����ҵ�����취��
            for(int i = 0 ; i < index ; i++){
                if(selects[i] == true){
                    System.out.println(weights[i]+" ");
                }
            }
            System.out.println();
            return;
        }
        selects[index] = true;
        knapsack(total-weights[index], index+1);
        selects[index] = false;
        knapsack(total, index+1);
    }
     
    public static void main(String[] args) {
        int array[] = {11,9,7,6,5};
        int total = 20;
        Knapsack k = new Knapsack(array);
        k.knapsack(total, 0);
    }

}
