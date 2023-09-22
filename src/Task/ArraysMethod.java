package Task;

import java.util.*;
import java.util.stream.Collectors;

public class ArraysMethod {
    public static List<Integer> searchDuplicate(List<Integer> list) {
        Set<Integer> value = new HashSet<>();
        List<Integer> duplicate = new ArrayList<>();

        for (var val:list) {

            if(!value.add(val)) {
                duplicate.add(val);
            }
        }
        return duplicate;
    }

    public static Collection<String> getStudentsNames(List<Teacher> teachers) {

        return teachers.stream()
                .flatMap(n -> n.getStudents().stream())
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    public static List<String> sortedList(List<String> listSymbol) {
        List<String> sortList = listSymbol.stream().sorted((a, b) -> {
            if (a.equals("e") || a.equals("d")) {
                return -1;
            } else if (b.equals("e") || b.equals("d")) {
                return 1;
            } else {
                return a.compareTo(b);
            }
        }).collect(Collectors.toList());
        return sortList;
    }

    public static Map<Character, Integer> findMostRepeatedCharacter(String s) {
        Integer count = 0;
        Character value = null;
        Map<Character, Integer> amountSymbol = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (amountSymbol.containsKey(s.charAt(i))) {
                amountSymbol.put(s.charAt(i), amountSymbol.get(s.charAt(i)) + 1);
            } else {
                amountSymbol.put(s.charAt(i), 1);
            }

            if (amountSymbol.get(s.charAt(i)) > count) {
                count = amountSymbol.get(s.charAt(i));
                value = s.charAt(i);
            }
        }
        amountSymbol = new HashMap<>();
        amountSymbol.put(value, count);
        return amountSymbol;
    }
}

class Teacher {
    public Teacher(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    private String name;
    private List<Student> students;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
class Student {
    public Student(String name, String course) {
        this.name = name;
        this.course = course;
    }

    String name;
    String course;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
