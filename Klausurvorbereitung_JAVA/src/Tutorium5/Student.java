package Tutorium5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Student {
    String name;
    int id;
    String university;

    public Student(String name, int id, String university) {
        this.name = name;
        this.id = id;
        this.university = university;
    }


    public static void main(String[] args) {
        Student anna = new Student("Anna", 1, "TU");
        Student max = new Student("Max", 2, "HU");
        Student sam = new Student("Sam", 3, "FU");

        List<Student> students = new ArrayList<>();

        students.add(anna);
        students.add(max);
        students.add(sam);

        Stream<String> unis = students.stream().map(student -> student.university);
        System.out.println(Arrays.toString(unis.toArray()));

        Stream<Student> tuStudents = students.stream().filter(student -> student.university.equals ("TU"));

        int sum = students. stream(). reduce( 0, (acc, student) -> acc + student.id, Integer::sum);
        System.out.println(sum);
    }
}