package migrator

import org.yaml.snakeyaml.Yaml

import java.io.InputStream
import scala.jdk.CollectionConverters.MapHasAsScala

case class SourceConfig(keyspace: String, table: String)
case class TargetConfig(keyspace: String, table: String)
case class CassandraConfig(host: String, port: Int)
case class AppConfig(source: SourceConfig, target: TargetConfig, cassandra: CassandraConfig)

object ConfigLoader {
  def load(fileName: String): AppConfig = {
    val input: InputStream = getClass.getClassLoader.getResourceAsStream(fileName)
    val yaml = new Yaml()
    val data = yaml.loadAs(input, classOf[java.util.Map[String, Object]]).asScala

    def toMap(map: Any): Map[String, Any] =
      map.asInstanceOf[java.util.Map[String, Object]].asScala.toMap

    val sourceMap = toMap(data("source"))
    val targetMap = toMap(data("target"))
    val cassandraMap = toMap(data("cassandra"))

    AppConfig(
      SourceConfig(
        sourceMap("keyspace").toString,
        sourceMap("table").toString
      ),
      TargetConfig(
        targetMap("keyspace").toString,
        targetMap("table").toString
      ),
      CassandraConfig(
        cassandraMap("host").toString,
        cassandraMap("port").toString.toInt
      )
    )
  }
}
