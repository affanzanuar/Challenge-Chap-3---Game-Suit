abstract class Person {
    open lateinit var name : String
    private var a = HandType.A.nama
    private var b = HandType.B.nama
    private var c = HandType.C.nama

    abstract fun playerHand() : String

    open fun attack(opponent : Person){
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
        } else {
            println("${opponent.name} WIN")
        }
    }
}