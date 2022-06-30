class PlayerSatu(name : String) : Player() {

    override fun playerHand(): String {
        return Hand.getResult("Pilih yang mana ${this.name} : ")
    }

    init {
        super.name = name
    }

}