abstract class Person {
    open lateinit var name : String
    open var score : Int = 0
    open var health : Double = 100.00
    abstract fun playerHand() : String

    private var a = HandType.A.nama
    private var b = HandType.B.nama
    private var c = HandType.C.nama

    private var healthRegen = arrayOf(6.5 , 7.5 , 8.5 , 9.5).random()
    private var healthLose = arrayOf(31.5 , 35.5 , 37.5 ).random()

    fun attack(opponent : Person){
        println("\n                Saatnya ${this.name} melawan ${opponent.name}\n")

        fun getLiveResult(){
            println(">> PLAYER STATS")
            println("__________________________________________________________________")
            System.out.printf("Nama   :  %-25s", this.name)
            System.out.printf("||   %-25s", opponent.name)
            println("|")
            System.out.printf("Win    :  %-25s", this.score)
            System.out.printf("||   %-25s", opponent.score)
            println("|")
            System.out.printf("Health :  %-8s", this.health)
            System.out.printf(" /    100.0      ||   %-9s", opponent.health)
            print("/    100.0      |")
            println("\n==================================================================")

            println()
        }
        getLiveResult()

        val playerOneHand = this.playerHand()
        val playerTwoHand = opponent.playerHand()

        fun getHandResult(){
            Utility.getHeaderGame()
            println("""
                
                -> ${this.name} = ${playerOneHand.uppercase()} 
                -> ${opponent.name} = ${playerTwoHand.uppercase()}
            """.trimIndent())
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
            println("\n||******************           DRAW           ******************||\n")
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
            println("\n      ||****************** ${this.name} WIN ******************||\n")
            this.score++
            this.health += healthRegen
            opponent.health -= healthLose
            maxHealth()
            getLiveResult()
        } else {
            getHandResult()
            println("\n      ||****************** ${opponent.name} WIN ******************||\n")
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
                    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                    
                """.trimIndent())
                getLiveResult()
            } else {
                opponent.health=0.0
                println("""
                         ${this.name}
                          WIN THIS MATCH
                    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                    
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