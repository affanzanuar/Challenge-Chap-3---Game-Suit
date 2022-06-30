class App {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            Utility.getHeaderGame()
            App().twoPlayer()
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
            println("------UPPER Or lower------")
            playerSatu.attack(playerDua)
            isKeepPlaying = Utility.getYesOrNo("Mau main lagi?")
        }
    }
}