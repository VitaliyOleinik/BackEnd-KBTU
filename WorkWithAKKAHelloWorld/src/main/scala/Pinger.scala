import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, Behavior}

object Pinger {
  def apply(pingService: ActorRef[PingService.Ping]): Behavior[PingService.Pong.type] = {
    Behaviors.setup { context =>
      pingService ! PingService.Ping(context.self)

      Behaviors.receiveMessage { _ =>
        context.log.info("{} was ponged!!", context.self)
        Behaviors.stopped
      }
    }
  }
}