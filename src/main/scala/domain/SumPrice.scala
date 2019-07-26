package domain

final case class SumPrice(p: Int){
  require(0 < p)
}
