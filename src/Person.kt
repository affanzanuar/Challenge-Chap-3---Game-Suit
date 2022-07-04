abstract class Person {
    open lateinit var name : String
    open var score : Int = 0
    open var health : Double = 100.00
    abstract fun playerHand() : String

    private var a = HandType.A.nama
    private var b = HandType.B.nama
    private var c = HandType.C.nama

    private var healthDraw = arrayOf(1.5 , 2.5 , 3.5 , 4.5)
    private var randomHealthPlayer1 = healthDraw.random()
    private var randomHealthOpponent = healthDraw.random()

    private var healthWinOrLose = arrayOf(31.5 , 35.5 , 37.5 )
    private var randomHealthWinOrLose = healthWinOrLose.random()

    fun attack(opponent : Person){
        println("\nSaatnya ${this.name} melawan ${opponent.name}\n")

        fun printLiveResult(){
            println("""
                ------ PLAYER STATS ------
                Name   : ${this.name}   || ${opponent.name}
                Win    : ${this.score}       || ${opponent.score}
                Health : ${this.health}   || ${opponent.health}
                ==========================
            """.trimIndent())
        }
        printLiveResult()

        val playerOneHand = this.playerHand()
        val playerTwoHand = opponent.playerHand()

        fun printHandResult(){
            Utility.getHeaderGame()
            println("""
                -> ${this.name} = ${playerOneHand.uppercase()} 
                -> ${opponent.name} = ${playerTwoHand.uppercase()}
            """.trimIndent())
        }

        if (playerOneHand==playerTwoHand){
            printHandResult()
            println("\n||******** DRAW ********||\n")
            this.health += randomHealthPlayer1
            opponent.health += randomHealthOpponent
            printLiveResult()
        } else if (
            playerOneHand == a && playerTwoHand == b
            || playerOneHand == b && playerTwoHand == c
            || playerOneHand == c && playerTwoHand == a
        ) {
            printHandResult()
            println("\n||****** ${this.name} WIN ******||\n")
            this.score++
            this.health += randomHealthPlayer1
            opponent.health -= randomHealthWinOrLose
            printLiveResult()
        } else {
            printHandResult()
            println("\n||****** ${opponent.name} WIN ******||\n")
            opponent.health += randomHealthOpponent
            this.health -= randomHealthWinOrLose
            opponent.score++
            printLiveResult()
        }

        if (this.health <=0 || opponent.health <=0){
            Utility.getHeaderGame()
            println("""
                
                    ******************
                |####### GAME OVER #######|
                    ******************
                      
            """.trimIndent())

            if (this.health<=0){
                println("""
                         ${opponent.name}
                          WIN THIS MATCH
                    ~~~~~~~~~~~~~~~~~~~~~~~~~
                    
                """.trimIndent())
            } else {
                println("""
                         ${this.name}
                          WIN THIS MATCH
                    ~~~~~~~~~~~~~~~~~~~~~~~~~~
                    
                """.trimIndent())
            }

            this.health = 100.00
            opponent.health = 100.00
            this.score = 0
            opponent.score = 0
        }
    }
}