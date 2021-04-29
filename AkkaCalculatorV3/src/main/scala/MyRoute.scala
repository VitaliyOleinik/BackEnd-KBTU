import akka.actor.typed.ActorSystem
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.{Directives, Route}

import scala.concurrent.ExecutionContext

class MyRouter()(implicit system: ActorSystem[_],  ex:ExecutionContext) extends Directives {
  import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._

  val route =
    parameter("calculate") { input  =>

      val gap = input.filter((char) => char != ' ')
      val answer = Calculator.process(gap)
      get {
        complete {
          "Answer: " + answer
        }
      }
    }
}