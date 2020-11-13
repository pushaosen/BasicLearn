package 泛型;

/**
 * 泛型的类型擦除带来了不少问题。其中一个便是方法重写。
 * @author lenovo
 *
 */
public class 泛型的危害方法重写 {

	
}

// 基本类型的类(也就是作为编码的基类)
// 父类：Customer
class Customer{
	
}

// Customer的子类：VIP
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
//	    new VIPOnlyMerchant().actionPrice(customer); // 编译出错    
  }
}

/**
 * 桥接方法的解释：
 * VIPOnlyMerchant 中的 actionPrice 方法是符合 Java 语言的方法重写的，
 * 毕竟都使用 @Override 来注解了。然而，经过类型擦除后，父类的方法描述符为 (LCustomer;)D，
 * 而子类的方法描述符为 (LVIP;)D。这显然不符合 Java 虚拟机关于方法重写的定义
 * 
 * 为了保证编译而成的 Java 字节码能够保留重写的语义，Java 编译器额外添加了一个桥接方法。
 * 该桥接方法在字节码层面重写了父类的方法，并将调用子类的方法
 * */
