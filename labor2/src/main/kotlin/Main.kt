
fun main(){
    //val dict: iDictionary = ListDictionary
    val dict: iDictionary = DictionaryProvider.createDictionary(DictionaryType.ARRAY_LIST)
    var index = 0
    println("Number of words: ${dict.size()}")
    var word: String?
    while(index != 3){
        print("What to find? (listDictionary) ")
        word = readLine()
        if( word.equals("quit")){
            break
        }
        println("Result: ${word?.let { dict.find(it) }}")
        index+=1
    }
    
    //val dict2: iDictionary = HashSetDictionary
    val dict2: iDictionary = DictionaryProvider.createDictionary(DictionaryType.HASH_SET)
    index=0
    println("Number of words: ${dict2.size()}")
    var word2: String?
    while(index != 3){
        print("What to find? (hashSetDictionary) ")
        word2 = readLine()
        if( word2.equals("quit")){
            break
        }
        println("Result: ${word2?.let { dict2.find(it) }}")
        index+=1
    }

    //val dict3: iDictionary = TreeSetDictionary
    val dict3: iDictionary = DictionaryProvider.createDictionary(DictionaryType.TREE_SET)
    index=0
    println("Number of words: ${dict3.size()}")
    var word3: String?
    while(index != 3){
        print("What to find? (treeSetDictionary) ")
        word3 = readLine()
        if( word3.equals("quit")){
            break
        }
        println("Result: ${word3?.let { dict3.find(it) }}")
        index+=1
    }

    //2-ES
    val stringList = listOf("apple", "pear", "melon", "strawberry")

    println("JOHN SMITH".monogram())

    println(stringList.joinList())

    println(stringList.longestString())
}