fun String.monogram(): String {
    return this.split(" ").map { it[0] }.joinToString("") { it.toString() }
}

fun List<String>.joinList(): String {
    return this.map { it }.joinToString(prefix = "", separator = "#", postfix = "") { it.toString() }
}

fun List<String>.longestString(): String {
    return this.map { it }.maxByOrNull { it }.toString()
}