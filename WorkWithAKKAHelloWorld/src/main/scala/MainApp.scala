import PingManager.{Command, PingAll}
import akka.actor.typed.receptionist.Receptionist
import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, ActorSystem, Behavior}
import org.slf4j.{Logger, LoggerFactory}

object MainApp extends App {

  implicit val log: Logger = LoggerFactory.getLogger(getClass)

  def f1(): Unit ={


    val system: ActorSystem[HelloWorldMain.SayHello] =
      ActorSystem(HelloWorldMain(), "hello")

    system ! HelloWorldMain.SayHello("World")
    system ! HelloWorldMain.SayHello("Akka")
  }

  def f2(): Unit ={
    class Prefixer(val prefix:String)
    def addPrefix(s:String)(implicit p:Prefixer) = p.prefix + s

    implicit  val myPrefix = new Prefixer("***")

    println(addPrefix("abc"))

  }

  def f3(): Unit ={
    val system: ActorSystem[Command] =
      ActorSystem(PingManager(), "ping-pong")

    system ! PingAll
  }


  def f4(): Unit ={

    val system:ActorSystem[Nothing] = ActorSystem[Nothing](Guardian(),"ping-pong2")

    println("enter")
    Thread.sleep(10000)
    println("exit")

  }


  f4()

}
