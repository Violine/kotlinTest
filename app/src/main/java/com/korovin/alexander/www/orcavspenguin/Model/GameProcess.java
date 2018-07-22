package com.korovin.alexander.www.orcavspenguin.Model;

public class GameProcess {
    private static int row;
    private static int column;
    private static int cellCounter;
    public static Cell[][] gameField;


    public GameProcess(int row, int column) {
        GameProcess.row = row;
        GameProcess.column = column;
        GameProcess.gameField = new Cell[row][column];
        initCell();
    }

    private void initCell() {
        int position = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (i == j) {
                    gameField[i][j] = new Cell(position, new Orca());
                    position++;
                } else {
                    gameField[i][j] = new Cell(position);
                    position++;
                }
            }
        }
        cellCounter = position;
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


}

