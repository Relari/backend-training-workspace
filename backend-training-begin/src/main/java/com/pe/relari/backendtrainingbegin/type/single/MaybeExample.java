package com.pe.relari.backendtrainingbegin.type.single;

import com.pe.relari.backendtrainingbegin.dao.repository.StudentRepository;
import com.pe.relari.backendtrainingbegin.model.domain.Student;
import io.reactivex.Maybe;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class MaybeExample {

    public static void main(String[] args) {

        var student = StudentRepository.student01();

        Maybe.just(student)
                .doOnSuccess(result -> log.info(result.toString()))
                .subscribe();

        var students = StudentRepository.students();
        Maybe.just(students)
                .doOnSuccess(result -> log.info(result.toString()))
                .subscribe();
        
    }
}
