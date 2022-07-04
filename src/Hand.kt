object Hand {
    var handName = arrayOf(
        HandType.A.nama,
        HandType.B.nama,
        HandType.C.nama
    )

    var handInMenu = listOf(
        "                   * ROCK   =>  batu",
        "                   * PAPER   =>  kertas",
        "                   * SCISSOR   =>  gunting")

    fun getResult (message : String) : String {
        print(message)
        var userKeyword = readLine()?.lowercase()?.trim()?.replace(" ","")?.replace("\t","")
            ?.replace("rock","batu")?.replace("scissor", "gunting")
            ?.replace("paper","kertas")

        while (userKeyword !in handName){
            print("Hanya boleh pilih salah satu di atas : ")
            userKeyword = readLine()?.lowercase()?.trim()?.replace(" ","")?.replace("\t","")
                ?.replace("rock","batu")?.replace("scissor", "gunting")
                ?.replace("paper","kertas")
        }
        return userKeyword!!
    }
}