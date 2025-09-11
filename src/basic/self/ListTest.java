package basic.self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        Number[] arr = {1, 2, 3};

        List<Number> asList = Arrays.asList(arr);
        List<Number> listOf = List.of(arr);
        // 불가
//        List<Number> unList = Collections.unmodifiableList(arr);

        System.out.println("asList = " + asList);
        System.out.println("listOf = " + listOf);

        // 원소 수정
        arr[2] = 999;
        System.out.println();
        System.out.println("asList = " + asList);
        System.out.println("listOf = " + listOf);


        /*
         asList = [1, 2, 3]
         listOf = [1, 2, 3]

         asList = [1, 2, 999]
         listOf = [1, 2, 3]
         */


        System.out.println();
        List<Integer> list = new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
        }};
        // [1, 2, 3]
        System.out.println("list = " + list);

        List<Integer> list1 = Collections.unmodifiableList(list);
        list.add(4);
        // 원본 리스트는 변경 가능하다.
        // [1, 2, 3, 4]
        System.out.println("list = " + list);
        // [1, 2, 3, 4]
        System.out.println("list1 = " + list1);


    }
}
