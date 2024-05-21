# RPI Mod

This is a tutorial mod for the Modding Basics workshop.

It was generated using https://generate.architectury.dev/. I recommend using that for generating your own project. 

## Project structure

```yaml
├── .gitignore :
├── build.gradle : project build file
├── common/ : common subproject
│   ├── build.gradle : common subproject build file
│   └── src/ :
│       └── main/ : all your common stuff goes here
│           ├── java/com/quatalog/rpimod/ : code goes here
│           │   └── RPIMod.java : common entrypoint-ish
│           └── resources/ : assets and data go here
│               └── rpimod.mixins.json : define common mixins here
├── fabric/ : fabric subproject
│   ├── build.gradle : fabric subproject build file
│   └── src/ :
│       └── main/ :
│           ├── java/com/quatalog/rpimod/fabric/ : fabric specific code goes here
│           │   ├── RPIModFabric.java : fabric entrypoint
│           │   └── client/ : fabric client code goes here
│           │       └── RPIModFabricClient.java
│           └── resources/
│               └── fabric.mod.json
├── forge/
│   ├── build.gradle
│   ├── gradle.properties
│   └── src/
│       └── main/
│           ├── java/com/quatalog/rpimod/forge/
│           │   └── RPIModForge.java
│           └── resources/
│               ├── META-INF/
│               │   └── mods.toml
│               └── pack.mcmeta
├── gradle/wrapper/ : makes gradle exist
│   ├── gradle-wrapper.jar
│   └── gradle-wrapper.properties
├── gradle.properties : properties that the gradle build files use
├── gradlew : for running gradle on linux/mac
├── gradlew.bat : for running gradle on windows
└── settings.gradle :
```