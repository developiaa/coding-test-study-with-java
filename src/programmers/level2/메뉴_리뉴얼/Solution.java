package programmers.level2.메뉴_리뉴얼;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4}; // ["AC", "ACDE", "BCFG", "CDE"]

//        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//        int[] course = {2, 3, 5}; // ["ACD", "AD", "ADE", "CD", "XYZ"]

//        String[] orders = {"XYZ", "XWY", "WXA"};
//        int[] course = {2, 3, 4}; // ["WX", "XY"]
        System.out.println(Arrays.toString(solution(orders, course)));
    }

    public static String[] solution(String[] orders, int[] course) {
        List<Set<String>> orderList = Arrays.stream(orders)
                .map(String::chars)
                .map(charStream -> charStream
                        .mapToObj(menu -> String.valueOf((char) menu))
                        .collect(Collectors.toSet()))
                .toList();
        Map<Integer, List<Course>> courses = new HashMap<>();
        for (int length : course) {
            List<Course> list = new ArrayList<>();
            list.add(new Course(0, ""));
            courses.put(length, list);
        }
        getCourses('A', new HashSet<>(), orderList, courses);
        return courses.values().stream()
                .filter(list -> list.get(0).occurrence > 0)
                .flatMap(List::stream)
                .map(c -> c.course)
                .sorted()
                .toArray(String[]::new);
    }

    public static void getCourses(char nextMenu, Set<String> selectedMenus,
                                  List<Set<String>> orderList, Map<Integer, List<Course>> courese) {
        int count = (int) orderList.stream()
                .filter(order -> order.containsAll(selectedMenus))
                .count();
        if (count < 2) return;
        int size = selectedMenus.size();
        if (courese.containsKey(size)) {
            List<Course> courseList = courese.get(size);
            Course course = new Course(count, selectedMenus.stream()
                    .sorted()
                    .collect(Collectors.joining("")));

            Course original = courseList.get(0);
            if (original.occurrence < count) {
                courseList.clear();
                courseList.add(course);
            } else if (original.occurrence == count) {
                courseList.add(course);
            }
        }
        if (size >= 10) {
            return;
        }

        for (char menuChar = nextMenu; menuChar <= 'Z'; menuChar++) {
            String menu = String.valueOf(menuChar);
            selectedMenus.add(menu);
            getCourses((char) (menuChar + 1), selectedMenus, orderList, courese);
            selectedMenus.remove(menu);
        }

    }


    public static class Course {
        private final int occurrence;
        private final String course;

        public Course(int occurrence, String course) {
            this.occurrence = occurrence;
            this.course = course;
        }
    }
}
