class Person(name : String) : PlayerEngine() {

    override var score : Int = 0
    override var health: Double = 100.00

    @Override
    override fun playerHand(): String {
        return Utility.getResult("Pilih yang mana ${this.name} : ")
    }

    init {
        super.name = name
        super.score = score
        super.health = health
    }
}