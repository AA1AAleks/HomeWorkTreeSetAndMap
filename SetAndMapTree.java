package BTreeSetAndMap;

import java.util.*;

public class SetAndMapTree {
    TreeMap<String, Float> treeMap = new TreeMap<>();
    TreeSet<Student> treeSet = new TreeSet<>();

    void addStudent(String name, Float grade){
        Student student = new Student();
        student.name = name;
        student.grade = grade;
        treeMap.put(student.name, student.grade);
        treeSet.add(student);

    }
    List<Student> top3(float score){
        Student sss = new Student();
            sss.grade =  score;

        NavigableSet<Student> tailSet = treeSet.tailSet(sss,true);

        List<Student> result = new ArrayList<>(3);

        for (int i = 0; i <3;i++){
            if (!tailSet.isEmpty()){
                result.add(tailSet.pollLast());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SetAndMapTree setAndMapTree = new SetAndMapTree();

        setAndMapTree.addStudent("Jon", 4.3f);
        setAndMapTree.addStudent("Pit", 6.7f);
        setAndMapTree.addStudent("Sam", 7.2f);
        setAndMapTree.addStudent("Don", 5.0f);
        setAndMapTree.addStudent("Yen", 8.8f);
        setAndMapTree.addStudent("Li", 9.1f);


        System.out.println(setAndMapTree.treeMap);
        System.out.println(setAndMapTree.treeSet);
        System.out.println(setAndMapTree.top3(5.0f));
    }
}

class Student implements Comparable<Student>{
    String name;
    Float grade;

    public Student(String name, Float grade) {
        this.name = name;
        this.grade = grade;
    }

    public Student() {

    }

    @Override
    public String toString() {
        return "Student -" +
                "name -" + name +
                "- grade = " + grade ;
    }


    @Override
    public int compareTo(Student o) {
        return this.grade.compareTo(o.grade);
    }
}
