import akka.actor.{Actor, Props}

object Clerk {
  def props = Props(new Clerk())

  //later, must add the size of the coffee
  //kind of coffee
  case class PeachOnTheBeachFrappuccino(price: Price)
  case class DarkMochaChipFrappuccino(price: Price)
  case class MatchaCreamFrappuccino(price: Price)
  case class Price(p: Int)

}

class Clerk extends Actor {

  import Clerk.{DarkMochaChipFrappuccino, PeachOnTheBeachFrappuccino, MatchaCreamFrappuccino, Price}
  
  def receive = {
    case PeachOnTheBeachFrappuccino(price: Price) => sender() ! s"You bought Peach On The Beach Frappuccino ${price.p} yen"
    case DarkMochaChipFrappuccino(price: Price) => sender() ! s"You bought Dark Mocha Chip Frappuccino ${price.p} yen"
    case MatchaCreamFrappuccino(price: Price) => sender() ! s"You bought Matcha Cream Frappuccino ${price.p} yen"
  }
}