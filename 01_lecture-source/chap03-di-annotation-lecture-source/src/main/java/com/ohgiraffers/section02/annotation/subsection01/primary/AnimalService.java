package com.ohgiraffers.section02.annotation.subsection01.primary;

import com.ohgiraffers.section02.common.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("animalPrimary")
public class AnimalService {

    private List<Animal> animalList;

    @Autowired
    public AnimalService(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public void animalEat() {
        for(Animal animal : animalList) {
            animal.eat();
        }
    }

}