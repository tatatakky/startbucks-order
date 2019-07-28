package domain.entity

final case class SumPrice(p: Int){
  require(0 < p)
}
