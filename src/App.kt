class App {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {

            println("""
                ==========================
                GAME SUIT TERMINAL VERSION
                ==========================
            """.trimIndent())


            var perbandingan = Perbandingan()
            var result = perbandingan.perbandinganVsPlayer(perbandingan.player1Hand(),perbandingan.player2Hand())
            println(result)

        }
    }


}