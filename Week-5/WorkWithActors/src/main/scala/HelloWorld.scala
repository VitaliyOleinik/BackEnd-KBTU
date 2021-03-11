import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.scaladsl.LoggerOps
import akka.actor.typed.{ ActorRef, ActorSystem, Behavior }

object HelloWorld {
  //                          строка            ссылка на автора
  final case class Greet(whom: String, replyTo: ActorRef[Greeted])
  //                          строка            ссылка на автора
  final case class Greeted(whom: String, from: ActorRef[Greet])
  // apply = new
  def apply(): Behavior[Greet] = Behaviors.receive { (context, message) =>
    context.log.info("Hello {}!", message.whom)
    // ответное сообщение, тому кто нас вызвал
    message.replyTo ! Greeted(message.whom, context.self)
    // same -> ожидание сообщения
    Behaviors.same
  }
}
