name := """play-scala-react-seed"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    watchSources ++= (baseDirectory.value / "public/ui" ** "*").get
  )
lazy val root = (project in file("."))
  .enablePlugins(PlayScala, SwaggerPlugin) //enable plugin

resolvers += Resolver.sonatypeRepo("snapshots")

scalaVersion := "2.13.10"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test

addCommandAlias(
  "validateCode",
  "scalafmtSbtCheck; scalafmtCheckAll; uiCodeStyleCheck"
)

addSbtPlugin("com.iheart" % "sbt-play-swagger" % "0.11.0")
swaggerDomainNameSpaces := Seq("models")
