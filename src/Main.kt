import Main.Companion.twoPlayer
import Main.Companion.vsBot

fun main() {

    var isContinueMenu = true

    loopI@ while (isContinueMenu){
        Utility.getHeaderGame()
        Utility.getMainMenu()
        print("\nMasukkan pilihan anda (1-3) : ")
        val userKeyword = readLine()?.lowercase()?.trim()?.replace("\t","")
            ?.replace(" ","")
        println()
        when(userKeyword){
            in Utility.answer1 -> twoPlayer()
            in Utility.answer2 -> vsBot()
            in Utility.answer3 -> break@loopI
            else -> println("Pilihan salah, pilihan menu hanya (1 - 3 / satu - tiga / one - three) :)")
        }
        isContinueMenu = Utility.getYesOrNo("Mau balik ke menu?")
    }
    Utility.getSayGoodBye()
}

class Main {

    companion object{

        private lateinit var playerSatu : Person
        private lateinit var playerDua : Person
        private lateinit var playerBot : Bot

        private fun inputNamePlayerOne(){
            print("Masukkan nama Player 1 : ")
            var namaPlayerSatu = readLine()!!.uppercase().trim().replace(" ","")
                .replace("\t","")
            if (namaPlayerSatu.isBlank()){
                namaPlayerSatu = "Anonymous_1"
            }
            playerSatu = Person(namaPlayerSatu)
        }

        fun twoPlayer(){
            inputNamePlayerOne()
            print("Masukkan nama Player 2 : ")
            var namaPlayerDua = readLine()!!.uppercase().trim().replace(" ","")
                .replace("\t","")
            if (namaPlayerDua.isBlank()){
                namaPlayerDua = "Anonymous_2"
            }
            playerDua = Person(namaPlayerDua)

            var isKeepPlaying = true
            while (isKeepPlaying){
                Utility.getHandMenu()
                playerSatu.attack(playerDua)
                isKeepPlaying = Utility.getYesOrNo("Mau main lagi ngga?")
            }
        }

        fun vsBot(){
            inputNamePlayerOne()
            playerBot = Bot("Bot")
            playerBot.name = "sabrina"

            var isKeepPlaying = true
            while (isKeepPlaying){
                Utility.getHandMenu()
                playerSatu.attack(playerBot)
                isKeepPlaying = Utility.getYesOrNo("Mau main lagi ngga?")
            }
        }
    }
}