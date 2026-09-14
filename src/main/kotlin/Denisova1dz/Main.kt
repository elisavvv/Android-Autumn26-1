package Denisova1dz

import Denisova1dz.parser.CsvParser

fun main() {
    val result = CsvParser.parse("src/main/resources/fakePlayersDirty.csv")

    println("Успешно прочли игроков: ${result.players.size}")
    println("Пропустили невалидных строк: ${result.skippedCount}")
}