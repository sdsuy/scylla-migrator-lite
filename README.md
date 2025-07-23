# Paso 03 - Leer tabla en Cassandra desde Spark (Scala)

Este paso permite leer una tabla usuarios en Cassandra usando Apache Spark.

## Requisitos

- Spark 3.5.6
- Cassandra 4.1 accesible en `localhost:9042`
- Keyspace `demo` y tabla `usuarios`

## Cómo probar

1. Asegúrese de tener una base de datos corriendo en `127.0.0.1`.
2. Verifique que exista el `keyspace` y `source_table`.
3. Ejecute:

```bash
sbt run
```

## Archivos

- `Main.scala`: ahora lee una tabla desde Cassandra usando una SparkSession.