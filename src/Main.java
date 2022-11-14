import array.Array;
import list.MyLinkedList;
import missions.Timsort;
import stack.MyStack;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;

// | best | Average |  Worst  |
// |  n   | nlog(n) | nlog(n) |
public class Main {

    public static void main(String[] args) {
        MyLinkedList listOfRun = new MyLinkedList();
        Array array = new Array();
        MyStack stack = new MyStack();


        String str = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите размер массива:");
        int value = scanner.nextInt();
        array.create(1, generateRandomInt(100000));
        for (int i = 0; i < value -1; i++) array.addElement(generateRandomInt(100000));

        array.print();

        long startTime = System.currentTimeMillis();

        int minrun = array.getMinrun(array.getSize());
        System.out.println(minrun);
        boolean back = true;
        boolean isUp = false;
        boolean isSort = true;

        Array run = null;
        for (int i = 0; i < array.getSize(); i++){

            if (back) {
                if(i != 0) {
                    listOfRun.addElements(insertSort(run.getArray(), run.getSize()), run.getSize(), -1);
                }
                run = new Array();
                run.create(minrun, array.getElement(i));
                back = false;
                isSort = true;
                if      (array.getElement(i) > array.getElement(i+1)) isUp = false;
                else if (array.getElement(i) < array.getElement(i+1)) isUp = true;
                else{
                    int countOfEqual = 0;
                    while (countOfEqual < array.getSize()-1){
                        if      (array.getElement(countOfEqual) > array.getElement(i+1)){ isUp = false; break;}
                        else if (array.getElement(countOfEqual) < array.getElement(i+1)){ isUp = true; break;}
                        countOfEqual++;
                    }
                    if (countOfEqual == array.getSize()-1){
                        System.out.println("Массив отсортирован:");
                        array.print();
                    }
                }
            }
            else if(isSort){
                if      ( !( (array.getElement(i-1) <= array.getElement(i) && isUp)  ||  (array.getElement(i-1) >= array.getElement(i) && !isUp) ) ) isSort = false;
                run.addElement(array.getElement(i));
            }else {
                if(run.getSize() >= minrun-1)
                    back = true;
                run.addElement(array.getElement(i));
            }
        }
        listOfRun.addElements(insertSort(run.getArray(), run.getSize()), run.getSize(), -1);


        int X = 0;
        int Y = 0;
        int Z = 0;
        for (int i = 0; i < listOfRun.getSize(); i++){
            stack.push(listOfRun.getSizeOfElement(i));
            if(i > 1){
                X = listOfRun.getSizeOfElement(i);
                Y = listOfRun.getSizeOfElement(i-1);
                Z = listOfRun.getSizeOfElement(i-2);
                if(!(Y > X && Z > Y + X)){
                    stack.pop();
                    stack.pop();
                    if (X > Z){
                        stack.pop();
                        stack.push(Y+Z);
                        stack.push(X);
                        listOfRun.addElements(mergeSort(listOfRun.getElement(i-2), Z, listOfRun.getElement(i-1), Y),Z+Y, i);
                        listOfRun.delElement(i);
                        listOfRun.delElement(i-1);

                    }
                    else {
                        stack.push(Y+Z);
                        listOfRun.addElements(mergeSort(listOfRun.getElement(i), X, listOfRun.getElement(i-1), Y),X+Y, i);
                        listOfRun.delElement(i);
                        listOfRun.delElement(i+1);
                    }
                    i--;
                }
            }
        }
        int i = listOfRun.getSize()-1;
        while(listOfRun.getSize() !=1 ){
            X = listOfRun.getSizeOfElement(i);
            Y = listOfRun.getSizeOfElement(i-1);
            listOfRun.addElements(mergeSort(listOfRun.getElement(i), X, listOfRun.getElement(i-1), Y),X+Y, i);
            listOfRun.delElement(i);
            listOfRun.delElement(i+1);
        }

        listOfRun.print();

        System.out.println();
        System.out.println("Количество элементов в массиве: " + value);
        System.out.println("Время выполнения алгоритма: " +((System.currentTimeMillis() - startTime) /1000 ) + " секунда" );
    }

    public static int generateRandomInt(int upperRange){
        Random random = new Random();
        return random.nextInt(upperRange);
    }

    public static int[] insertSort(int[] array, int size){
        for (int left = 0; left < size; left++) {
            // Вытаскиваем значение элемента
            int value = array[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            array[i + 1] = value;
        }
        return array;
    }

    public static int[] mergeSort(int[] array1,int size1, int[] array2, int size2){
        int[] newArray = new int[size2 + size1];
        int i = 0, j = 0, k = 0;
        while (i != size1 && j != size2){
            if (array1[i] < array2[j]) {
                newArray[k] = array1[i];
                i++;

            }
            else{
                newArray[k] = array2[j];
                j++;
            }
            k++;

            if (i - j == 7){
               int index = binarySearch(array1, size1, array2[j]);
                for ( ; i< index; i++, k++){
                    newArray[k] = array1[i];
                }
            }else if(j - i ==7){
                int index = binarySearch(array2, size2, array1[i]);
                for ( ; i< index; i++,k++){
                    newArray[k] = array2[j];
                }
            }
        }
        while (i != size1) {
            newArray[k] = array1[i];
            i++;
            k++;
        }
        while(j != size2){
            newArray[k] = array2[j];
            j++;
            k++;
        }

        return newArray;
    }

    public static int binarySearch(int[] array, int size, int key){
        boolean found = false;

        int high = size - 1, low = 0;
        int middle = (high + low) / 2;
        int prevMiddle = 0;
        while (!found && high >= low){
            if (key == array[middle])
                return middle;
            else if (key < array[middle])
                return prevMiddle;
            else
                low = middle + 1;
            prevMiddle = middle;
            middle = (high + low) / 2;
        }
        return size;

    }
}