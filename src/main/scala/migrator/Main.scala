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

    println("✔ SparkSession creada correctamente.")
    println(s"✔ Versión de Spark: ${spark.version}")

    // Espera para ver logs si estás corriendo en entorno standalone
    Thread.sleep(2000)

    spark.stop()
  }
}
