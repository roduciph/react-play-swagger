name := """play-scala-react-seed"""

version := "1.0-SNAPSHOT"
scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala, SwaggerPlugin)
  .settings(
    watchSources ++= (baseDirectory.value / "public/ui" ** "*").get
  )

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test
// libraryDependencies += "org.webjars" % "swagger-ui" % "2.2.0" // play-swagger ui integration

addCommandAlias(
  "validateCode",
  "scalafmtSbtCheck; scalafmtCheckAll; uiCodeStyleCheck"
)

swaggerDomainNameSpaces := Seq("models")
