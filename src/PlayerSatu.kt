class PlayerSatu : Player() {
    override fun playerHand(): String {
        return Hand.getResult("Pilih yang mana : ")
    }

}