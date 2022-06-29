class Perbandingan {

    var handName = arrayOf("batu", "gunting", "kertas")

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

    fun getResult (message : String) : String {
        print(message)
        var userKeyword = readLine()?.lowercase()?.trim()

        while (userKeyword !in handName){
            print("Hanya bisa (batu/gunting/kertas)")
            userKeyword = readLine()?.lowercase()?.trim()
        }
        return userKeyword!!
    }

    fun player1Hand():String{
        return getResult("Player 1 pilih (batu/gunting/kertas) : ")
    }

    fun player2Hand():String{
        return getResult("Player 2 pilih (batu/gunting/kertas) : ")
    }
}