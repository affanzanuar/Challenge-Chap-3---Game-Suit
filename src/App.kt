class App {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {

            println("""
                ==========================
                GAME SUIT TERMINAL VERSION
                ==========================
            """.trimIndent())

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
            playerSatu.attack(playerDua)
            isKeepPlaying = getYesOrNo("Mau main lagi?")
        }
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