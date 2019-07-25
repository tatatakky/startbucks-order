import akka.actor.{Actor, Props}

object Clerk {
  def props = Props(new Clerk())
}

class Clerk extends Actor {

  import domain.{
    DarkMochaChipFrappuccino,
    PeachOnTheBeachFrappuccino,
    MatchaCreamFrappuccino,
    CrunchyAlmondChocolateFrappuccino,
    Size,
    Number
  }

  def receive = {
    case peach@PeachOnTheBeachFrappuccino(size: Size, number: Number) =>
      sender() ! peach.sumPrice
    case darkMocha@DarkMochaChipFrappuccino(size: Size, number: Number) =>
      sender() ! darkMocha.sumPrice
    case matcha@MatchaCreamFrappuccino(size: Size, number: Number) =>
      sender() ! matcha.sumPrice
    case crunchyAlmond@CrunchyAlmondChocolateFrappuccino(size: Size, number: Number) =>
      sender() ! crunchyAlmond.sumPrice
  }
}
