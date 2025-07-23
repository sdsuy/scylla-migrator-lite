package migrator

import org.apache.spark.sql.SparkSession

object Main {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("Scylla Migrator Lite")
      .master("local[*]") // usa todos los núcleos disponibles
      .config("spark.cassandra.connection.host", "127.0.0.1")
      .config("spark.cassandra.connection.port", "9042")
      .getOrCreate()

    import spark.implicits._

    println("✔ Conectando a Cassandra y leyendo tabla demo.usuarios...")

    val df = spark.read
      .format("org.apache.spark.sql.cassandra")
      .options(Map("table" -> "usuarios", "keyspace" -> "demo"))
      .load()

    df.show()

    spark.stop()
  }
}
