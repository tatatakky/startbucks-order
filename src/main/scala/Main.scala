import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.duration._
import scala.util.{Failure, Success}

object Main {

  import domain.{CrunchyAlmondChocolateFrappuccino, Size, Tall, Grande, Number, SumPrice}

  val system = ActorSystem("actor-system")
  implicit val executionContext = system.dispatcher
  implicit val timeout = Timeout(3 seconds)

  val clerkActor: ActorRef = system.actorOf(Clerk.props, "clerkActor")

  def main(args: Array[String]): Unit = {
    (clerkActor ? CrunchyAlmondChocolateFrappuccino(Tall, Number(3))).mapTo[SumPrice].onComplete {
      case Success(value) =>
        println(value)
        system.terminate()
      case Failure(e) =>
        println(e.getLocalizedMessage)
        system.terminate()
    }
  }

}