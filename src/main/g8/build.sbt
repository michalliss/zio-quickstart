val zioVersion = "2.0.3"

lazy val root = project
  .in(file("."))
  .settings(
    inThisBuild(
      List(
        name := "$name$",
        organization := "$organization$",
        version := "0.0.1",
        scalaVersion := "$dotty_version$"
      )
    ),
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % zioVersion,
      "io.getquill" %% "quill-jdbc-zio" % "4.1.1-SNAPSHOT",
      "org.postgresql" % "postgresql" % "42.3.1",
      "io.github.scottweaver" %% "zio-2-0-testcontainers-postgresql" % "0.9.0",
      "com.github.sideeffffect" %% "zio-testcontainers" % "0.4.1",
      "dev.zio" %% "zio-test" % zioVersion % Test,
      "dev.zio" %% "zio-test-sbt" % zioVersion % Test,
      "dev.zio" %% "zio-test-junit" % zioVersion % Test,
      "dev.zio" %% "zio-test-magnolia" % zioVersion % Test
    ),
    testFrameworks := Seq(new TestFramework("zio.test.sbt.ZTestFramework"))
  )
