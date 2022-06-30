class PlayerDua : Player() {
    override fun playerHand(): String {
        return Hand.getResult("Pilih yang mana : ")
    }


}