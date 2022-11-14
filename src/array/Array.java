package array;

import list.MyLinkedList;

public class Array {

    int currentValue = 0;
    int maxValue = 0;
    int[] array;

    public void create(int count, int i){
        currentValue = 0;
        maxValue = count;
        array = new int[maxValue];
        array[0] = i;

    }

    public void print(){
        for (int i = 0; i <= currentValue; i++)  System.out.print(array[i] + " ");
        System.out.println();
    }

    public void printSize(){
        System.out.println("Размер массива: " + maxValue);
    }

    public void addElement(int i){
            currentValue++;
            if(currentValue == maxValue) {
                maxValue *= 2;                                                                                          //Увеличил объём памяти
                int[] newArray = new int[maxValue];
                System.arraycopy(array, 0, newArray, 0, currentValue);
                newArray[currentValue] = i;
                array = newArray;
            }
            else array[currentValue] = i;

    }
    public int[] getArray(){
        return array;
    }
    public int getSize(){
        return currentValue+1;
    }
    public int getElement(int index){
        return array[index];
    }

    public void delElement(int position){
        if(position > currentValue || position < 0) System.out.println("Out of value");
        else{
            int[] newArray = new int[maxValue];
            int count = 0;
            int countOld = 0;
            while (count < currentValue){
                if(countOld != position){
                    newArray[count] = array[countOld];
                    count++;
                }
                countOld++;
            }
            currentValue--;
            maxValue -= 2;
            array = newArray;
        }


    }


    ////////////////////////////////////////////////////Timsort////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //берутся старшие 6 бит из N и добавляется единица, если в оставшихся младших битах есть хотя бы один ненулевой.
    public int getMinrun(int n)
    {
        int r = 0;                                                                                                         /* станет 1 если среди сдвинутых битов будет хотя бы 1 ненулевой */
        while (n >= 64) {
            r |= n & 1;
            n >>= 1;
        }
        return n + r;
    }




}
