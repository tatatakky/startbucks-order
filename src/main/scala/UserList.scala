case class User(name: String, id: Int)
object UserList {

  //Userのみを許容するリスト
  sealed trait UserList[+_]
  case object UserNil extends UserList[Nothing]
  case class UserCons(head: User, tail: UserList[User]) extends UserList[User]

  def apply(as: User*): UserList[User] =
    if (as.isEmpty) UserNil
    else UserCons(as.head, apply(as.tail: _*))

  def finishOneUserProcess(ul: UserList[User]): Either[Error, UserList[User]] = ul match {
    case UserNil => Left(UserNotFound)
    case UserCons(_, t) => Right(t)
  }
}

sealed trait Error
case object UserNotFound extends Error

object Main2 {

  import UserList._

  def main(args: Array[String]): Unit = {
    val userList: UserList[User] = UserList(User("bar,", 1), User("foo", 2), User("baz", 3))
    val userList2: UserList[User] = UserList()
    finishOneUserProcess(userList) match {
      case Right(value) => println(value)
      case Left(error)  => println(error)
    }
  }
}