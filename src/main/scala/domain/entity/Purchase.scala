package domain.entity

import domain.entity.OrderList._

case class Purchase(name: Name, orderList: OrderList[Order])