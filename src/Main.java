import searching.Student;
import sorting.SortAlgorithms;


public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[10];
        // clone phương thức Arrays.sort()
        SortAlgorithms.bubbleSort(students);
        SortAlgorithms.bubbleSort(students,(o1,o2)->o2.getId()- o1.getId());

    }
}