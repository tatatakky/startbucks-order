package domain.entity

import domain.error._

object OrderList{

  sealed trait OrderList[+_]
  case object OrderNil extends OrderList[Nothing]
  case class OrderCons(head: Order, tail: OrderList[Order]) extends OrderList[Order]

  def apply(as: Order*): OrderList[Order] =
    if(as.isEmpty) OrderNil
    else OrderCons(as.head, apply(as.tail: _*))

  @annotation.tailrec
  def foldLeft[A,B](l: OrderList[Order], z: B)(f: (B, Order) => B): B = l match {
    case OrderNil => z
    case OrderCons(h,t) => foldLeft(t, f(z,h))(f)
  }

  def totalPrice(orderList: OrderList[Order]): TotalPrice = {
    val le = foldLeft(orderList, List[Either[Error, OrderPrice]]())((x, y) =>  y.price :: x)
    val total = le.foldRight(0)((x, y) => x match {
      case Right(value) => value.op + y
      case Left(err)    => 0
    })
    TotalPrice(total)
  }

}