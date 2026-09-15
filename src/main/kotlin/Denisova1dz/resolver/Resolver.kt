package Denisova1dz.resolver

import Denisova1dz.model.Player
import Denisova1dz.model.Team
import Denisova1dz.model.Position

class Resolver  (private val players: List<Player>) : IResolver {

    //игроки, чьи интересы не представляет агенство,
    // .isNullOrBlank() проверяет и на null, и на пустую строку, и на строку только из пробельных символов
    override fun getCountWithoutAgency(): Int = players.count { it.agency.isNullOrBlank() }

    //автор наибольшего числа голов из числа защитников и их количество
    override fun getBestScorerDefender(): Pair<String, Int> = players
        .filter { it.position == Position.DEFENDER } // фильтруем только защитников
        .maxBy { it.goals }                           // ищем защитника с максимальным числом голов
        .let { it.name to it.goals }                  // превращаем его в Pair(Имя, Голы)

    //русское название позиции самого дорогого немецкого игрока
    override fun getTheExpensiveGermanPlayerPosition(): String = players
        .filter { it.country == "Germany" }
        .maxByOrNull { it.transfer }
        ?.position
        ?.title ?: "Неизвестно"


    // Заглушки для остальных функций:
    override fun getTheRudestTeam(): Team = TODO()
    override fun getAverageTransferCostByPosition(): Map<Position, Double> = TODO()
    override fun getMostValuablePlayers(): List<Player> = TODO()
    override fun getMostPopularAgencyByCountry(): Map<String, String> = TODO()
    override fun getGoalsShareByMedianCost(): Pair<Double, Double> = TODO()
}