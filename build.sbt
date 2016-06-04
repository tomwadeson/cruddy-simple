lazy val root = (project in file(".")).
  settings(
    name := "cruddy-simple"
  )

version := "0.1"

scalaVersion := "2.11.8"

val http4sVersion = "0.13.2"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.http4s" %% "http4s-server" % http4sVersion,
  "org.http4s" %% "http4s-blaze-server" % http4sVersion,
  "org.postgresql" % "postgresql" % "9.3-1100-jdbc4"
)

flywayUrl := "jdbc:postgresql://dockerhost/cruddysimple" // dockerhost = docker-machine ip
flywayUser := "cruddysimple"
flywayPassword := "password"