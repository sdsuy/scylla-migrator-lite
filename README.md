# Paso 04 - Escritura en tabla de destino

Este paso extiende el anterior leyendo datos de `usuarios` y escribiéndolos en `usuarios_migrados`.

## Cómo probar

1. Asegúrese de que la tabla `usuarios_migrados` exista en Cassandra con el mismo esquema que la original.
2. Ejecute:

```bash
sbt run
```

## Resultado

Se migran los datos de `usuarios` a `usuarios_migrados` usando Spark.
