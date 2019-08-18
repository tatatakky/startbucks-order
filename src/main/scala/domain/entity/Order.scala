package domain.entity

import domain.error._
import domain.entity.SizeInfo._

case class Order(menu: Menu, size: Size, number: Number) {

  def priceCalculation(sizePrice: SizePrice, number: Number)(f: (Int, Int) => Int): OrderPrice =
    OrderPrice(f(sizePrice.sp, number.n))

  def price: Either[Error, OrderPrice] =
    menu.sizePrice(size) match {
      case Right(sizePrice) =>
        Right(priceCalculation(sizePrice, number)(_ * _))
      case Left(e) => Left(e)
    }

}

//
//sealed trait OrderList
//case object Nil extends OrderList[Nothing]
//case class Cons(h: Order, t: OrderList[Order]) extends OrderList[Order]