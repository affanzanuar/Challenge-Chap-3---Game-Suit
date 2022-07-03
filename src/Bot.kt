class Bot(name : String) : Person() {

    override var name: String
        get() = super.name.uppercase().trim()
        set(value) {
            super.name = value
        }
    override var score : Int = 0

    @Override
    override fun playerHand(): String {
        return playerHand(Hand.handName)
    }

    //Overloading
    private fun playerHand(hand: Array<String>): String {
        return hand.random()
    }

    init {
        super.name = name
        super.score = score
    }
}