# Guía Rápida zahori-process-archetype

Parámetros de entrada:

| Campo | Descripción |
| ------ | ------ |
| groupId | groupId personalizado que tendrá el proceso |
| artifactId | artifactId personalizado que tendrá el proceso |
| version | version personalizado que tendrá el proceso |


Para crear un nuevo proceso cambia los valores marcados con "<your_...>" y escribe tus valores personalizados y ejecuta:

```sh
mvn archetype:generate -DarchetypeGroupId=io.zahori -DarchetypeArtifactId=zahori-process-archetype -DarchetypeVersion=1.0.20 -DgroupId=<your_groupId> -DartifactId=<your_artifactid> -Dversion=<your_version>
```

Un ejemplo sería el siguiente:

```sh
mvn archetype:generate -DarchetypeGroupId=io.zahori -DarchetypeArtifactId=zahori-process-archetype -DarchetypeVersion=1.0.20 -DgroupId=my.domain.zahori -DartifactId=process-example -Dversion=1.0.0-SNAPSHOT
```

