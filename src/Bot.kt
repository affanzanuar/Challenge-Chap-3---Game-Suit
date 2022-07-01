class Bot(name : String) : Person() {

    override var name: String
        get() = super.name.uppercase().trim()
        set(value) {
            super.name = value
        }
    override var score : Int = 0

    override fun playerHand(): String {
        return Hand.handName.random()
    }

    fun playerHand(name : String ) { // <- Overloading

    }

    init {
        super.name = name
        super.score = score
    }
}