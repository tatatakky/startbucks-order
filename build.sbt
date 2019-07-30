val defaultSetting = Seq(
  organization := "com.github.tatatakky",
  scalaVersion := "2.12.8"
)
lazy val akkaVersion = "2.5.23"
lazy val akkalibraryDependencies = Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test
)

lazy val scalaTestVersion = "3.0.8"
lazy val commonLibraryDependencies = Seq(
  "org.scalactic" %% "scalactic" % scalaTestVersion,
  "org.scalatest" %% "scalatest" % scalaTestVersion % "test"
)

lazy val akkadoc = (project in file("."))
  .settings(
    name := "starbucks-order-akka",
    defaultSetting,
    libraryDependencies ++= akkalibraryDependencies ++ commonLibraryDependencies
  )
