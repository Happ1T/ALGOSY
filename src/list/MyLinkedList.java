package list;

public class MyLinkedList {
    Node head = new Node();
    int value = 0;
    public void create(int[] array, int size){
        Node node = head;
        node.array = array;
        node.size = size;
        value = 1;
       /* for (int i = 1; i <= count; i++){
            node.nextInd = new Node();
            node = node.nextInd;
        }
        */
    }


    public int getSize(){ return value; }

    public int[] getElement(int index){
        Node node = head;
        for (int p = 0; p < index; p++) {
            node = node.nextInd;
        }
        return node.array;
    }
    public int getSizeOfElement(int index){
        Node node = head;
        for (int p = 0; p < index; p++) {
            node = node.nextInd;
        }
        return node.size;
    }
    public void print()
    {   Node node = head;
        for (int p = 0; p < value; p++) {
            for (int i = 0; i < node.size; i++) {
                System.out.print(node.array[i] + " ");
            }
            node = node.nextInd;

            System.out.println();
        }
    }

    public void addElements(int[] array, int size, int position){
        if (position == -1) position = value;
        if (position > value || position < 0) System.out.println("ERROR IN ADD");
        else if(position == 0) create(array, size);
        else {
            Node node;
            Node oldNewNode;
            Node newNode = new Node();
            node = head;
            for(int i = 1; i < position; i++){
                node = node.nextInd;
            }
            oldNewNode = node.nextInd;
            node.nextInd = newNode;
            newNode.nextInd = oldNewNode;
            newNode.array = array;
            newNode.size = size;
            value++;

        }



    }

    public void delElement(int position){
        Node node = head;
        if (position > value || position < 1) System.out.println("ERROR IN DEL");
        else if(position == 1) {
            head = head.nextInd;
            value--;
        }
        else
        {
            Node nextNode = new Node();
            Node previousNode = new Node();
            for(int i = 1; i < position-1; i++){
                node = node.nextInd;
            }
            previousNode = node;
            node = node.nextInd;
            previousNode.nextInd = node.nextInd;
            value--;
        }
    }



}
