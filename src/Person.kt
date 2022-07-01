abstract class Person {
    protected open lateinit var name : String
    open var score : Int = 0
    abstract fun playerHand() : String


    private var a = HandType.A.nama
    private var b = HandType.B.nama
    private var c = HandType.C.nama

    fun attack(opponent : Player){
        println("\nSaatnya ${this.name} melawan ${opponent.name}")

        val playerOneHand = this.playerHand()
        val playerTwoHand = opponent.playerHand()

        if (playerOneHand==playerTwoHand){
            Utility.getHeaderGame()
            println("""
                 
                ||******** DRAW ********||
                 
            """.trimIndent())
            println("""
                --------- SCORE ----------
                ${this.name} = ${this.score}   ||   ${opponent.name} = ${opponent.score}
                ==========================
            """.trimIndent())
        } else if (
            playerOneHand == a && playerTwoHand == b
            || playerOneHand == b && playerTwoHand == c
            || playerOneHand == c && playerTwoHand == a
        ) {
            Utility.getHeaderGame()
            println("""
                 
                ||****** ${this.name} WIN ******||
                 
            """.trimIndent())
            this.score++
            println("""
                --------- SCORE ----------
                ${this.name} = ${this.score}   ||   ${opponent.name} = ${opponent.score}
                ==========================
            """.trimIndent())
        } else {
            Utility.getHeaderGame()
            println("""
                 
                ||****** ${opponent.name} WIN ******||
                
                 
            """.trimIndent())
            opponent.score++
            println("""
                ${this.name} = ${this.score}    ||    ${opponent.name} = ${opponent.score}
                ==========================
            """.trimIndent())
        }
    }
}