import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.duration._
import scala.util.{Failure, Success}

object Main {

  import domain.entity.{
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
    PeachOnTheBeachFrappuccino(Shoort, Number(2))
  )

  def main(args: Array[String]): Unit = {
    for (e <- data) {
      (clerkActor ? e).mapTo[Option[SumPrice]].onComplete {
        case Success(optValue) => optValue match {
          case Some(value) => println(value)
          case None => println("Nothing")
        }
        case Failure(e) =>
          println(e.getMessage)
      }
    }

    Thread.sleep(3000)
    system.terminate()
  }

}