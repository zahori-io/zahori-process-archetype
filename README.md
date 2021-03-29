# Guía Rápida zahori-process-archetype

Parámetros de entrada:

| Campo | Descripción |
| ------ | ------ |
| groupId | groupId personalizado que tendrá el proceso |
| artifactId | artifactId personalizado que tendrá el proceso |
| version | version personalizado que tendrá el proceso |


Para crear un nuevo proceso cambia los valores con prefijo tu* con tus valores personalizados y ejecuta:

```sh
mvn archetype:generate -DarchetypeGroupId=io.zahori \
                       -DarchetypeArtifactId=zahori-process-archetype \
                       -DarchetypeVersion=1.0.0 \
                       -DgroupId=tugroupid \
                       -DartifactId=tuartifactid \
                       -Dversion=tuversion-SNAPSHOT
```

Un ejemplo sería el siguiente:

```sh
mvn archetype:generate -DarchetypeGroupId=io.zahori \
-DarchetypeArtifactId=zahori-process-archetype \
-DarchetypeVersion=1.0.0 \
-DgroupId=es.panel.cellst.zahori \
-DartifactId=process-example \
-Dversion=1.0.0-SNAPSHOT
```

