package domain.entity


object OrderList{

  sealed trait OrderList[+_]
  case object OrderNil extends OrderList[Nothing]
  case class OrderCons(head: Order, tail: OrderList[Order]) extends OrderList[Order]

  sealed trait Error
  case object OrderNotFound extends Error

  def apply(as: Order*): OrderList[Order] =
    if(as.isEmpty) OrderNil
    else OrderCons(as.head, apply(as.tail: _*))

  def finishOneUserProcess(ol: OrderList[Order]): Either[Error, OrderList[Order]] = ol match {
    case OrderNil => Left(OrderNotFound)
    case OrderCons(_, t) => Right(t)
  }
}