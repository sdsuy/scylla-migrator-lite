ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.16"

lazy val root = (project in file("."))
  .settings(
    name := "scylla-migrator-lite"
  )

libraryDependencies += "org.apache.spark" %% "spark-core" % "3.5.6"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.5.6" // % "provided"
libraryDependencies += "com.datastax.spark" %% "spark-cassandra-connector" % "3.5.1"
