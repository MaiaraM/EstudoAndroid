package br.com.galaxyware.students.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.com.galaxyware.students.model.Student;

public class DaoStudent {
    private final static ArrayList<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student("Maiara", "19 99234-2342", "maiaramartins093@gmail.com"));
        studentList.add(new Student("Lucas", "19 99234-2342", "lucas333@gmail.com"));
        studentList.add(new Student("Maria", "19 99234-2342", "231saa@gmail.com"));
        studentList.add(new Student("João", "19 99234-2342", "affe@gmail.com"));
    }

    

    public List<Student> todos() {
        return (List<Student>) studentList.clone();
    }

    public void insere(Student aStudent) {
        DaoStudent.studentList.addAll(Arrays.asList(aStudent));
    }

    public void altera(int posicao, Student aStudent) {
        studentList.set(posicao, aStudent);
    }

    public void remove(int posicao) {
        studentList.remove(posicao);
    }

    public void troca(int posicaoInicio, int posicaoFim) {
        Collections.swap(studentList, posicaoInicio, posicaoFim);
    }

    public void removeTodos() {
        studentList.clear();
    }
}
