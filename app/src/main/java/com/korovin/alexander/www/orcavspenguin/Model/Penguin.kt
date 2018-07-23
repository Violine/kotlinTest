package com.korovin.alexander.www.orcavspenguin.Model

class Penguin(position: Int) : Animal(position), IAnimalMove {
    override fun animalMove() {
        getPositionToMove()
        if (this.lifeStep == Animal.PINGUIN_PROLIFERATION)
            proliferationAnimal() // если время подошло - размножаемся
        this.lifeStep++
    }


}