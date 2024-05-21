# RPI Mod

This is a tutorial mod for the Modding Basics workshop.


## Project structure

```yaml
├── .gitignore : test
├── build.gradle
├── common/
│   ├── build.gradle
│   └── src/
│       └── main/
│           ├── java/com/quatalog/rpimod/ : test
│           │   └── RPIMod.java 
│           └── resources/
│               └── rpimod.mixins.json
├── fabric/
│   ├── build.gradle
│   └── src/
│       └── main/
│           ├── java/com/quatalog/rpimod/fabric/ 
│           │   ├── RPIModFabric.java
│           │   └── client/
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
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradle.properties
├── gradlew
├── gradlew.bat
└── settings.gradle
```