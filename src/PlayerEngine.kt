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

        val patternImage = mapOf(
            a to Utility.rockPatternString(),
            b to Utility.scissorPatternString(),
            c to Utility.paperPatternString()
        )

        fun pickPattern (option : String) : String {
            return patternImage[option]!!
        }

        fun getLiveResult(){
            println("\n>${Color.WARNA_PUTIH_BRIGHT}> PLAYER STATS ${Color.WARNA_RESET}\\")
            println("-----------------\\__________________________________________________________")
            print(String.format("| Nama   |  %-25s", this.name))
            print(String.format("||   %-25s", opponent.name))
            println("        |")
            print(String.format("|${Color.WARNA_HIJAU} Win    ${Color.WARNA_RESET}|${Color.WARNA_HIJAU}  %-25s", this.score))
            print(String.format("${Color.WARNA_RESET}||${Color.WARNA_HIJAU}   %-25s", opponent.score))
            println("${Color.WARNA_RESET}        |")
            print(String.format("|${Color.WARNA_MERAH} Health ${Color.WARNA_RESET}|${Color.WARNA_MERAH}  %-5s", this.health))
            print(String.format(" / 100.0            ${Color.WARNA_RESET}||${Color.WARNA_MERAH}   %-6s", opponent.health))
            print("/ 100.0                    ${Color.WARNA_RESET}|")
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

        fun maxMinHealth(){
            if (this.health >=100.0 ){
                this.health = 100.0
            }
            if (opponent.health >= 100.0){
                opponent.health = 100.0
            }
            if (this.health <=0.0 ){
                this.health = 0.0
            }
            if (opponent.health <= 0.0){
                opponent.health = 0.0
            }
        }

        if (playerOneHand==playerTwoHand){
            getHandResult()
            print("\n${Color.WARNA_HIJAU_BOLD}                    ||*****************      DRAW      ******************||${Color.WARNA_RESET}")
            this.health += healthRegen
            opponent.health += healthRegen
            maxMinHealth()
            getLiveResult()
        } else if (
            playerOneHand == a && playerTwoHand == b
            || playerOneHand == b && playerTwoHand == c
            || playerOneHand == c && playerTwoHand == a
        ) {
            getHandResult()
            print("\n${Color.WARNA_HIJAU_BOLD}                      ||****************** ${this.name} WIN ******************||${Color.WARNA_RESET}")
            this.score++
            this.health += healthRegen
            opponent.health -= healthLose
            maxMinHealth()
            getLiveResult()
        } else {
            getHandResult()
            print("\n${Color.WARNA_HIJAU_BOLD}                     ||****************** ${opponent.name} WIN ******************||${Color.WARNA_RESET}")
            opponent.health += healthRegen
            this.health -= healthLose
            opponent.score++
            maxMinHealth()
            getLiveResult()
        }

        if (this.health <=0.0 || opponent.health <=0.0){
            Utility.getHeaderGame()
            Utility.getGameOver()
            if (this.health<=0){
                print("""${Color.WARNA_HIJAU_BOLD}
                         ${opponent.name}
                          WIN THIS MATCH
                ${Color.WARNA_RESET}""".trimMargin())
                getLiveResult()
            } else {
                print("""${Color.WARNA_HIJAU_BOLD}
                         ${this.name}
                          WIN THIS MATCH
                ${Color.WARNA_RESET}""".trimMargin())
                getLiveResult()
            }

            this.health = 100.00
            opponent.health = 100.00
            this.score = 0
            opponent.score = 0
        }
    }
}