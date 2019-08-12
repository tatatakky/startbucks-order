package domain.error

import domain.entity.SizeInfo._

sealed trait Error
object Error{
  case class SizeNotFound(size: Size) extends Error
}