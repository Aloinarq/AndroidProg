interface iDictionary {
    fun add(word: String) : Boolean
    fun find(word: String) : Boolean
    fun size() : Int

    companion object{
        var PATH = "D:\\EGYETEM\\4 - Negyedev\\Android\\labor2\\lab2_in.txt"
    }
}

