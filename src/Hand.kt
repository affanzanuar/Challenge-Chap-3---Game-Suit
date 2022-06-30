object Hand {
    private var handName = arrayOf(
        HandType.A.nama,
        HandType.B.nama,
        HandType.C.nama
    )

    fun getResult (message : String) : String {
        print(message)
        var userKeyword = readLine()?.lowercase()?.trim()

        while (userKeyword !in handName){
            print("Hanya bisa (batu/gunting/kertas)")
            userKeyword = readLine()?.lowercase()?.trim()
        }
        return userKeyword!!
    }
}