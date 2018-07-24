package com.korovin.alexander.www.orcavspenguin.Model

class Orca(position: Int) : Animal(position), IAnimalLifeStep {
    override fun animalLifeStep() {
        this.calculateAnimalAround()
        val emptyCell = this.emptyCell
        val penguinCell = this.pinguinCell

        if (this.lifeStep == Animal.ORCA_MAX_LIFECYCLE - 1) {
            GameProcess.allCellList[this.position].animal = null
            GameProcess.allCellList[this.position].isEmpty = true

        } else if (emptyCell.size != 0 && penguinCell.size != 0) {
            when {
                this.lifeStep == Animal.ORCA_PROLIFERATION - 1 -> {
                    if (emptyCell.size > 0)
                        proliferationAnimal(getRandomPosition(emptyCell), Orca(getRandomPosition(emptyCell)))
                    this.lifeStep = 0
                }
                getRandomPosition(penguinCell) > 0 -> {
                    moveToPosition(getRandomPosition(penguinCell))
                    this.lifeStep++
                }
                emptyCell.size > 0 -> {
                    moveToPosition(getRandomPosition(emptyCell))
                    this.lifeStep++
                }
            }
        }
    }

    private fun moveToPosition(positionForMove: Int) {
        GameProcess.allCellList[positionForMove].animal = GameProcess.allCellList[this.position].animal
        GameProcess.allCellList[positionForMove].setIsEmpty(false)
        GameProcess.allCellList[positionForMove].animal.animalCoordinate = Coordinate(GameProcess.allCellList[positionForMove].rowCoordinats, GameProcess.allCellList[positionForMove].columnCoordinats)
        GameProcess.allCellList[position].setIsEmpty(true)
        GameProcess.allCellList[position].animal = null
        GameProcess.allCellList[positionForMove].animal.position = positionForMove
    }

}