package domain.entity

final case class Number(n: Int) {
  require(0 < n)
}
