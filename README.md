# Paso 05 - Configuración con YAML

En este paso, se agrega la posibilidad de leer parámetros de configuración desde un archivo YAML.

## Archivos agregados

- `config.yaml`: Contiene parámetros simples como `keyspace`, `source_table`, `target_table`.
- `Main.scala`: Se actualiza para leer y mostrar el contenido del YAML usando `SnakeYAML`.
- `build.sbt`: Se añade dependencia a `org.yaml:snakeyaml`.

## Cómo probar

1. Asegúrese de tener `sbt` instalado.
2. Ejecute:

```bash
sbt run
```

Ahora se leen parámetros de configuración desde el archivo YAML.
