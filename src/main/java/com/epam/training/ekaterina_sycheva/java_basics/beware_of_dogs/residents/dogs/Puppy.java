package com.epam.training.ekaterina_sycheva.java_basics.beware_of_dogs.residents.dogs;

public class Puppy extends Dog {

    public Puppy(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Puppy " + name;
    }
}
