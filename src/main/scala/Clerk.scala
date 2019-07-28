import akka.actor.{Actor, Props}
import akka.event.Logging

object Clerk {
  def props = Props(new Clerk())
}

class Clerk extends Actor {

  import domain.entity.{
    DarkMochaChipFrappuccino,
    PeachOnTheBeachFrappuccino,
    MatchaCreamFrappuccino,
    CrunchyAlmondChocolateFrappuccino,
    Size,
    Number
  }

  val log = Logging(context.system, this)

  def receive = {
    case peach@PeachOnTheBeachFrappuccino(size: Size, number: Number) =>
      log.info("peach")
      sender() ! peach.sumPrice
    case darkMocha@DarkMochaChipFrappuccino(size: Size, number: Number) =>
      log.info("darkMocha")
      sender() ! darkMocha.sumPrice
    case matcha@MatchaCreamFrappuccino(size: Size, number: Number) =>
      log.info("matcha")
      sender() ! matcha.sumPrice
    case crunchyAlmond@CrunchyAlmondChocolateFrappuccino(size: Size, number: Number) =>
      log.info("crunchyAlmond")
      sender() ! crunchyAlmond.sumPrice
  }
}
