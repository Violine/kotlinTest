package com.korovin.alexander.www.orcavspenguin.Model;

public class Cell {

    private Animal animal;
    private int position;

    Cell(int position) {
        this.position = position;
    }
    Cell (int position, Animal animal){

    }

    public Animal getAnimal() {
        return this.animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    public int getPosition(){
        return position;
    }
}
