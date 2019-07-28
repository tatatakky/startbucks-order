package domain.entity

sealed trait Frappuccino {
  def sumPrice: Option[SumPrice]
}

case class PeachOnTheBeachFrappuccino(size: Size, number: Number) extends Frappuccino {
  def sumPrice: Option[SumPrice] = size match {
    case Shoort => None
    case Tall   => Option(SumPrice(620 * number.n))
    case Grande => None
    case Venti  => None
  }
}

case class DarkMochaChipFrappuccino(size: Size, number: Number) extends Frappuccino {
  def sumPrice: Option[SumPrice] = size match {
    case Shoort => None
    case Tall   => Option(SumPrice(500 * number.n))
    case Grande => Option(SumPrice(540 * number.n))
    case Venti  => Option(SumPrice(580 * number.n))
  }
}

case class MatchaCreamFrappuccino(size: Size, number: Number) extends Frappuccino {
  def sumPrice: Option[SumPrice] = size match {
    case Shoort => None
    case Tall   => Option(SumPrice(490 * number.n))
    case Grande => Option(SumPrice(530 * number.n))
    case Venti  => Option(SumPrice(570 * number.n))
  }
}

case class CrunchyAlmondChocolateFrappuccino(size: Size, number: Number) extends Frappuccino {
  def sumPrice: Option[SumPrice] = size match {
    case Shoort => Option(SumPrice(520 * number.n))
    case Tall   => Option(SumPrice(560 * number.n))
    case Grande => Option(SumPrice(600 * number.n))
    case Venti  => Option(SumPrice(640 * number.n))
  }
}