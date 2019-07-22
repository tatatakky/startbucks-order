import akka.actor.{Actor, Props}

object StarBucks {
  def props = Props(new StarBucks())

  //later, must add the size of the coffee
  //kind of coffee
  case class PeachOnTheBeachFrappuccino(quantity: Int)
  case class DarkMochaChipFrappuccino(quantity: Int)
  case class MatchaCreamFrappuccino(quantity: Int)

}

class StarBucks extends Actor {

  import StarBucks.{DarkMochaChipFrappuccino, PeachOnTheBeachFrappuccino, MatchaCreamFrappuccino}


  def receive = {
    case PeachOnTheBeachFrappuccino(q: Int) => sender() ! "You bought Peach On The Beach Frappuccino " + q
    case DarkMochaChipFrappuccino(q: Int) => sender() ! "You bought Dark Mocha Chip Frappuccino " + q
    case MatchaCreamFrappuccino(q: Int) => sender() ! "You bought Matcha Cream Frappuccino" + q
  }

}