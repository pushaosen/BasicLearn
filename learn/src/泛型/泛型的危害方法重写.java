package ����;

/**
 * ���͵����Ͳ��������˲������⡣����һ�����Ƿ�����д��
 * @author lenovo
 *
 */
public class ���͵�Σ��������д {

	
}

// �������͵���(Ҳ������Ϊ����Ļ���)
// ���ࣺCustomer
class Customer{
	
}

// Customer�����ࣺVIP
class VIP extends Customer{
	
}

class Merchant<T extends Customer> {
  public double actionPrice(T customer) {
    return 0.0d;
  }
}

class VIPOnlyMerchant extends Merchant<VIP> {
  @Override
  public double actionPrice(VIP customer) {
    return 0.0d;
  }
  
  public static void main(String[] str) {
	    Customer customer = new VIP();
//	    new VIPOnlyMerchant().actionPrice(customer); // �������    
  }
}

/**
 * �Žӷ����Ľ��ͣ�
 * VIPOnlyMerchant �е� actionPrice �����Ƿ��� Java ���Եķ�����д�ģ�
 * �Ͼ���ʹ�� @Override ��ע���ˡ�Ȼ�����������Ͳ����󣬸���ķ���������Ϊ (LCustomer;)D��
 * ������ķ���������Ϊ (LVIP;)D������Ȼ������ Java ��������ڷ�����д�Ķ���
 * 
 * Ϊ�˱�֤������ɵ� Java �ֽ����ܹ�������д�����壬Java ���������������һ���Žӷ�����
 * ���Žӷ������ֽ��������д�˸���ķ�����������������ķ���
 * */
