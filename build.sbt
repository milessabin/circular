import de.heikoseeberger.sbtheader.license.Apache2_0

lazy val buildSettings = List(
  organization := "com.adelbertc",
  licenses ++= List(
    ("Apache 2.0", url("https://www.apache.org/licenses/LICENSE-2.0")),
    ("BSD-Style" , url("https://opensource.org/licenses/BSD-3-Clause"))
  ),
  headers := Map(("scala" -> Apache2_0("2016", "Adelbert Chang"))),
  scalaVersion := "2.11.8",
  crossScalaVersions := List("2.10.6", scalaVersion.value),
  version := "0.1.0-SNAPSHOT"
)

lazy val commonSettings = List(
  scalacOptions ++= List(
    "-deprecation",
    "-encoding", "UTF-8",
    "-feature",
    "-language:existentials",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-unchecked",
    "-Xfatal-warnings",
    "-Xlint",
    "-Yno-adapted-args",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Ywarn-value-discard"
  ),
  resolvers += Resolver.sonatypeRepo("snapshots"),
  libraryDependencies ++= List(
    "io.argonaut"   %% "argonaut"    % "6.2-M3",
    "org.typelevel" %% "cats-core"   % "0.7.1-SNAPSHOT",
    "org.specs2"    %% "specs2-core" % "3.8.4"           % "test"
  )
)

lazy val circularSettings = buildSettings ++ commonSettings

lazy val circular =
  project.in(file(".")).
  settings(name := "circular").
  settings(description := "").
  settings(circularSettings)