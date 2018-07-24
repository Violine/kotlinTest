package com.korovin.alexander.www.orcavspenguin.Model

import java.util.*

class Penguin(position: Int) : Animal(position), IAnimalLifeStep {
    override fun animalLifeStep() {
        val coordinateToMove: ArrayList<Coordinate> = this.positionToMove
        val emptyCell = ArrayList<Int>()
        val pinguinCell = ArrayList<Int>()
        val orcaCell = ArrayList<Int>()

        for (coordinate in coordinateToMove) {
            val pos: Int = coordinate.rowCoordinate * GameProcess.column + coordinate.columnCoordinate
            when {
                GameProcess.allCellList[pos].isEmpty -> emptyCell.add(pos)
                GameProcess.allCellList[pos].animal is Penguin -> {
                    pinguinCell.add(pos)
                }
                else -> {
                    orcaCell.add(pos)
                }
            }
        }

        if (this.lifeStep == Animal.PINGUIN_PROLIFERATION)
            proliferationAnimal(emptyCell) // передаем список возможных позиций для размножения
        else if (emptyCell.size > 0) {

            val random = Random(System.currentTimeMillis())
            val randomIndex = random.nextInt(emptyCell.size)

            val positionForMove = emptyCell[randomIndex] //

            GameProcess.allCellList[positionForMove].animal = GameProcess.allCellList[this.position].animal
            GameProcess.allCellList[positionForMove].setIsEmpty(false)
            GameProcess.allCellList[positionForMove].animal.animalCoordinate = Coordinate(GameProcess.allCellList[positionForMove].rowCoordinats, GameProcess.allCellList[positionForMove].columnCoordinats)
            GameProcess.allCellList[position].setIsEmpty(true)
            GameProcess.allCellList[position].animal = null
            GameProcess.allCellList[positionForMove].animal.position = emptyCell[randomIndex]
        }
        this.lifeStep++
    }
}