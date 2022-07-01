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
            1.  PLAY
            2.  EXIT
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