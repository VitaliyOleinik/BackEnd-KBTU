import akka.actor.typed.Behavior
import akka.actor.typed.receptionist.Receptionist
import akka.actor.typed.scaladsl.Behaviors

object Guardian {
  def apply(): Behavior[Nothing] = {
    Behaviors
      .setup[Receptionist.Listing] { context =>
        // запсукаем аннонимно
        context.spawnAnonymous(PingService())
        // подписываемся указываем ключ Ping, context
        context.system.receptionist ! Receptionist.Subscribe(PingService.PingServiceKey, context.self)
        // получаем тип значения Receptionist
        Behaviors.receiveMessagePartial[Receptionist.Listing] {
          case PingService.PingServiceKey.Listing(listings) =>
            // для каждого порождаем Pinger(ps)
            listings.foreach(ps => context.spawnAnonymous(Pinger(ps)))
            Behaviors.same
        }
      }
      .narrow
  }
}