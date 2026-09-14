package Denisova1dz.model

// Задание: добавьте константы позиций из CSV (FORWARD, MIDFIELD, DEFENDER, GOALKEEPER)
// с русским названием у каждой, а также companion-функцию
// fromCsvTokenOrNull(token: String): Position?, не зависящую от регистра и лишних пробелов.
enum class Position(val title: String) {
    FORWARD("НАПАДАЮЩИЙ"),
    MIDFIELD("ПОЛУЗАЩИТНИК"),
    DEFENDER("ЗАЩИТНИК"),
    GOALKEEPER("ВРАТАРЬ");

    companion object {
        fun fromCsvTokenOrNull(token: String): Position? {
            val normalized = token.trim().lowercase() //trim -убирает лишние пробелы, lowercase - делает все маленкими буквами
            return entries.find { it.title.lowercase() == normalized }
        }
    }
}
