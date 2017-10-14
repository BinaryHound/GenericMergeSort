package genericbubblesort;

import java.util.Comparator;

/**
 *
 * @author lennardneuwirth
 */
public class GenericBubbleSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
    }
    
    public static <E extends Comparable<E>> void bubbleSort(E[] list){
        E temp;
        //Bubble sorts the list in ascending order.
        for(int i = 0; i < list.length; i++){
            for(int x = 1; x < list.length; x++){
                if(list[i].compareTo(list[x]) > 1){
                    temp = list[x];
                    list[x] = list[i];
                    list[i] = temp;
                } 
            }
        }
    }
    
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator){
        E temp;
        for(int i = 0; i < list.length; i++){
            for(int x = 1; x < list.length; x++){
                
            }
        }
        
        
    }
    
    
}
