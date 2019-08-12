package domain.entity

case class Number(n: Int) {
  require(n > 0)
}