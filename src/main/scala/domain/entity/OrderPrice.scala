package domain.entity
case class OrderPrice(op: Int) {
  require(op > 0)
}
