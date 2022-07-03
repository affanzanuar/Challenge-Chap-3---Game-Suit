abstract class Person {
    open lateinit var name : String
    open var score : Int = 0
    abstract fun playerHand() : String

    private var a = HandType.A.nama
    private var b = HandType.B.nama
    private var c = HandType.C.nama

    fun attack(opponent : Person){
        println("\nSaatnya ${this.name} melawan ${opponent.name}")

        val playerOneHand = this.playerHand()
        val playerTwoHand = opponent.playerHand()

        fun printHandResult(){
            Utility.getHeaderGame()
            println("""
                -> ${this.name} = ${playerOneHand.uppercase()} 
                -> ${opponent.name} = ${playerTwoHand.uppercase()}
            """.trimIndent())
        }

        fun printLiveScore(){
            println("""
                --------- SCORE ----------
                ${this.name} = ${this.score} || ${opponent.name} = ${opponent.score}
                ==========================
            """.trimIndent())
        }

        if (playerOneHand==playerTwoHand){
            printHandResult()
            println("\n||******** DRAW ********||\n")
            printLiveScore()
        } else if (
            playerOneHand == a && playerTwoHand == b
            || playerOneHand == b && playerTwoHand == c
            || playerOneHand == c && playerTwoHand == a
        ) {
            printHandResult()
            println("\n||****** ${this.name} WIN ******||\n")
            this.score++
            printLiveScore()
        } else {
            printHandResult()
            println("\n||****** ${opponent.name} WIN ******||\n")
            opponent.score++
            printLiveScore()
        }
    }
}