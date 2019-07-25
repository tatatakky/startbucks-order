package domain
//later, must add the size of the coffee
//kind of coffee
sealed trait Frappuccino {
  def sumPrice: SumPrice
}

case class PeachOnTheBeachFrappuccino(size: Size, number: Number) extends Frappuccino {
  def sumPrice: SumPrice = size match {
    case Shoort => SumPrice(0)
    case Tall   => SumPrice(620 * number.n)
    case Grande => SumPrice(0)
    case Venti  => SumPrice(0)
  }
}

case class DarkMochaChipFrappuccino(size: Size, number: Number) extends Frappuccino {
  def sumPrice: SumPrice = size match {
    case Shoort => SumPrice(0)
    case Tall   => SumPrice(500 * number.n)
    case Grande => SumPrice(540 * number.n)
    case Venti  => SumPrice(580 + number.n)
  }
}
case class MatchaCreamFrappuccino(size: Size, number: Number) extends Frappuccino {
  def sumPrice: SumPrice = size match {
    case Shoort => SumPrice(0)
    case Tall   => SumPrice(490 * number.n)
    case Grande => SumPrice(530 * number.n)
    case Venti  => SumPrice(570 * number.n)
  }
}

case class CrunchyAlmondChocolateFrappuccino(size: Size, number: Number) extends Frappuccino {
  def sumPrice: SumPrice = size match {
    case Shoort => SumPrice(520 * number.n)
    case Tall   => SumPrice(560 * number.n)
    case Grande => SumPrice(600 * number.n)
    case Venti  => SumPrice(640 * number.n)
  }
}

case class SumPrice(p: Int)

sealed trait Size
case object Shoort extends Size
case object Tall extends Size
case object Grande extends Size
case object Venti extends Size

case class Number(n: Int) {
  require(0 < n)
}