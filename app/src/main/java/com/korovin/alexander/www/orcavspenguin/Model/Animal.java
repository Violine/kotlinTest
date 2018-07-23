package com.korovin.alexander.www.orcavspenguin.Model;

import com.korovin.alexander.www.orcavspenguin.GameActivity;

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

    public ArrayList<Coordinate> getPositionToMove() { // определяем куда можно ходить
        ArrayList<Coordinate> positions = new ArrayList<>();
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
        for (int i = 0; i < dx.length; ++i) {
            int newRow = getAnimalCoordinate().getRowCoordinate() + dx[i];
            int newColumn = getAnimalCoordinate().getColumnCoordinate() + dy[i];

            // check the range
            if (newRow >= 0 && newRow < GameProcess.row && newColumn >= 0 && newColumn < GameProcess.column) {
                positions.add(new Coordinate(newRow, newColumn));
            }
        }

        return positions;
    }

    public void setAnimalCoordinate(Coordinate animalCoordinate) {
        this.animalCoordinate = animalCoordinate;
    }

    public Coordinate getAnimalCoordinate() {
        return animalCoordinate;
    }
}
