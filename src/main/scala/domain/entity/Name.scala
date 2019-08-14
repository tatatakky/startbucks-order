package domain.entity

case class Name(name: String) {
  require(name.length > 0)
}