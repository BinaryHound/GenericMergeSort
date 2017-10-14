/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericbubblesort;
import java.util.Comparator;

/**
 *
 * @author lennardneuwirth
 */
public class GenericMergeSort<E> {
    
    public static void main(String[] args){
        Integer[] testMerge = {1, 3, 2, 6, 7, 4, 3, 6, 7, 8, 9, 2};
        mergeSort(testMerge);
        for(int x : testMerge){
            System.out.println(x);
        }
    }
    
    public static <E extends Comparable<E>> void mergeSort(E[] list){
        mergeSort(list, (e1, e2) -> ((Comparable<E>)e1).compareTo(e2));
    }
    public static <E> void mergeSort(E[] list, Comparator<? super E> comparator){
        if(list.length > 1){
            //merge sort the first array.
            E[] firstHalf =  (E[]) new Object[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length /2 );
            mergeSort(firstHalf, comparator);
            int secondHalfLength = list.length - list.length / 2;
            E[] secondHalf = (E[]) new Object[secondHalfLength];
            System.arraycopy(list, list.length / 2, 
                             secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf, comparator);
            E[] temp = merge1(firstHalf, secondHalf, comparator);
            System.arraycopy(temp, 0, list, 0, temp.length);
        }
    }

    private static <E> E[] merge1(E[] list1, E[] list2, Comparator<? super E> comparator){
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;
        E[] temp = (E[]) new Object[list1.length + list2.length];
        
        while(current1 < list1.length && current2 < list2.length){
            if(comparator.compare(list1[current1], list2[current2]) < 0){
                temp[current3++] = list1[current1++];
            } else {
                temp[current3++] = list2[current2++];
            }
        }
        
        while(current1 < list1.length){
            temp[current3++] = list1[current1++];
        }
        
        while(current2 < list2.length){
            temp[current3++] = list2[current2++];
        }
        return temp;
    }
}