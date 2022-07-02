object Hand {
    var handName = arrayOf(
        HandType.A.nama,
        HandType.B.nama,
        HandType.C.nama
    )

    fun getResult (message : String) : String {
        print(message)
        var userKeyword = readLine()?.lowercase()?.trim()?.replace(" ","")

        while (userKeyword !in handName){
            print("Hanya bisa memilih pilihan di atas : ")
            userKeyword = readLine()?.lowercase()?.trim()?.replace(" ","")
        }
        return userKeyword!!
    }
}