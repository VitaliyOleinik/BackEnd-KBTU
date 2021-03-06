import akka.actor.typed.Behavior
import akka.actor.typed.receptionist.Receptionist
import akka.actor.typed.scaladsl.Behaviors

object Guardian {
  def apply(): Behavior[Nothing] = {
    Behaviors
      .setup[Receptionist.Listing] { context =>
        context.spawnAnonymous(PingService())
        context.system.receptionist ! Receptionist.Subscribe(PingService.PingServiceKey, context.self)

        Behaviors.receiveMessagePartial[Receptionist.Listing] {
          case PingService.PingServiceKey.Listing(listings) =>
            listings.foreach(ps => context.spawnAnonymous(Pinger(ps)))
            Behaviors.same
        }
      }
      .narrow
  }
}