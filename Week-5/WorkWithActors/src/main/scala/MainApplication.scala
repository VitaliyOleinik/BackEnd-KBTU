import PingManager.{Command, PingAll}
import akka.actor.typed.{ActorRef, ActorSystem, Behavior}
import org.slf4j.{Logger, LoggerFactory}

object MainApplication extends App {
  // implicit -> где нуждается, само подставляет экземпляр
  implicit  val log: Logger = LoggerFactory.getLogger(getClass)

  def f1(): Unit={
    val system: ActorSystem[HelloWorldMain.SayHello] =
      ActorSystem(HelloWorldMain(), "hello")
    // ! -> хотим отправить actor сообщение
    system ! HelloWorldMain.SayHello("World")
    system ! HelloWorldMain.SayHello("Akka")
  }

  def f2():Unit={
    class Prefixer(val prefix:String)
    def addPrefix(s:String)(implicit p:Prefixer) = p.prefix + s

    implicit  val myPrefix = new Prefixer("***")
    implicit  val myPrefix2 = new Prefixer("!!!")
    println(addPrefix("abc")(myPrefix))
    println(addPrefix("abc")(myPrefix2))
  }

  def f3(): Unit ={
    val system: ActorSystem[Command] =
      ActorSystem(PingManager(), "ping-pong")

    system ! PingAll
  }

  def f4():Unit={
    val system2: ActorSystem[Nothing] =
      ActorSystem[Nothing](Guardian(), "ping-pong2")
    println("enter")
    Thread.sleep(10000)
    println("exit")
  }

  f4()

}
