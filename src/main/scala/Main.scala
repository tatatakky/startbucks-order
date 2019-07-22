
import StarBucks.DarkMochaChipFrappuccino
import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout


import scala.concurrent.duration._
import scala.util.{Success, Failure}

object Main {

  val system = ActorSystem("actor-system")
  implicit val executionContext = system.dispatcher
  implicit val timeout = Timeout(3 seconds)

  val starBucks = StarBucks.props
  val starBucksActor: ActorRef = system.actorOf(StarBucks.props, "starBucksActor")

  def main(args: Array[String]): Unit = {

    (starBucksActor ? DarkMochaChipFrappuccino(2)).mapTo[String].onComplete{
      case Success(value) =>
        println(value)
        system.terminate()
      case Failure(e) =>
        println(e.getLocalizedMessage)
        system.terminate()
    }

  }

}