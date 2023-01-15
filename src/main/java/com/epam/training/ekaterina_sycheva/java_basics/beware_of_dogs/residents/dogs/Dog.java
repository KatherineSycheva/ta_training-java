package com.epam.training.ekaterina_sycheva.java_basics.beware_of_dogs.residents.dogs;

public class Dog {

    protected String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog " + name;
    }
}
