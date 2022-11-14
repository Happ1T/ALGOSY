package stack;


public class MyStack {

    NodeForStack head;
    int value = 0;

    private void create(int size){
        head = new NodeForStack();
        head.size = size;
    }
    public int peek(){
        if (!isEmpty()) {
            NodeForStack node = head;
            while (node.nextInd != null) node = node.nextInd;
            return node.size;
        }
        else return 0;
    }
    public void push(int size){
        if (value == 0){
            create(size);
        }else {
            NodeForStack node = head;
            while (node.nextInd != null) node = node.nextInd;
            node.nextInd = new NodeForStack();
            node.nextInd.size = size;

        }
        value++;
    }

    public void pop(){
        if (value == 0) System.out.println("ERROR");
        else if(value == 1){
            head = null;
            value--;
        }
        else{
            NodeForStack node = head;
            while (node.nextInd.nextInd != null) node = node.nextInd;
            node.nextInd = null;
            value--;
        }
    }

    public void delFirst(){
        head = head.nextInd;
    }
    public void print(){

       while (value != 0){
            System.out.print(peek() + " ");
            pop();
        }
    }
    public boolean isEmpty(){
        if (value < 1) return true;
        return false;
    }



}