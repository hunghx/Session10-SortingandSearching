package searching;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SearchAlgorithms {
    // Generic  - tham số cho kiểu dữ liệu
//    public static void main(String[] args) {
//        List<Integer> listNumber = Arrays.asList(2,4,6677,80,78,54,23,12,86,36,9);
////        boolean check = linearSearching(listNumber,231);
//        // sắp xếp danh sách
//        Collections.sort(listNumber);
//        boolean check = binarySearching(listNumber,23);
//        if (check){
//            System.out.println("có tồn tại phần tử cần tìm");
//        }else {
//            System.out.println("Không tồn tại ");
//        }
//    }

    public static void main(String[] args) {
        Student s1 = new Student(1,"Hùng");
        List<Student> students = Arrays.asList(s1,new Student(2,"Nam"));

        System.out.println(linearSearching(students,s1));

        // sắp xếp danh sách
        Collections.sort(students);
        System.out.println(binarySearching(students,s1));
    }
    public static <T> boolean linearSearching(List<T> list,T element){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(element)){
                // tìm được phần tử
                return true;
            }
        }
        return false;
    }

    public static <T extends Comparable<T>> boolean binarySearching(List<T> list,T element){
        int start = 0;
        int end = list.size()-1;
        while (end>=start) {
            int mid = start + (end - start) / 2; // (start+end)/2
            if (list.get(mid) == element) {
                return true;
            } else if (list.get(mid).compareTo(element)>0) {
                // kiểm tra danh sách bên trái phần tử mid
                end = mid-1;
            } else {
                // kiêm tra bên phải của phần tử mid
                start= mid+1;
            }
        }
        return false;

    }
}
