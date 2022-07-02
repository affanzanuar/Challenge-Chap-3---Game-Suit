object Utility {
    fun getHeaderGame(){
        println("""
            ==========================
            GAME SUIT TERMINAL VERSION
            ==========================
        """.trimIndent())
    }

    fun getMainMenu(){
        println("""
            |      1 TWO PLAYER      |
            |      2 VS SABRINA      |
            |         3 EXIT         |
            +------------------------+
        """.trimIndent())
    }

    fun getSayGoodBye(){
        println("""
            === SEE YOU NEXT TIME! ===
            == SABRINA UNDUR DIRI:) ==
        """.trimIndent())
    }

    fun getYesOrNo(message : String) : Boolean{
        print("$message (y/n) : ")
        var inputUser = readLine()?.lowercase()?.trim()
        while (inputUser != "y" && inputUser != "n"){
            println("pilih y atau n saja, jangan yg lain :) ")
            print("$message (y/n) : ")
            inputUser = readLine()?.lowercase()?.trim()
        }
        return inputUser == "y"
    }
}