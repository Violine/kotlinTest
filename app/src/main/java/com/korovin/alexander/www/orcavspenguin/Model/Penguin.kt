package com.korovin.alexander.www.orcavspenguin.Model

class Penguin(position: Int) : Animal(position), IAnimalLifeStep {
    override fun animalLifeStep() {
        this.calculateAnimalAround()
        val emptyCell = this.emptyCell

        if (emptyCell.size > 0) {
            val positionForMove = getRandomPosition(emptyCell)
            if (this.lifeStep == Animal.PINGUIN_PROLIFERATION) {
                lifeStep = 0
                proliferationAnimal(positionForMove, Penguin(positionForMove))
            } else {
                GameProcess.allCellList[positionForMove].animal = GameProcess.allCellList[this.position].animal
                GameProcess.allCellList[positionForMove].setIsEmpty(false)
                GameProcess.allCellList[positionForMove].animal.animalCoordinate = Coordinate(GameProcess.allCellList[positionForMove].rowCoordinats, GameProcess.allCellList[positionForMove].columnCoordinats)
                GameProcess.allCellList[position].setIsEmpty(true)
                GameProcess.allCellList[position].animal = null
                GameProcess.allCellList[positionForMove].animal.position = positionForMove
            }
        }
        this.lifeStep++
    }
}