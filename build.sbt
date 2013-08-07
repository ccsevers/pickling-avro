organization in ThisBuild := "io.topology"

name := "pickling-avro"

version := "0.1.0-SNAPSHOT"

scalaVersion in ThisBuild := "2.10.2"

resolvers += "OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies in ThisBuild ++= Seq(
  "org.scala-lang" %% "scala-pickling" % "0.8.0-SNAPSHOT",
  "ch.qos.logback" % "logback-classic" % "1.0.9",
  "org.scalatest" %% "scalatest" % "2.0.M5b" % "test"
)

scalacOptions in (ThisBuild, Compile) ++= Seq(
  "-unchecked",
  "-deprecation",
  "-feature"
)

parallelExecution in (ThisBuild, Test) := false
