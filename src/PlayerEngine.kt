abstract class PlayerEngine {
    open lateinit var name : String
    open var score : Int = 0
    open var health : Double = 100.00
    abstract fun playerHand() : String

    private var a = HandType.A.nama
    private var b = HandType.B.nama
    private var c = HandType.C.nama

    private var healthRegen = arrayOf(6.5 , 7.5 , 8.5 , 9.5).random()
    private var healthLose = arrayOf(31.5 , 35.5 , 37.5 ).random()

    fun attack(opponent : PlayerEngine){
        println("\n                       Saatnya ${this.name} melawan ${opponent.name}\n")

//        var rockPattern = Utility.rockPatternString
//        var paperPattern = Utility.paperPatter()
//        var scissorPattern = Utility.scissorPattern()

        val patternImage = mapOf(
            a to Utility.rockPatternString(),
            b to Utility.scissorPatternString(),
            c to Utility.paperPatternString()
        )

        fun pickPattern (option : String) : String {
            return patternImage[option]!!
        }

        fun getLiveResult(){
            println("\n>> PLAYER STATS \\")
            println("-----------------\\__________________________________________________________")
            print(String.format("| Nama   |  %-25s", this.name))
            print(String.format("||   %-25s", opponent.name))
            println("        |")
            print(String.format("| Win    |  %-25s", this.score))
            print(String.format("||   %-25s", opponent.score))
            println("        |")
            print(String.format("| Health |  %-5s", this.health))
            print(String.format(" / 100.0            ||   %-6s", opponent.health))
            print("/ 100.0                    |")
            println()
            println("============================================================================")
        }
        getLiveResult()

        val playerOneHand = this.playerHand()
        val playerTwoHand = opponent.playerHand()

        fun getHandResult(){
            Utility.getHeaderGame()
            println()

            println(pickPattern(playerOneHand))
            println("                                   V.S")
            println(pickPattern(playerTwoHand))

            print(String.format("             %-25s", "-> ${this.name} = ${playerOneHand.uppercase()}"))
            print(String.format("     %-25s", "-> ${opponent.name} = ${playerTwoHand.uppercase()}\n"))
        }

        fun maxHealth(){
            if (this.health >=100.0 ){
                this.health = 100.0
            }
            if (opponent.health >= 100.0){
                opponent.health = 100.0
            }
        }

        if (playerOneHand==playerTwoHand){
            getHandResult()
            print("\n                    ||*****************      DRAW      ******************||")
            this.health += healthRegen
            opponent.health += healthRegen
            maxHealth()
            getLiveResult()
        } else if (
            playerOneHand == a && playerTwoHand == b
            || playerOneHand == b && playerTwoHand == c
            || playerOneHand == c && playerTwoHand == a
        ) {
            getHandResult()
            print("\n                      ||****************** ${this.name} WIN ******************||")
            this.score++
            this.health += healthRegen
            opponent.health -= healthLose
            maxHealth()
            getLiveResult()
        } else {
            getHandResult()
            print("\n                     ||****************** ${opponent.name} WIN ******************||")
            opponent.health += healthRegen
            this.health -= healthLose
            opponent.score++
            maxHealth()
            getLiveResult()
        }

        if (this.health <=0.0 || opponent.health <=0.0){
            Utility.getHeaderGame()
            Utility.getGameOver()
            if (this.health<=0){
                this.health=0.0
                println("""
                         ${opponent.name}
                          WIN THIS MATCH
                """.trimMargin())
                getLiveResult()
            } else {
                opponent.health=0.0
                println("""
                         ${this.name}
                          WIN THIS MATCH
                """.trimIndent())
                getLiveResult()
            }

            this.health = 100.00
            opponent.health = 100.00
            this.score = 0
            opponent.score = 0
        }
    }
}