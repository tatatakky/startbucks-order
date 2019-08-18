import akka.actor.{Actor, ActorLogging, Props}
import akka.event.Logging
import domain.entity._
import domain.entity.SizeInfo._
import domain.entity.Order._
import domain.entity.OrderList._
import domain.entity.Purchased

object Clerk {
  def props = Props(new Clerk())
}

class Clerk extends Actor with ActorLogging{
  def receive = {
    case purchase @ Purchase(name: Name, orderList: OrderList[Order]) =>
      log.info(s"$name, $orderList")
      sender() ! Purchased(name, totalPrice(orderList))
  }
}