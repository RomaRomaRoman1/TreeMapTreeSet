package org.example;
import java.util.*;
class Student {
    String name;
    float score;
    public Student(String name, float score) {
        this.name = name;
        this.score = score;
    }
    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
class ResultsBoard {
    TreeSet<Student> studentTreeSet = new TreeSet<>((s1, s2)->Float.compare(s1.score, s2.score));//определение компаратора в лямбда выражении
    TreeMap<Float, String> threeStudentTheBestTreeMap = new TreeMap<>();//карта для вывода трех лучших студентов (нужны ключи для сортировки по баллам)
    void showAllSortedForScoreStudent() {
        studentTreeSet.forEach(student -> System.out.println(student));
    }
    void addStudent(String name, Float score){
    Student student = new Student(name, score);
    studentTreeSet.add(student);
    threeStudentTheBestTreeMap.put(student.score, "[|" +student.name +"|]" + " and your score: " + "(" +student.score +")");//кладем оценку в качестве ключа в TreeMap
    }
    List<String> top3 () {
        List<String> threeBestStudentList = new ArrayList<>(3);//ArrayList фиксированной величины 3
        for(int i=0; i<3;i++){//итерируемся три раза
            if (!threeStudentTheBestTreeMap.isEmpty()){//если карта не пустая
                threeBestStudentList.add(threeStudentTheBestTreeMap.pollLastEntry().getValue());//то кладем значение последнего элемента, удаляя его из карты
            }
        }
        return threeBestStudentList;//возвращаем список с 3-мя студентами лучшими в порядке убывания
    }
    public static void main( String[] args )
    {
        ResultsBoard resultsBoard = new ResultsBoard();
        resultsBoard.addStudent("Harry", 2.1f);
        resultsBoard.addStudent("Potter", 2.2f);
        resultsBoard.addStudent("Terminator", 7.1f);
        resultsBoard.addStudent("Dead Pool", 6.1f);
        resultsBoard.addStudent("Piter Parker", 5.1f);
        resultsBoard.addStudent("David", 4.1f);
        resultsBoard.addStudent("Alexander", 3.1f);
        resultsBoard.showAllSortedForScoreStudent();//показать отсортированный список студентов
        System.out.println(resultsBoard.top3());//вывод трех лучших студентов
    }
}



