package domain

final case class Number(n: Int) {
  require(0 < n)
}
