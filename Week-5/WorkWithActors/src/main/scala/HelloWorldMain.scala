import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.scaladsl.LoggerOps
import akka.actor.typed.{ ActorRef, ActorSystem, Behavior }

object HelloWorldMain {
  // has own case class with parameter name
  final case class SayHello(name: String)

  def apply(): Behavior[SayHello] =
  // конструктором Behaviors (spawn создает дочернего актора HelloWorld)
    Behaviors.setup { context =>
      val greeter = context.spawn(HelloWorld(), "greeter")

      Behaviors.receiveMessage { message =>
        // создает объект HelloWorldBot(where max = 3), with message of this bot
        val replyTo = context.spawn(HelloWorldBot(max = 3), message.name)
        // greeter будет отвечать
        greeter ! HelloWorld.Greet(message.name, replyTo)
        Behaviors.same
      }
    }

}