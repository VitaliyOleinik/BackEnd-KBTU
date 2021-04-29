import com.typesafe.sbt.packager.docker.ExecCmd

name := "week11"

version := "0.1"

scalaVersion := "2.13.5"

enablePlugins(JavaAppPackaging, AshScriptPlugin)

dockerBaseImage := "openjdk:8-jre-alpine"
packageName in Docker := "week11"

scalaVersion := "2.12.6"

val akkaVersion = "2.6.8"
val akkaHttpVersion = "10.2.4"
val circeVersion = "0.9.3"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % Test,
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test,

  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  "de.heikoseeberger" %% "akka-http-circe" % "1.21.0",

  "org.scalatest" %% "scalatest" % "3.0.5" % Test,

  "ch.qos.logback" % "logback-classic" % "1.2.3",

  "net.debasishg" %% "redisclient" % "3.30",

  "org.mongodb.scala" %% "mongo-scala-driver" % "2.9.0",
)
// heroku
dockerCommands := dockerCommands.value.map {
  case ExecCmd("CMD", _ @ _*) =>
    ExecCmd("CMD", "/opt/docker/bin/week11")
  case other =>
    other
}
//deploy.sh week10vit f185af6d8bfb eeb7f282-15b4-4097-add4-79292c48bbde

// docker run -d -p 9000:9000 week11:0.1