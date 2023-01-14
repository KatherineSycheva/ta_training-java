package com.epam.training.ekaterina_sycheva.java_basics.decrementing_carousel;

public class DecrementingCarousel {
    private int capacity;
    private int [] car;
    private int i = 0;
    private boolean endAdd = false;

    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
        car = new int[capacity];
    }

    /*
    boolean addElement(int element) – добавляет элемент.
    Если элемент отрицателен или равен нулю, не добавляет его.
    Если контейнер заполнен, не добавляет элемент.
    Если метод run был вызван для создания CarouselRun, не добавляет элемент.
    Если элемент добавлен успешно, возвращает true. В противном случае – false.*/
    public boolean addElement(int element){
        if (element > 0 && i < capacity && !endAdd) {
            car[i] = element;
            i++;
            return true;
        } else {
            return false;
        }
    }
    /*
    CarouselRun run() – возвращает CarouselRun для перебора элементов.
    Если метод run уже был вызван ранее, он должен вернуть null:
    DecrementingCarousel может генерировать только один объект CarouselRun.
    */
    public CarouselRun run(){
        if (endAdd) {
            return null;
        } else {
            endAdd = true;
            return new CarouselRun(car, i);
        }
    }

}
