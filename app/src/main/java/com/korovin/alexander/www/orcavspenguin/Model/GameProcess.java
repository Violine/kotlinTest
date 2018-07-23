package com.korovin.alexander.www.orcavspenguin.Model;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class GameProcess {
    private static int row;
    private static int column;
    private static int cellCounter;

    private static Cell[][] gameField;

    private static ArrayList<Cell> allCellList;
    private static ArrayList<Orca> allOrcaList;
    private static ArrayList<Penguin> allPengiunList;

    private int animalCellPercent = 55; // процент клеток, заполненными животными


    public GameProcess(int row, int column) {
        GameProcess.row = row;
        GameProcess.column = column;
        GameProcess.gameField = new Cell[row][column];
        initCell();
        setAnimalToCell(cellCounter);
    }

    private void initCell() {
        allCellList = new ArrayList<>();
        int position = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                Cell cell = new Cell(position, i, j);
                gameField[i][j] = cell;
                allCellList.add(cell);
                position++;
            }
        }
        cellCounter = position;
    }

    private Set<Integer> getRandomCell(int celQuantity) {
        int animalQuantity = (int) Math.floor(animalCellPercent * celQuantity / 100);
        Set<Integer> animalCells = new HashSet<>(); // Хэшсет используется для того чтобы в массиве не оказалось ячеек с одинаковой позицией
        Random random = new Random(System.currentTimeMillis());
        while (animalCells.size() < animalQuantity) {
            animalCells.add(random.nextInt(celQuantity));
        }
        return animalCells;
    }

    public static Cell getCellToPosition(int position) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (gameField[i][j].getPosition() == position) return gameField[i][j];
            }
        }
        return null;
    }

    public static int getCellCounter() {
        return cellCounter;
    }

    private void setAnimalToCell(int cellCounter) {
        Set<Integer> animalCell = getRandomCell(cellCounter); // позиции для животных
        Set<Integer> allCell = new HashSet<>();               // все позиции
        for (int i = 0; i < cellCounter; i++) {
            allCell.add(i);
        }
        allCell.removeAll(animalCell);                        // оставляем в списке только те, где не может быть животного
        for (int emptyCellPosition : allCell) {
            allCellList.get(emptyCellPosition).setAnimal(null);
            allCellList.get(emptyCellPosition).setEmpty(true);
        }
        allOrcaList = new ArrayList<>();
        allPengiunList = new ArrayList<>();
        Integer[] animalArray = animalCell.toArray(new Integer[animalCell.size()]);
        shuffleArray(animalArray);                                                  // перемешиваем массив
        for (int i = 0; i < animalArray.length; i++) {
            if (i % 5 == 0) {
                Orca orca = new Orca(animalArray[i]);
                allOrcaList.add(orca);
                allCellList.get(animalArray[i]).setAnimal(orca);
                allCellList.get(animalArray[i]).setEmpty(false);
            } else {
                Penguin penguin = new Penguin(animalArray[i]);
                allPengiunList.add(penguin);
                allCellList.get(animalArray[i]).setAnimal(penguin);
                allCellList.get(animalArray[i]).setEmpty(false);
            }
        }
        System.out.println(1);
    }

    static void shuffleArray(Integer[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public static void lifeCycle() {
        for (Cell cell : allCellList) {
            if (cell.getAnimal() == null) continue;
            Coordinate coordinate = new Coordinate(cell.getRowCoordinats(), cell.getColumnCoordinats());
            cell.getAnimal().setAnimalCoordinate(coordinate);

        }

    }

}

