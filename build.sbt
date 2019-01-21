name := "slick-demo"
version := "0.0.1-SNAPSHOT"
scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.2.1",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "com.h2database" % "h2" % "1.4.192"
)