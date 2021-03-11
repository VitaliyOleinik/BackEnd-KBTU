import akka.actor.typed.Behavior
import akka.actor.typed.receptionist.Receptionist
import akka.actor.typed.scaladsl.Behaviors


object PingManager {
  sealed trait Command
  // PingManager ожидает либо PingAll, либо ListingResponse
  case object PingAll extends Command
  private case class ListingResponse(listing: Receptionist.Listing) extends Command

  def apply(): Behavior[Command] = {
    Behaviors.setup[Command] { context =>
      val listingResponseAdapter = context.messageAdapter[Receptionist.Listing](ListingResponse)
      //создается PingService
      context.spawnAnonymous(PingService())

      Behaviors.receiveMessage {
        case PingAll =>
          // запрос на сервис с ключом PingServiceKey
          context.system.receptionist ! Receptionist.Find(PingService.PingServiceKey, listingResponseAdapter)
          Behaviors.same
        case ListingResponse(PingService.PingServiceKey.Listing(listings)) =>
          // список объектов, кто имеет такой ключ
          listings.foreach(ps => context.spawnAnonymous(Pinger(ps)))
          Behaviors.same
      }
    }
  }
}