package 算法学习.二叉树;

/**
 *	总结：树是由边和节点构成，根节点是树最顶端的节点，它没有父节点；二叉树中，最多有两个子节点；某个节点的左子树每个节点都比该节点的关键值小，右子树的每个节点都比该节点的关键字值大，
 *      那么这种树称为二叉搜索树，其查找、插入、删除的时间复杂度都为logN；可以通过前序遍历、中序遍历、后序遍历来遍历树，前序遍历是：根节点-左子树-右子树，中序遍历是：左子树-根节点
 *      -右子树，后序遍历是：左子树-右子树-根节点；删除一个节点只需要断开指向它的引用即可；哈夫曼是二叉树，用于数据压缩算法，最经常出现的字符编码位数最少，很少出现的字符编码位数多一些。
 *
 */
public class BinaryTree implements Tree {
	
	//表示根节点
    private Node root;
 
    /**
     * 查找节点
     * 时间复杂度为：O(logN)，N表示的是二叉树节点的总数，而不是层数。
     * 每一层最多有2n-1个节点，总共N层共有2n-1个节点，那么时间复杂度为O(logN),底数为2。
     */
    public Node find(int key) {
        Node current = root;
        while(current != null){
            if(current.data > key){//当前值比查找值大，搜索左子树
                current = current.leftChild;
            }else if(current.data < key){//当前值比查找值小，搜索右子树
                current = current.rightChild;
            }else{
                return current;
            }
        }
        return null;//遍历完整个树没找到，返回null
    }
 
    //插入节点
    public boolean insert(int data) {
        Node newNode = new Node(data);
        if(root == null){//当前树为空树，没有任何节点
            root = newNode;
            return true;
        }else{
            Node current = root;      // 表示当前节点
            Node parentNode = null;   // 表示父节点 
            while(current != null) {  // 当前节点不为null的时候继续向下遍历
            	parentNode = current;
            	if(current.data > data) {   // 当前值比插入值大，搜索左子节点
            		current = current.leftChild;
            		if(current == null) {  // 左子节点为空，直接将新值插入到该节点
            			parentNode.leftChild = newNode;   // 将新节点直接赋给树的左子节点
            			return true;
            		}
            	}else {   // 否则搜索右子树
            		current = current.rightChild;
            		if(current == null) {  // 右子节点为空，直接将新值插入到该节点
            			parentNode.rightChild = newNode;   // 将新节点直接赋给树的右子节点
            			return true;
            		}
            	}
            }
        }
        return false;   // 所有的情况都不满足，则返回false
    }
     
    //中序遍历
    public void infixOrder(Node current){
        if(current != null){
            infixOrder(current.leftChild);
            System.out.print(current.data+" ");
            infixOrder(current.rightChild);
        }
    }
     
    //前序遍历
    public void preOrder(Node current){
        if(current != null){
            System.out.print(current.data+" ");
            infixOrder(current.leftChild);
            infixOrder(current.rightChild);
        }
    }
     
    //后序遍历
    public void postOrder(Node current){
        if(current != null){
            infixOrder(current.leftChild);
            infixOrder(current.rightChild);
            System.out.print(current.data+" ");
        }
    }
    
    //找到最大值：一直遍历右子树
    public Node findMax(){
        Node current = root;
        Node maxNode = current;
        while(current != null){
            maxNode = current;
            current = current.rightChild;
        }
        return maxNode;
    }
    
    //找到最小值：一直遍历左子树
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
        Node current = root;   // 当前节点
        Node parent = root;    // 父节点 
        boolean isLeftChild = false;
        //查找删除值，找不到直接返回false
        while(current.data != key){   // 如果不等于当前节点的值的话，就会遍历左右子树
            parent = current;     // 将当前节点赋给父节点
            if(current.data > key){   // 如果点前节点的值大于需要删除的值，则将当前节点的左子节点赋给当前节点
                isLeftChild = true;
                current = current.leftChild;  // 将当前节点的左子节点赋给当前节点
            }else{                   // 否则的话，表示当前节点的值小于需要删除的值，则将当前节点的右子节点赋给当前节点
                isLeftChild = false;
                current = current.rightChild;    // 将当前节点的右子节点赋给当前节点
            }
            if(current == null){    // 如果当前节点为null，直接返回false，结束递归
                return false;
            }
        }
        //如果当前节点没有子节点，这里做：删除节点数据后，左右子节点上移的问题
        if(current.leftChild == null && current.rightChild == null){
            if(current == root){
                root = null;
            }else if(isLeftChild){
                parent.leftChild = null;
            }else{
                parent.rightChild = null;
            }
            return true;
             
            //当前节点有一个子节点，右子节点
        }else if(current.leftChild == null && current.rightChild != null){
            if(current == root){
                root = current.rightChild;
            }else if(isLeftChild){
                parent.leftChild = current.rightChild;
            }else{
                parent.rightChild = current.rightChild;
            }
            return true;
            //当前节点有一个子节点，左子节点
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
            //当前节点存在两个子节点
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
        //后继节点不是删除节点的右子节点，将后继节点替换删除节点
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
        bt.delete(10);//删除没有子节点的节点
        bt.delete(30);//删除有一个子节点的节点
        bt.delete(80);//删除有两个子节点的节点
        System.out.println(bt.findMax().data);
        System.out.println(bt.findMin().data);
        System.out.println(bt.find(100));
        System.out.println(bt.find(200));
    }
}
