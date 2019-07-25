import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.duration._
import scala.util.{Failure, Success}

object Main {

  import domain.{
    Frappuccino,
    PeachOnTheBeachFrappuccino,
    DarkMochaChipFrappuccino,
    CrunchyAlmondChocolateFrappuccino,
    MatchaCreamFrappuccino,
    Size,
    Tall,
    Shoort,
    Grande,
    Venti,
    Number,
    SumPrice
  }
  val system = ActorSystem("actor-system")
  implicit val executionContext = system.dispatcher
  implicit val timeout = Timeout(3 seconds)

  val clerkActor: ActorRef = system.actorOf(Clerk.props, "clerkActor")

  val data: List[Frappuccino] = List(
    PeachOnTheBeachFrappuccino(Tall, Number(2)),
    DarkMochaChipFrappuccino(Grande, Number(3)),
    MatchaCreamFrappuccino(Venti, Number(6)),
    CrunchyAlmondChocolateFrappuccino(Tall, Number(3)),
    DarkMochaChipFrappuccino(Venti, Number(2)),
    MatchaCreamFrappuccino(Tall, Number(4)),
    PeachOnTheBeachFrappuccino(Tall, Number(2)),
    DarkMochaChipFrappuccino(Grande, Number(3)),
    MatchaCreamFrappuccino(Venti, Number(6)),
    CrunchyAlmondChocolateFrappuccino(Tall, Number(3)),
    DarkMochaChipFrappuccino(Venti, Number(2)),
    MatchaCreamFrappuccino(Tall, Number(4)),
    PeachOnTheBeachFrappuccino(Tall, Number(2)),
    DarkMochaChipFrappuccino(Grande, Number(3)),
    MatchaCreamFrappuccino(Venti, Number(6)),
    CrunchyAlmondChocolateFrappuccino(Tall, Number(3)),
    DarkMochaChipFrappuccino(Venti, Number(2)),
    MatchaCreamFrappuccino(Tall, Number(4)),
    PeachOnTheBeachFrappuccino(Tall, Number(2)),
    DarkMochaChipFrappuccino(Grande, Number(3)),
    MatchaCreamFrappuccino(Venti, Number(6)),
    CrunchyAlmondChocolateFrappuccino(Tall, Number(3)),
    DarkMochaChipFrappuccino(Venti, Number(2)),
    MatchaCreamFrappuccino(Tall, Number(4)),
    PeachOnTheBeachFrappuccino(Tall, Number(2)),
    DarkMochaChipFrappuccino(Grande, Number(3)),
    MatchaCreamFrappuccino(Venti, Number(6)),
    CrunchyAlmondChocolateFrappuccino(Tall, Number(3)),
    DarkMochaChipFrappuccino(Venti, Number(2)),
    MatchaCreamFrappuccino(Tall, Number(4)),
    PeachOnTheBeachFrappuccino(Tall, Number(2)),
    DarkMochaChipFrappuccino(Grande, Number(3)),
    MatchaCreamFrappuccino(Venti, Number(6)),
    CrunchyAlmondChocolateFrappuccino(Tall, Number(3)),
    DarkMochaChipFrappuccino(Venti, Number(2)),
    MatchaCreamFrappuccino(Tall, Number(4)),
    PeachOnTheBeachFrappuccino(Tall, Number(2)),
    DarkMochaChipFrappuccino(Grande, Number(3)),
    MatchaCreamFrappuccino(Venti, Number(6)),
    CrunchyAlmondChocolateFrappuccino(Tall, Number(3)),
    DarkMochaChipFrappuccino(Venti, Number(2)),
    MatchaCreamFrappuccino(Tall, Number(4)),
    PeachOnTheBeachFrappuccino(Tall, Number(2)),
    DarkMochaChipFrappuccino(Grande, Number(3)),
    MatchaCreamFrappuccino(Venti, Number(6)),
    CrunchyAlmondChocolateFrappuccino(Tall, Number(3)),
    DarkMochaChipFrappuccino(Venti, Number(2)),
    MatchaCreamFrappuccino(Tall, Number(4)),
    PeachOnTheBeachFrappuccino(Tall, Number(2)),
    DarkMochaChipFrappuccino(Grande, Number(3)),
    MatchaCreamFrappuccino(Venti, Number(6)),
    CrunchyAlmondChocolateFrappuccino(Tall, Number(3)),
    DarkMochaChipFrappuccino(Venti, Number(2)),
    MatchaCreamFrappuccino(Tall, Number(4)),
    PeachOnTheBeachFrappuccino(Tall, Number(2)),
    DarkMochaChipFrappuccino(Grande, Number(3)),
    MatchaCreamFrappuccino(Venti, Number(6)),
    CrunchyAlmondChocolateFrappuccino(Tall, Number(3)),
    DarkMochaChipFrappuccino(Venti, Number(2)),
    MatchaCreamFrappuccino(Tall, Number(4)),
    PeachOnTheBeachFrappuccino(Tall, Number(2)),
    DarkMochaChipFrappuccino(Grande, Number(3)),
    MatchaCreamFrappuccino(Venti, Number(6)),
    CrunchyAlmondChocolateFrappuccino(Tall, Number(3)),
    DarkMochaChipFrappuccino(Venti, Number(2)),
    MatchaCreamFrappuccino(Tall, Number(4)),PeachOnTheBeachFrappuccino(Tall, Number(2)),
    DarkMochaChipFrappuccino(Grande, Number(3)),
    MatchaCreamFrappuccino(Venti, Number(6)),
    CrunchyAlmondChocolateFrappuccino(Tall, Number(3)),
    DarkMochaChipFrappuccino(Venti, Number(2)),
    MatchaCreamFrappuccino(Tall, Number(4)),
    PeachOnTheBeachFrappuccino(Tall, Number(2)),
    DarkMochaChipFrappuccino(Grande, Number(3)),
    MatchaCreamFrappuccino(Venti, Number(6)),
    CrunchyAlmondChocolateFrappuccino(Tall, Number(3)),
    DarkMochaChipFrappuccino(Venti, Number(2)),
    MatchaCreamFrappuccino(Tall, Number(4)),
    PeachOnTheBeachFrappuccino(Tall, Number(2)),
    DarkMochaChipFrappuccino(Grande, Number(3)),
    MatchaCreamFrappuccino(Venti, Number(6)),
    CrunchyAlmondChocolateFrappuccino(Tall, Number(3)),
    DarkMochaChipFrappuccino(Venti, Number(2)),
    MatchaCreamFrappuccino(Tall, Number(4))

  )

  def main(args: Array[String]): Unit = {
    for (e <- data) {
      (clerkActor ? e).mapTo[SumPrice].onComplete {
        case Success(value) =>
          println(value)
        case Failure(e) =>
          println(e.getMessage)
      }
    }
//    (clerkActor ? CrunchyAlmondChocolateFrappuccino(Tall, Number(30))).mapTo[SumPrice].onComplete {
//      case Success(value) =>
//        println(value)
//        system.terminate()
//      case Failure(e) =>
//        println(e.getLocalizedMessage)
//        system.terminate()
//    }
  }

}
