fun Date.isLeapYear(): Boolean = this.year % 4 == 0 || (this.year % 100 == 0 && this.year % 400 == 0)

val months = listOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

fun Date.isValid(): Boolean {
    if (this.month == 2 && this.isLeapYear() && this.day <= 29) return true
    return this.day <= months[month - 1]
}

class DateComparator : Comparator<Date> {
    override fun compare(o1: Date?, o2: Date?): Int {
        if (o1 == null || o2 == null) return 0
        if (o1.day >= o2.day) return 1
        return -1
    }
}