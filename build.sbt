lazy val root = (project in file(".")).
  settings(
    name := "min-triangle-path",
    version := "1.0",
    scalaVersion := "2.13.5",
    mainClass in Compile := Some("kmeshkov.MinTrianglePath"),
    mainClass in assembly := Some("kmeshkov.MinTrianglePath")
  )

assemblyJarName in assembly := "MinTrianglePath.jar"