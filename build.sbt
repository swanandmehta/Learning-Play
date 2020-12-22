name := """play-java-hello-world-tutorial"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.1"

libraryDependencies += guice
libraryDependencies += javaJpa
libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.22"
libraryDependencies += "org.hibernate" % "hibernate-core" % "5.4.9.Final" // replace by your jpa implementation
libraryDependencies += javaWs % "test"

PlayKeys.externalizeResourcesExcludes += baseDirectory.value / "conf" / "META-INF" / "persistence.xml"


