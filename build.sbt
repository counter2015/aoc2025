val scala3Version = "3.7.4"

lazy val root = project
  .in(file("."))
  .settings(
    name := "aoc2025",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0" % Test,

    scalacOptions ++= Seq(
      "-unchecked",
      "-feature", // Emit warning and location for usages of features that should be imported explicitly.
      "-deprecation", // Emit warning and location for usages of deprecated APIs.
      "-encoding",
      "utf-8", // Specify character encoding used by source files.
      "-explaintypes", // Explain type errors in more detail.
      "-Wunused:all"
    )
  )

scalafmtOnCompile := true
scalafixOnCompile := true
semanticdbEnabled := true

Global / onChangedBuildSource := ReloadOnSourceChanges
