class App {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {

            println("""
                ==========================
                GAME SUIT TERMINAL VERSION
                ==========================
            """.trimIndent())


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

            playerSatu.attack(playerDua)

        }
    }
}