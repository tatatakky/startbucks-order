case class User(name: String, id: Int)
object UserList {

  def apply(as: User*): UserList[User] =
    if (as.isEmpty) UserNil
    else UserCons(as.head, apply(as.tail: _*))

  def finishOneUserProcess(ul: UserList[User]): UserList[User] = ul match {
    case UserNil => sys.error("User Nothing")
    case UserCons(_, t) => t
  }

}


sealed trait UserList[+_]
case object UserNil extends UserList[Nothing]
case class UserCons(head: User, tail: UserList[User]) extends UserList[User]

object Main2 {

  import UserList._

  def main(args: Array[String]): Unit = {
    val userList: UserList[User] = UserList(User("bar,", 1), User("foo", 2), User("baz", 3))
    val updateUserList: UserList[User] = finishOneUserProcess(userList)
    println(updateUserList)
  }
}