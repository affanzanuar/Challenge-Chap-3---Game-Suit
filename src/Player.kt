class Player(name : String) : Person() {

    override var score : Int = 0

    @Override
    override fun playerHand(): String {
        return Hand.getResult("Pilih yang mana ${this.name} : ")
    }

    init {
        super.name = name
        super.score = score
    }
}