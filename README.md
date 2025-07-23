# Paso 02 - Conexión con Spark + Cassandra

Este paso permite crear la SparkSession con Cassandra usando Apache Spark.

## Requisitos

- Spark 3.5.6
- Cassandra 4.1 accesible en `localhost:9042`

## Cómo probar

1. Asegúrese de tener una base de datos corriendo en `127.0.0.1`.
2. Ejecute:

```bash
sbt run
```

## Archivos

- `Main.scala`: ahora crea una SparkSession y conecta a Cassandra.
- `build.sbt`: ya incluye dependencias de Spark y Cassandra Connector.