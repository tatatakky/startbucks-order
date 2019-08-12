package domain.entity

import domain.error.Error
import domain.error.Error._
import domain.entity.SizeInfo._

sealed trait Menu {
  def sizePrice(size: Size): Either[Error, SizePrice]
}

object Menu {

  case object DarkMochaChipFrappuccino extends Menu {
    def sizePrice(size: Size): Either[Error, SizePrice] = size match {
      case Shoort => Right(SizePrice(500))
      case Tall   => Left(SizeNotFound(size))
      case Grande => Right(SizePrice(540))
      case Venti  => Right(SizePrice(580))
    }
  }

  case object CoffeeFrappuccino extends Menu {
    def sizePrice(size: Size): Either[Error, SizePrice] = size match {
      case Shoort => Left(SizeNotFound(size))
      case Tall   => Right(SizePrice(440))
      case Grande => Right(SizePrice(480))
      case Venti  => Right(SizePrice(520))
    }
  }

  case object CrunchyAlmondChocolateFrappuccino extends Menu {
    def sizePrice(size: Size): Either[Error, SizePrice] = size match {
      case Shoort => Right(SizePrice(520))
      case Tall   => Right(SizePrice(560))
      case Grande => Right(SizePrice(600))
      case Venti  => Right(SizePrice(640))
    }
  }
}
