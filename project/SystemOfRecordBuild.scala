import sbt.Keys._
import sbt._

object SystemOfRecordBuild extends Build {

  lazy val root = Project("system-of-record-universe", file("."))
    .aggregate(readserver)

  lazy val readserver = SprayProject("readserver")

}

object GdsProject {
  def apply(name: String) = Project(name, file(name))
    .settings(scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8"))
}

object SprayProject {
  val akkaVersion = "2.3.6"
  val sprayVersion = "1.3.2"

  def apply(name: String) = GdsProject(name)
    .settings(
      libraryDependencies ++= Seq(
        "io.spray" %% "spray-can" % sprayVersion,
        "io.spray" %% "spray-routing" % sprayVersion,
        "io.spray" %% "spray-testkit" % sprayVersion % "test",
        "com.typesafe.akka" %% "akka-actor" % akkaVersion,
        "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test",
        "org.specs2" %% "specs2-core" % "2.3.11" % "test"
      )
    )
}