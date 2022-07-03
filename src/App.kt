class App {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {

            var isContinueMenu = true

            loopI@ while (isContinueMenu){
                Utility.getHeaderGame()
                Utility.getMainMenu()
                print("\nMasukkan pilihan anda : ")
                val userKeyword = readLine()?.trim()?.replace("satu","1")
                    ?.replace("one","1")?.replace("dua","2")
                    ?.replace("two","2")?.replace("tiga","3")
                    ?.replace("three","3")
                println()
                when(userKeyword){
                    "1" -> App().twoPlayer()
                    "2" -> App().vsBot()
                    "3" -> break@loopI
                    else -> println("Pilihan salah, pilihan menu hanya (1 - 3 / satu - tiga / one - three) :)")
                }
                isContinueMenu = Utility.getYesOrNo("Mau balik ke menu?")
            }
            Utility.getSayGoodBye()
        }
    }

    fun twoPlayer(){
        print("Masukkan nama Player 1 : ")
        var namaPlayerSatu = readLine()!!.uppercase().trim().replace(" ","")
        if (namaPlayerSatu.isBlank()){
            namaPlayerSatu = "Anonymous_1"
        }
        val playerSatu = Player(namaPlayerSatu)

        print("Masukkan nama Player 2 : ")
        var namaPlayerDua = readLine()!!.uppercase().trim().replace(" ","")
        if (namaPlayerDua.isBlank()){
            namaPlayerDua = "Anonymous_2"
        }
        val playerDua = Player(namaPlayerDua)

        var isKeepPlaying = true
        while (isKeepPlaying){
            Utility.getHandMenu()
            playerSatu.attack(playerDua)
            isKeepPlaying = Utility.getYesOrNo("Mau main lagi ngga?")
        }
    }

    fun vsBot(){
        print("Masukkan nama Player 1 : ")
        var namaPlayerSatu = readLine()!!.uppercase().trim().replace(" ","")
        if (namaPlayerSatu.isBlank()){
            namaPlayerSatu = "Anonymous_1"
        }
        val playerSatu = Player(namaPlayerSatu)

        val playerBot = Bot("Bot")
        playerBot.name = "sabrina"

        var isKeepPlaying = true
        while (isKeepPlaying){
            Utility.getHandMenu()
            playerSatu.attack(playerBot)
            isKeepPlaying = Utility.getYesOrNo("Mau main lagi ngga?")
        }
    }
}