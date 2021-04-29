import scala.concurrent.Future
import scala.util.{Failure, Success}

import akka.http.scaladsl.server.{Directive1, Directives}

trait TodoDirectives extends Directives {

  import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
  import io.circe.generic.auto._
  // abstract T, двухуровневая функция
  def handle[T](f: Future[T])(e: Throwable => ApiError): Directive1[T] = onComplete(f) flatMap {
    case Success(t) =>
      provide(t)
    case Failure(error) =>
      val apiError = e(error)
      // если ошибка, то берем ее данные
      complete(apiError.statusCode, apiError.message)
  }

  def handleWithGeneric[T](f: Future[T]): Directive1[T] = {
    // результат apierror.generic
    handle[T](f)(_ => ApiError.generic)
  }

}