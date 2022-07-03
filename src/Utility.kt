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
        println("-Whitespace doesnt matter-")
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
        val yesWord = setOf(
            "ya" , "iyaa" , "okey" , "iyaaa" , "iya" , "yes" , "oke" , "baik" , "okay" , "okai",
            "setuju", "yip" , "yeah" , "ok" , "baiklah" , "baik" , "betul" , "ia" , "mau" , "okei" ,
            "okee" , "yoi" , "yoyoi" , "benar" , "maudong" , "okedeh" , "okeideh" , "maudeh" , "y",
            "berkenan" , "ys" , "yeap" , "okemau" , "yamau" , "iyamau" , "want" , "ye" , "agree",
            "iyadeh" , "yadeh" , "key" , "aye" , "ay" , "okeee" , "okke" , "yuk" , "yok" , "lanjut" ,
            "okkay" , "boleh" , "bolehyok" , "gas" , "gasss" , "gaskeun" , "cocok" , "bolehdeh" , "gasyok" ,
            "yokdah" , "gasdah" , "ayok" , "ayuk" , "ayokdah" , "ayukdah" , "yaudahlanjut" , "yaudahayok" ,
            "ayo" , "ayodah" , "hayuk" , "hayok" , "sini", "main" , "maen" , "lagi" , "lagidong" , "o.k" ,
            "o.k."
        )

        val noWord = setOf(
            "enggak" , "ngga" , "nggamau" , "enggamau" , "tidak" , "tidakmau" , "nggaduludeh",
            "nggadulu" , "g" , "gak" , "ga" , "no" , "n" , "enggaak" , "enggakah" , "nggaah" , "nggakah",
            "nanti" , "nantidulu" , "nantiduluaja" , "kagak" , "gk" , "tdk" , "tdak" , "nggak" , "nggakmau" ,
            "disagree" , "nantideh" , "gakmau" , "gmau" , "gkmau" , "gamau" , "nonono" , "endak" , "ndak" ,
            "ndakmau" , "endakmau"
        )
        print("$message : ")
        var inputUser = readLine()?.lowercase()?.trim()?.replace(" ","")
        while (inputUser !in yesWord && inputUser !in noWord){
            println("SABRINA ngga ngerti, coba keyword lain ya :) ")
            print("$message : ")
            inputUser = readLine()?.lowercase()?.trim()?.replace(" ","")
        }
        return inputUser in yesWord
    }
}