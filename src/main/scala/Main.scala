import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.Future
import scala.concurrent.duration._
import scala.util.{Failure, Success}

import domain.entity._
import domain.entity.SizeInfo._
import domain.entity.Menu._
import domain.error._
import domain.entity.OrderList._

object Main {

  val system = ActorSystem("actor-system")
  implicit val executionContext = system.dispatcher
  implicit val timeout = Timeout(3 seconds)

  val clerkActor: ActorRef = system.actorOf(Clerk.props, "clerkActor")

  def main(args: Array[String]): Unit = {

    val order: Order = Order(CoffeeFrappuccino, Tall, Number(2))

    val purchase: Purchase =
      Purchase(
        Name("bar"),
        OrderList(
          Order(DarkMochaChipFrappuccino, Shoort, Number(3)),
          Order(CoffeeFrappuccino, Tall, Number(2)),
          Order(CrunchyAlmondChocolateFrappuccino, Grande, Number(2))
        )
      )

    val result: Future[Purchased] =
      (clerkActor ? purchase).mapTo[Purchased]
    result.onComplete{
      case Success(v) => println(v)
      case Failure(f) => println(f)
    }

    Thread.sleep(2000)
    system.terminate()
  }
}


//    val result: Future[Either[Error, OrderPrice]] =
//      (clerkActor ? order)
//        .mapTo[Either[Error, OrderPrice]]
//    result.onComplete {
//      case Success(optValue) =>
//        optValue match {
//          case Right(value) => println(value)
//          case Left(error)  => println(error)
//        }
//      case Failure(e) =>
//        println(e.getMessage)
//    }