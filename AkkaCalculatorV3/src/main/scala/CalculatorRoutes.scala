import akka.http.scaladsl.server.{Directives, Route}
import validator.{ValidatorDirectives}

case class CalculatorRoutes(repository: CalculatorRepository) extends Directives

  with ValidatorDirectives {

  val routes: Route =
    path("calculate") {
      get {
        parameters('equation.as[String]) { equation =>
          complete {
            repository.calculate(equation)
          }
        }
      }
    }
  }