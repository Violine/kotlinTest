package com.korovin.alexander.www.orcavspenguin.Model;

import java.util.ArrayList;
import java.util.Random;

public abstract class Animal implements IAnimalLifeStep {
    public static final int ORCA_MAX_LIFECYCLE = 3;
    public static final int PINGUIN_PROLIFERATION = 3;
    public static final int ORCA_PROLIFERATION = 8;
    private int lifeStep;
    private int position;
    private ArrayList<Integer> emptyCell;
    private ArrayList<Integer> pinguinCell;

    public ArrayList<Integer> getEmptyCell() {
        return emptyCell;
    }

    public void setEmptyCell(ArrayList<Integer> emptyCell) {
        this.emptyCell = emptyCell;
    }

    public ArrayList<Integer> getPinguinCell() {
        return pinguinCell;
    }

    public void setPinguinCell(ArrayList<Integer> pinguinCell) {
        this.pinguinCell = pinguinCell;
    }

    public ArrayList<Integer> getOrcaCell() {
        return orcaCell;
    }

    public void setOrcaCell(ArrayList<Integer> orcaCell) {
        this.orcaCell = orcaCell;
    }

    private ArrayList<Integer> orcaCell;

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

    public void proliferationAnimal(int positionForProliferation, Animal animal) {
        GameProcess.allCellList.get(positionForProliferation).setAnimal(animal);
        GameProcess.allCellList.get(positionForProliferation).setIsEmpty(false);
    }

    protected int getRandomPosition(ArrayList<Integer> emptyCell) {
        Random random = new Random(System.currentTimeMillis());
        int randomIndex = random.nextInt(emptyCell.size());
        return emptyCell.get(randomIndex);
    }

    public ArrayList<Coordinate> getPositionToMove() { // определяем куда можно ходить
        ArrayList<Coordinate> positions = new ArrayList<>();
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < dx.length; ++i) {
            int newRow = this.getAnimalCoordinate().getRowCoordinate() + dx[i];
            int newColumn = this.getAnimalCoordinate().getColumnCoordinate() + dy[i];
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
        return this.animalCoordinate;
    }

    protected void calculateAnimalAround() {

        ArrayList<Coordinate> coordinateToMove = getPositionToMove();
        this.emptyCell = new ArrayList<>();
        this.pinguinCell = new ArrayList<>();
        this.orcaCell = new ArrayList<>();

        for (Coordinate coordinate : coordinateToMove) {
            int pos = coordinate.getRowCoordinate() * GameProcess.column + coordinate.getColumnCoordinate();
            if (GameProcess.allCellList.get(pos).isEmpty()) {
                emptyCell.add(pos);
            } else if (GameProcess.allCellList.get(pos).getAnimal() instanceof Penguin) {
                pinguinCell.add(pos);
            } else {
                orcaCell.add(pos);
            }
        }
    }

}
