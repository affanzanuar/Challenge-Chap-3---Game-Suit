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
            val playerSatu = PlayerSatu(readLine()!!.uppercase().trim())
            print("Masukkan nama Player 2 : ")
            val playerDua = PlayerDua(readLine()!!.uppercase().trim())

            playerSatu.attack(playerDua)

        }
    }


}