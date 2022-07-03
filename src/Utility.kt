object Utility {
    fun getHeaderGame(){
        val y = 25
        for (baris in 0..y){
            println()
        }
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

    fun getHandMenu(){
        getHeaderGame()
        for ( value in Hand.handNameEng){
            println("$value  ")
        }
        println("--UPPERCASE Or lowercase--")
        println("----English Or Bahasa-----")
        println("---Space doesn't matter---")
    }

    fun getSayGoodBye(){
        val y = 25
        for (baris in 0..y){
            println()
        }
        val x = 5
        println()
        for ( baris in 1..2*x ){
            val totalSpace = if ( baris < x ) x - baris else baris - x
            val totalKolom = if ( baris < x ) baris else (2*x) - baris
            for (space in 1 .. totalSpace) {
                print("   ")
            }
            for (kolom in 1 .. totalKolom) {
                print("*     ")
            }
            println()
        }
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