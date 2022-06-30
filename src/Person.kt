abstract class Person {
    open lateinit var name : String
    open var score : Int = 0
    abstract fun playerHand() : String


    private var a = HandType.A.nama
    private var b = HandType.B.nama
    private var c = HandType.C.nama

    fun attack(opponent : Player){
        println("${this.name} VS ${opponent.name}")

        val playerOneHand = this.playerHand()
        val playerTwoHand = opponent.playerHand()

        if (playerOneHand==playerTwoHand){
            println("DRAW")
        } else if (
            playerOneHand == a && playerTwoHand == b
            || playerOneHand == b && playerTwoHand == c
            || playerOneHand == c && playerTwoHand == a
        ) {
            println("${this.name} WIN")
            this.score++
            println("""
                ${this.name} = ${this.score}
                ${opponent.name} = ${opponent.score}
            """.trimIndent())
        } else {
            println("${opponent.name} WIN")
            opponent.score++
            println("""
                ${this.name} = ${this.score}
                ${opponent.name} = ${opponent.score}
            """.trimIndent())
        }
    }
}