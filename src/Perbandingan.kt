class Perbandingan {

    fun perbandinganVsPlayer(player1: String , player2 : String) : String {
        return if (player1==player2){
            "DRAW"
        } else if (
            player1 == "batu" && player2 == "gunting"
            || player1 == "gunting" && player2 == "kertas"
            || player1 == "kertas" && player2 == "batu"
        ) {
            "Player 1 win"
        } else {
            "Player 2 win"
        }
    }
}