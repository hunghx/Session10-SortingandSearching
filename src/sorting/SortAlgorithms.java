package sorting;

import com.sun.org.apache.xalan.internal.xsltc.cmdline.Compile;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortAlgorithms {
    public static void main(String[] args) {
        Random random = new Random();
//        int[] arr = {32,15,7,9,23,99,45,12,9,45,2,1,6,8,0,54,2,16};
        // test bubblesort
//        bubbleSort(arr);
        // test selectionSort
//        selectionSort(arr);
        // test insertionSort
//        insertionSort(arr);

//        tạo ra mảng ngẫu nhiên 10000 phần tử
       List<Integer> list =  Stream.generate(()->random.nextInt(1000000))
               .limit(50000).collect(Collectors.toList());
        Integer[] arr1 = list.toArray(new Integer[50000]);
        Integer[] arr2 = list.toArray(new Integer[50000]);
        Integer[] arr3 = list.toArray(new Integer[50000]);
        Integer[] arr4 = list.toArray(new Integer[50000]);
        System.out.println(arr1.length);
//        System.out.println(Arrays.toString(arr1));
        // so sánh tốc độ thực thi của 3 thuật toán
//        long t1 = System.currentTimeMillis();
//        bubbleSort(arr1);
//        long t2 = System.currentTimeMillis();
//        System.out.println("Giải thuật sắp xếp nổi bọt :"+ (t2-t1) +" milis");
//        long t3 = System.currentTimeMillis();
//        selectionSort(arr2);
//        long t4 = System.currentTimeMillis();
//        System.out.println("Giải thuật sắp xếp chọn :"+ (t4-t3) +" milis");
        long t5 = System.currentTimeMillis();
        insertionSort(arr3);
        long t6 = System.currentTimeMillis();
        System.out.println("Giải thuật sắp xếp chèn :"+ (t6-t5) +" milis");
        long t7 = System.currentTimeMillis();
        Arrays.sort(arr4);
        long t8 = System.currentTimeMillis();
        System.out.println("Giải thuật sắp xếp quickSort:"+ (t8-t7) +" milis");


    }

    public static <T extends Comparable<T>> void bubbleSort(T[] arr){
        // 1,2,3,4,5,6,7,8,9
        boolean check = true;
        for (int i = 1; i < arr.length && check; i++) {
            // đặt giá trị check = false
            check = false;
            for (int j = 0; j < arr.length-i; j++) {
                if(arr[j].compareTo(arr[j+1])>0){
                    T temp = arr[j];
                    arr[j]  = arr[j+1];
                    arr[j+1] = temp;
                    check = true;
                }
            }
        }
    }
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator){
        // 1,2,3,4,5,6,7,8,9
        boolean check = true;
        for (int i = 1; i < arr.length && check; i++) {
            // đặt giá trị check = false
            check = false;
            for (int j = 0; j < arr.length-i; j++) {
                if(comparator.compare(arr[j],arr[j+1]) >0){
                    T temp = arr[j];
                    arr[j]  = arr[j+1];
                    arr[j+1] = temp;
                    check = true;
                }
            }
        }
    }
    public static void selectionSort(Integer[] arr){
        for (int i = 0; i < arr.length-1; i++) {

            int currentMin = arr[i]; // giá trị nhỏ nhất hiện tại
            int indexMin = i; // vị trí min ban đầu

            for (int j = i+1; j < arr.length; j++) {
                if(currentMin > arr[j]){
                    currentMin = arr[j];
                    indexMin = j; // cập nhật lại vị trí min
                }
            }
            // sau khi tim được giá trị bé nhất , tiến hành đổi chỗ nếu khác vị trí dược chọn
            if(i!=indexMin){
                arr[indexMin] = arr[i];
                arr[i] =currentMin;
            }
        }
    }
    public static void insertionSort(Integer[] arr){
        for (int i = 1; i < arr.length; i++) {
            // giả sử phần tử đầu tiên đã được sắp xếp
            // phần tử cần chen là phần tử thứ i
            int currentInsert = arr[i];
            // khai báo biến k là vị trí được chèn cho giá trị hiện tại
            int j;

            for (j = i-1; j>=0 && arr[j]>currentInsert; j--) {
                arr[j+1] = arr[j];
            }
            // chèn giá trị hiện tại vào vị trí j
            arr[j+1] = currentInsert;
        }
    }

}
