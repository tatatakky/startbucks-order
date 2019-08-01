package domain.entity

//import domain.entity.{PeachOnTheBeachFrappuccino, DarkMochaChipFrappuccino, MatchaCreamFrappuccino, CrunchyAlmondChocolateFrappuccino}

sealed trait Confirmation {
  def process(): Either[Throwable, SumPrice]
}

case object Ok extends Confirmation{
  def process: Either[Throwable, SumPrice] = ???
}

case object No extends Confirmation{
  def process(): Either[Throwable, SumPrice] = ???
}

