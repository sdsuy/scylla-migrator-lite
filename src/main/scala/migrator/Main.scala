package migrator

import org.apache.spark.sql.SparkSession

object Main {
  def main(args: Array[String]): Unit = {
    val config = ConfigLoader.load("config.yaml")

    val spark = SparkSession.builder()
      .appName("Scylla Migrator Lite")
      .master("local[*]") // usa todos los núcleos disponibles
      .config("spark.cassandra.connection.host", config.cassandra.host)
      .config("spark.cassandra.connection.port", config.cassandra.port.toString)
      .getOrCreate()

    import spark.implicits._

    println(s"✔ Conectando a Cassandra y leyendo desde ${config.source.keyspace}.${config.source.table}...")

    val df = spark.read
      .format("org.apache.spark.sql.cassandra")
      .options(Map(
        "table" -> config.source.table,
        "keyspace" -> config.source.keyspace
      ))
      .load()

    df.show()

    println(s"➡ Migrando datos hacia ${config.target.keyspace}.${config.target.table}...")

    df.write
      .format("org.apache.spark.sql.cassandra")
      .options(Map(
        "table" -> config.target.table,
        "keyspace" -> config.target.keyspace
      ))
      .mode("APPEND")
      .save()

    println("✅ Migración completada.")

    spark.stop()
  }
}
