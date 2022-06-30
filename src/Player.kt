abstract class Player {
    open lateinit var name : String
    var a = HandType.A.nama
    var b = HandType.B.nama
    var c = HandType.C.nama

    abstract fun playerHand() : String

    fun attack(opponent : Player){
        println("${this.name} V.S ${opponent.name}")
        println(perbandinganVsPlayer(this.playerHand(),opponent.playerHand()))
    }

    private fun perbandinganVsPlayer(player1: String, opponent : String) : String {
        return if (player1==opponent){
            "DRAW"
        } else if (
            player1 == a && opponent == b
            || player1 == b && opponent == c
            || player1 == c && opponent == a
        ) {
            "${this.name} WIN"
        } else {
            "Player 2 WIN"
        }
    }
}