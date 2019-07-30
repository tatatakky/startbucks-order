import akka.actor.ActorSystem
import akka.testkit.TestKit
import akka.util.Timeout
import org.scalatest.{MustMatchers, WordSpecLike}

import scala.concurrent.Await
import scala.util.Success

class ClerkSpec extends TestKit(ActorSystem("clerk-actor-test-system"))
  with WordSpecLike
  with MustMatchers
  with StopSystemAfterAll{

  import scala.concurrent.duration._
  import akka.pattern.ask

  "The Clerk Actor " must {
    "Reply with the same message it receives" in {

    }
  }

}