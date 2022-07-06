object Utility {

    val answer1 = setOf("1" , "satu" , "one" , "twoplayer")
    val answer2 = setOf("2" , "dua" , "two" , "vsbot" , "vssabrina" , "singleplayer")
    val answer3 = setOf("3" , "tiga" , "three" , "quit" , "exit" , "q" , "quit" , "keluar")

    var handName = arrayOf(
        HandType.A.nama,
        HandType.B.nama,
        HandType.C.nama
    )

    private var handInMenu = listOf(
        "          ${Color.WARNA_BIRU_BOLD}                   ROCK   =>   batu",
        "          ${Color.WARNA_KUNING_BOLD}                  PAPER   =>   kertas",
        "          ${Color.WARNA_HIJAU_BOLD}                SCISSOR   =>   gunting${Color.WARNA_RESET}")

    fun getResult (message : String) : String {
        print(message)
        var userKeyword = readLine()?.lowercase()?.trim()?.replace(" ","")
            ?.replace("\t","")?.replace("rock","batu")
            ?.replace("scissor", "gunting")?.replace("paper","kertas")

        while (userKeyword !in handName){
            print("Hanya boleh pilih salah satu di atas : ")
            userKeyword = readLine()?.lowercase()?.trim()?.replace(" ","")
                ?.replace("\t","")?.replace("rock","batu")
                ?.replace("scissor", "gunting")?.replace("paper","kertas")
        }
        return userKeyword!!
    }

    fun getHeaderGame(){
        clearScreen()
        println("""
            ===========================================================================
            |                       GAME SUIT TERMINAL VERSION                        |
            ===========================================================================
        """.trimIndent())
    }

    fun getMainMenu(){
        println("""
            |                                                                         |
            |${Color.WARNA_CYAN_BOLD}                        1  TWO PLAYER ${Color.WARNA_RESET}                                   |
            |${Color.WARNA_UNGU_BOLD}                             2  VS SABRINA ${Color.WARNA_RESET}                              |
            |${Color.WARNA_MERAH_BOLD}                                 3  EXIT / KELUAR ${Color.WARNA_RESET}                       |
            |                                                                         |
            +-------------------------------------------------------------------------+
        """.trimIndent())
    }

    fun getHandMenu(){
        getHeaderGame()
        for ( value in handInMenu){
            println("$value  ")
        }

        println("\n---------------------     UPPERCASE Or lowercase     ----------------------")
        println("---------------------       English Or Bahasa        ----------------------")
        println("---------------------   Whitespace doesn't matter    ----------------------")
    }

    fun getGameOver(){
        println("""${Color.WARNA_MERAH}                
  @@@@@@    @@@    @@     @@  @@@@@@@     @@@@@   @@   @@  @@@@@@@  @@@@@@
 @@        @@ @@   @@@   @@@  @@         @@   @@  @@   @@  @@       @@   @@
@@        @@   @@  @@@@ @@@@  @@         @@   @@  @@   @@  @@       @@   @@
@@   @@@  @@   @@  @@  @  @@  @@@@@      @@   @@  @@   @@  @@@@@    @@  @@@
@@    @@  @@@@@@@  @@     @@  @@         @@   @@  @@   @@  @@       @@@@@
 @@   @@  @@   @@  @@     @@  @@         @@   @@   @@ @@   @@       @@ @@@
  @@@@@@  @@   @@  @@     @@  @@@@@@@     @@@@@     @@@    @@@@@@@  @@  @@@${Color.WARNA_RESET}""".trimIndent())
    }

    fun getSayGoodBye(){
        getHeaderGame()
        val x = 8
        println()
        for ( baris in 1..2*x ){
            val totalSpace = if ( baris < x ) x - baris else baris - x
            val totalKolom = if ( baris < x ) baris else (2*x) - baris
            for (space in 1 .. totalSpace) {
                print("     ")
            }
            for (kolom in 1 .. totalKolom) {
                print("${Color.WARNA_KUNING_BOLD}*         ${Color.WARNA_RESET}")
            }
            println()
        }
        println("""
            =========================== SEE YOU NEXT TIME! ============================
            ========================== SABRINA UNDUR DIRI:) ===========================
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
            "o.k." , "okeey", "bole" , "yas" , "bleh" , "gasken" , "kuy" , "skuy" , "maulah" , "mainsini" , "hai" ,
            "cus" , "blh" , "maudah" , "gass" , "yo" , "yap" , "iyah" , "yah" , "okelah" , "oklah" , "gasyuk",
            "yaa" , "yaaa" , "bolh" , "enya" , "woke" , "wokey" , "wokei" , "yuah" , "mmau" , "mauu" , "maau" ,
            "bolehlah" , "bolehdong", "\n"
        )

        val noWord = setOf(
            "enggak" , "ngga" , "nggamau" , "enggamau" , "tidak" , "tidakmau" , "nggaduludeh",
            "nggadulu" , "g" , "gak" , "ga" , "no" , "n" , "enggaak" , "enggakah" , "nggaah" , "nggakah",
            "nanti" , "nantidulu" , "nantiduluaja" , "kagak" , "gk" , "tdk" , "tdak" , "nggak" , "nggakmau" ,
            "disagree" , "nantideh" , "gakmau" , "gmau" , "gkmau" , "gamau" , "nonono" , "endak" , "ndak" ,
            "ndakmau" , "endakmau" , "na" , "nolah" , "nantiaja" , "nei" , "nda" , "emoh" , "moh" , "ngggak",
            "ngak" , "nga" , "nggga" , "noway", "keluaraja" , "quitaja" , "keluar" , "quit" , "males" , "nda" ,
            "menuaja" , "kemenuaja" , "maubobok" , "maubobo" , "mautidur" , "maumakan" , "maumakandulu" , "maubobodulu",
            "ngk" , "nggk" , "nggakdulu" , "ndakdulu" , "ndadulu" , "dadah" , "bye" ,  "byebye", "noo", "nooo" , "ge",
            "ghe" , "henteu" , "ora" , "gah" , "q" , "exit" , "engga" , "mohah" , "ogah" , "oga" , "ogahah" ,
            "malesbgt", "malesbanget"
        )

        print("$message : ")
        var inputUser = readLine()?.lowercase()?.trim()?.replace(" ","")
            ?.replace("\t","")?.replace("-","")
        while (inputUser !in yesWord && inputUser !in noWord){
            println("\nHah, ngga ngerti SABRINA. awokwok ")
            print("Maksudnyaaaa, $message : ")
            inputUser = readLine()?.lowercase()?.trim()?.replace(" ","")
                ?.replace("\t","")?.replace("-","")
        }
        return inputUser in yesWord
    }

    private fun clearScreen(){
        val y = 16
        for (baris in 0..y){
            println()
        }
    }

    fun rockPatternString(): String {
        return """${Color.WARNA_BIRU_BOLD}                                 *  *  *     
                              *  *  *  *  *  
                              *  *  *  *  *  
                              *  *  *  *  *  
                                 *  *  *   ${Color.WARNA_RESET}
        """.trimMargin()
    }

    fun paperPatternString(): String {
        return """${Color.WARNA_BIRU_BOLD}                               *  *  *  *  *
                              *  *  *  *  *
                             *  *  *  *  *
                            *  *  *  *  *
                           *  *  *  *  *${Color.WARNA_RESET}
        """.trimMargin()
    }

    fun scissorPatternString(): String {
        return """${Color.WARNA_BIRU_BOLD}                              *           *
                                 *     * 
                                    *
                              *  *     *  *
                              *           *${Color.WARNA_RESET}
        """.trimMargin()
    }
}