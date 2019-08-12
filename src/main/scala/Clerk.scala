import akka.actor.{Actor, Props}
import akka.event.Logging

import domain.entity._
import domain.entity.SizeInfo._
import domain.entity.Order._

object Clerk {
  def props = Props(new Clerk())
}

class Clerk extends Actor {

  val log = Logging(context.system, this)

  def receive = {
    case order @ Order(menu: Menu, size: Size, number: Number) =>
      log.info(s"Customer orders [ $menu, $size, $number ].")
      sender() ! order.price
  }
}

