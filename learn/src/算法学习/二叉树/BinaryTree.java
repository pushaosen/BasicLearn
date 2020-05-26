package �㷨ѧϰ.������;

/**
 *	�ܽ᣺�����ɱߺͽڵ㹹�ɣ����ڵ�������˵Ľڵ㣬��û�и��ڵ㣻�������У�����������ӽڵ㣻ĳ���ڵ��������ÿ���ڵ㶼�ȸýڵ�Ĺؼ�ֵС����������ÿ���ڵ㶼�ȸýڵ�Ĺؼ���ֵ��
 *      ��ô��������Ϊ����������������ҡ����롢ɾ����ʱ�临�Ӷȶ�ΪlogN������ͨ��ǰ���������������������������������ǰ������ǣ����ڵ�-������-����������������ǣ�������-���ڵ�
 *      -����������������ǣ�������-������-���ڵ㣻ɾ��һ���ڵ�ֻ��Ҫ�Ͽ�ָ���������ü��ɣ��������Ƕ���������������ѹ���㷨��������ֵ��ַ�����λ�����٣����ٳ��ֵ��ַ�����λ����һЩ��
 *
 */
public class BinaryTree implements Tree {
	
	//��ʾ���ڵ�
    private Node root;
 
    /**
     * ���ҽڵ�
     * ʱ�临�Ӷ�Ϊ��O(logN)��N��ʾ���Ƕ������ڵ�������������ǲ�����
     * ÿһ�������2n-1���ڵ㣬�ܹ�N�㹲��2n-1���ڵ㣬��ôʱ�临�Ӷ�ΪO(logN),����Ϊ2��
     */
    public Node find(int key) {
        Node current = root;
        while(current != null){
            if(current.data > key){//��ǰֵ�Ȳ���ֵ������������
                current = current.leftChild;
            }else if(current.data < key){//��ǰֵ�Ȳ���ֵС������������
                current = current.rightChild;
            }else{
                return current;
            }
        }
        return null;//������������û�ҵ�������null
    }
 
    //����ڵ�
    public boolean insert(int data) {
        Node newNode = new Node(data);
        if(root == null){//��ǰ��Ϊ������û���κνڵ�
            root = newNode;
            return true;
        }else{
            Node current = root;      // ��ʾ��ǰ�ڵ�
            Node parentNode = null;   // ��ʾ���ڵ� 
            while(current != null) {  // ��ǰ�ڵ㲻Ϊnull��ʱ��������±���
            	parentNode = current;
            	if(current.data > data) {   // ��ǰֵ�Ȳ���ֵ���������ӽڵ�
            		current = current.leftChild;
            		if(current == null) {  // ���ӽڵ�Ϊ�գ�ֱ�ӽ���ֵ���뵽�ýڵ�
            			parentNode.leftChild = newNode;   // ���½ڵ�ֱ�Ӹ����������ӽڵ�
            			return true;
            		}
            	}else {   // ��������������
            		current = current.rightChild;
            		if(current == null) {  // ���ӽڵ�Ϊ�գ�ֱ�ӽ���ֵ���뵽�ýڵ�
            			parentNode.rightChild = newNode;   // ���½ڵ�ֱ�Ӹ����������ӽڵ�
            			return true;
            		}
            	}
            }
        }
        return false;   // ���е�����������㣬�򷵻�false
    }
     
    //�������
    public void infixOrder(Node current){
        if(current != null){
            infixOrder(current.leftChild);
            System.out.print(current.data+" ");
            infixOrder(current.rightChild);
        }
    }
     
    //ǰ�����
    public void preOrder(Node current){
        if(current != null){
            System.out.print(current.data+" ");
            infixOrder(current.leftChild);
            infixOrder(current.rightChild);
        }
    }
     
    //�������
    public void postOrder(Node current){
        if(current != null){
            infixOrder(current.leftChild);
            infixOrder(current.rightChild);
            System.out.print(current.data+" ");
        }
    }
    
    //�ҵ����ֵ��һֱ����������
    public Node findMax(){
        Node current = root;
        Node maxNode = current;
        while(current != null){
            maxNode = current;
            current = current.rightChild;
        }
        return maxNode;
    }
    
    //�ҵ���Сֵ��һֱ����������
    public Node findMin(){
        Node current = root;
        Node minNode = current;
        while(current != null){
            minNode = current;
            current = current.leftChild;
        }
        return minNode;
    }
     
    @Override
    public boolean delete(int key) {
        Node current = root;   // ��ǰ�ڵ�
        Node parent = root;    // ���ڵ� 
        boolean isLeftChild = false;
        //����ɾ��ֵ���Ҳ���ֱ�ӷ���false
        while(current.data != key){   // ��������ڵ�ǰ�ڵ��ֵ�Ļ����ͻ������������
            parent = current;     // ����ǰ�ڵ㸳�����ڵ�
            if(current.data > key){   // �����ǰ�ڵ��ֵ������Ҫɾ����ֵ���򽫵�ǰ�ڵ�����ӽڵ㸳����ǰ�ڵ�
                isLeftChild = true;
                current = current.leftChild;  // ����ǰ�ڵ�����ӽڵ㸳����ǰ�ڵ�
            }else{                   // ����Ļ�����ʾ��ǰ�ڵ��ֵС����Ҫɾ����ֵ���򽫵�ǰ�ڵ�����ӽڵ㸳����ǰ�ڵ�
                isLeftChild = false;
                current = current.rightChild;    // ����ǰ�ڵ�����ӽڵ㸳����ǰ�ڵ�
            }
            if(current == null){    // �����ǰ�ڵ�Ϊnull��ֱ�ӷ���false�������ݹ�
                return false;
            }
        }
        //�����ǰ�ڵ�û���ӽڵ㣬��������ɾ���ڵ����ݺ������ӽڵ����Ƶ�����
        if(current.leftChild == null && current.rightChild == null){
            if(current == root){
                root = null;
            }else if(isLeftChild){
                parent.leftChild = null;
            }else{
                parent.rightChild = null;
            }
            return true;
             
            //��ǰ�ڵ���һ���ӽڵ㣬���ӽڵ�
        }else if(current.leftChild == null && current.rightChild != null){
            if(current == root){
                root = current.rightChild;
            }else if(isLeftChild){
                parent.leftChild = current.rightChild;
            }else{
                parent.rightChild = current.rightChild;
            }
            return true;
            //��ǰ�ڵ���һ���ӽڵ㣬���ӽڵ�
        }else if(current.leftChild != null && current.rightChild == null){
            if(current == root){
                root = current.leftChild;
            }else if(isLeftChild){
                parent.leftChild = current.leftChild;
            }else{
                parent.rightChild = current.leftChild;
            }
            return true;
        }else{
            //��ǰ�ڵ���������ӽڵ�
            Node successor = getSuccessor(current);
            if(current == root){
                root= successor;
            }else if(isLeftChild){
                parent.leftChild = successor;
            }else{
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return false;
         
    }
 
    public Node getSuccessor(Node delNode){
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        //��̽ڵ㲻��ɾ���ڵ�����ӽڵ㣬����̽ڵ��滻ɾ���ڵ�
        if(successor != delNode.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
         
        return successor;
    }
     
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(50);
        bt.insert(20);
        bt.insert(80);
        bt.insert(10);
        bt.insert(30);
        bt.insert(60);
        bt.insert(90);
        bt.insert(25);
        bt.insert(85);
        bt.insert(100);
        bt.delete(10);//ɾ��û���ӽڵ�Ľڵ�
        bt.delete(30);//ɾ����һ���ӽڵ�Ľڵ�
        bt.delete(80);//ɾ���������ӽڵ�Ľڵ�
        System.out.println(bt.findMax().data);
        System.out.println(bt.findMin().data);
        System.out.println(bt.find(100));
        System.out.println(bt.find(200));
    }
}
