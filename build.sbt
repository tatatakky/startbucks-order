val defaultSetting = Seq(
  organization := "com.github.tatatakky",
  scalaVersion := "2.12.8"
)
lazy val akkaVersion = "2.5.23"
lazy val akkalibraryDependencies = Seq(
  "com.typesafe.akka"       %%  "akka-actor"   % akkaVersion
)
lazy val akkadoc = (project in file("."))
  .settings(
    name := "starbucks-order-akka",
    defaultSetting,
    libraryDependencies ++= akkalibraryDependencies
  )
