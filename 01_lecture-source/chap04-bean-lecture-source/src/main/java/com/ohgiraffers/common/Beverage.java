package com.ohgiraffers.common;

public class Beverage extends Product {

    private int capacity;
    // abstract 추상클래스 사용이유_상속받았다!: 필드 생성하면 위에 있는 필드까지 쓸 수 있움! (따라서 부모것도 쓸 수 있다.)


    public Beverage(String name, int price, int capacity) {
        super(name, price);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.capacity;

    }

}

