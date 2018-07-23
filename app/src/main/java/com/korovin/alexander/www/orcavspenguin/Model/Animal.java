package com.korovin.alexander.www.orcavspenguin.Model;

import java.util.ArrayList;

public abstract class Animal {
    public static final int ORCA_MAX_LIFECYCLE = 3;
    public static final int PINGUIN_PROLIFERATION = 3;
    public static final int ORCA_PROLIFERATION = 8;
    private int lifeStep;
    private int position;

    private Coordinate animalCoordinate;

    Animal(int position) {
        this.position = position;
    }


    public int getLifeStep() {
        return lifeStep;
    }

    public void setLifeStep(int lifeStep) {
        this.lifeStep = lifeStep;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void proliferationAnimal() {
// логика размножения
    }

    public ArrayList<Integer> getPositionToMove() { // определяем куда можно ходить
        ArrayList<Integer> positions = new ArrayList<>();
        ArrayList<Integer> allPositions = new ArrayList<>(); // заносим все возможные позиции
        //
        return positions;
    }

    public void setAnimalCoordinate(Coordinate animalCoordinate) {
        this.animalCoordinate = animalCoordinate;
    }

    public Coordinate getAnimalCoordinate() {
        return animalCoordinate;
    }
}
