class App {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {

            var isContinueMenu = true

            loopI@ while (isContinueMenu){
                Utility.getHeaderGame()
                Utility.getMainMenu()
                print("\nMasukkan pilihan anda : ")
                val userKeyword = readLine()?.trim()

                when(userKeyword){
                    "1" -> App().twoPlayer()
                    "2" -> App().vsBot()
                    "3" -> break@loopI
                    else -> println("Pilihan salah, pilihan menu hanya 1 - 3 :)")
                }
                isContinueMenu = Utility.getYesOrNo("Mau balik ke menu?")
            }
            Utility.getSayGoodBye()
        }
    }

    fun twoPlayer(){
        print("Masukkan nama Player 1 : ")
        var namaPlayerSatu = readLine()!!.uppercase().trim()
        if (namaPlayerSatu.isBlank()){
            namaPlayerSatu = "Anonymous_1"
        }
        val playerSatu = Player(namaPlayerSatu)

        print("Masukkan nama Player 2 : ")
        var namaPlayerDua = readLine()!!.uppercase().trim()
        if (namaPlayerDua.isBlank()){
            namaPlayerDua = "Anonymous_2"
        }
        val playerDua = Player(namaPlayerDua)

        var isKeepPlaying = true
        while (isKeepPlaying){
            Utility.getHeaderGame()
            for (value in Hand.handName){
                println("         $value")
            }
            println("--UPPERCASE Or lowercase--")
            println("---Space doesn't matter---")
            playerSatu.attack(playerDua)
            isKeepPlaying = Utility.getYesOrNo("Mau main lagi?")
        }
    }

    fun vsBot(){
        print("Masukkan nama Player 1 : ")
        var namaPlayerSatu = readLine()!!.uppercase().trim()
        if (namaPlayerSatu.isBlank()){
            namaPlayerSatu = "Anonymous_1"
        }
        val playerSatu = Player(namaPlayerSatu)

        val playerBot = Bot("Bot")
        playerBot.name = "sabrina"

        var isKeepPlaying = true
        while (isKeepPlaying){
            Utility.getHeaderGame()
            for (value in Hand.handName){
                println("         $value")
            }
            println("--UPPERCASE Or lowercase--")
            println("---Space doesn't matter---")
            playerSatu.attack(playerBot)
            isKeepPlaying = Utility.getYesOrNo("Mau main lagi?")
        }
    }
}