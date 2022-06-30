class App {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {

            println("""
                ==========================
                GAME SUIT TERMINAL VERSION
                ==========================
            """.trimIndent())

            val compare = Perbandingan()
            val playerSatu = PlayerSatu()
            val playerDua = PlayerDua()


            val result = compare.perbandinganVsPlayer(playerSatu.playerHand(),playerDua.playerHand())
            println(result)

        }
    }


}