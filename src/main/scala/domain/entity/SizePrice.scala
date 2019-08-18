package domain.entity

case class SizePrice(sp: Int){
  require(sp > 0)
}
