object Hand {
    var handName = arrayOf(
        HandType.A.nama,
        HandType.B.nama,
        HandType.C.nama
    )

    var handNameEng = listOf("|| ROCK  =>  batu", "|| PAPER   =>  kertas", "|| SCISSOR   =>  gunting")

    fun getResult (message : String) : String {
        print(message)
        var userKeyword = readLine()?.lowercase()?.trim()?.replace(" ","")
            ?.replace("rock","batu")?.replace("scissor", "gunting")?.replace("paper","kertas")

        while (userKeyword !in handName){
            print("Hanya bisa memilih pilihan di atas : ")
            userKeyword = readLine()?.lowercase()?.trim()?.replace(" ","")
                ?.replace("rock","batu")?.replace("scissor", "gunting")?.replace("paper","kertas")
        }
        return userKeyword!!
    }
}