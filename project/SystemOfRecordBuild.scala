import sbt._

object SystemOfRecordBuild extends Build {
	Classpaths.typesafeResolver

	lazy val root = Project("system-of-record-universe", file(".")).aggregate(core)

	lazy val core = GdsProject("core")

}

object GdsProject {
	def apply(name: String) = Project(name, file(name))
}

object SprayProject {
	def apply(name: String) = GdsProject(name)
}