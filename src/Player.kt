class Player(name : String) : Person() {

    override fun playerHand(): String {
        return Hand.getResult("Pilih yang mana ${this.name} : ")
    }

    init {
        super.name = name
    }
}