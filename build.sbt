ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"


libraryDependencies += "org.typelevel" %% "cats-effect" % "3.4.5"

lazy val root = (project in file("."))
  .settings(
    name := "FunctionalRoadMap"
  )
