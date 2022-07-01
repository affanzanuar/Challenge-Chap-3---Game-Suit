class Bot(name : String) : Person() {

    override var score : Int = 0

    override fun playerHand(): String {
        return Hand.handName.random()
    }

    init {
        super.name = name
        super.score = score
    }
}