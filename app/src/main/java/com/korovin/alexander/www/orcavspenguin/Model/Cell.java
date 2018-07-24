package com.korovin.alexander.www.orcavspenguin.Model;

public class Cell {

    private Animal animal;
    private int position;
    private int rowCoordinats;
    private int columnCoordinats;
    private boolean isEmpty;

    Cell(int position, int rowCoordinats, int columnCoordinats) {
        this.rowCoordinats = rowCoordinats;
        this.columnCoordinats = columnCoordinats;
        this.position = position;
    }

    public Animal getAnimal() {
        return this.animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public int getPosition() {
        return position;
    }

    public int getRowCoordinats() {
        return rowCoordinats;
    }

    public int getColumnCoordinats() {
        return columnCoordinats;
    }

    public boolean isEmpty() {
        return isEmpty;

    }

    public void setIsEmpty(boolean empty) {
        isEmpty = empty;
    }
}