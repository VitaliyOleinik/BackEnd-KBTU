import akka.actor.typed.ActorRef
import akka.actor.typed.Behavior
import akka.actor.typed.receptionist.Receptionist
import akka.actor.typed.receptionist.ServiceKey
import akka.actor.typed.scaladsl.Behaviors

object PingService {
  val PingServiceKey = ServiceKey[Ping]("pingService")

  final case class Ping(replyTo: ActorRef[Pong.type])
  case object Pong
  // принимает все сообщения типа Ping
  def apply(): Behavior[Ping] = {
    Behaviors.setup { context =>
      // отправляем сообщение администратору
      context.system.receptionist ! Receptionist.Register(PingServiceKey, context.self)

      Behaviors.receiveMessage {
        // если сообщение приходит типа Ping
        case Ping(replyTo) =>
        // выводит кем было отправлено
          context.log.info("Pinged by {}", replyTo)
          // ответ сообщением Pong
          replyTo ! Pong
          // ожидание
          Behaviors.same
      }
    }
  }
}