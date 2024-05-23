# RPI Mod

This is a tutorial Minecraft mod for the Modding Basics workshop. All of the files are commented with descriptions and other helpful notes. Many directories also have a README describing their contents, with most of the helpful info in `common`, just to avoid redundancy.

It was generated using https://generate.architectury.dev/. I recommend using that for generating your own project. 

## How to use

You can either clone the repo or just download the zip. Or you could just view the code here on Github, whichever you prefer.

Make sure you have Java 17 installed

You should generate Minecraft's source code if you'd like to be able to poke around at it.

You can use these commands depending on what you want to do:

### Mac/Linux:
In the command line:
- Run fabric test client: `./gradlew fabric:runclient`
- Run fabric test server: `./gradlew fabric:runserver`
- Generate Minecraft source code for viewing in IDE: `./gradlew gensources`
- Build fabric jar: `./gradlew fabric:build`
  - you can then find the jar in `fabric/build/libs/`

For forge, same as above but replace `fabric` with `forge`.

### Wndows: 
Same as above but using `gradlew.bat` instead of `./gradlew`

## Project structure

```yaml
├── .gitignore :
├── build.gradle : project build file
├── common/ : common subproject
│   ├── build.gradle : common subproject build file
│   └── src/ :
│       └── main/ : all your common stuff goes here
│           ├── java/com/quatalog/rpimod/ : code goes here
│           │   ├── client/ : client code here
│           │   │   └── RPIModClient.java : common client setup
│           │   └── RPIMod.java : common setup
│           └── resources/ : assets and data go here
│               ├── assets/ : client resources (assets) go here
│               ├── data/ : server resources (data) go here
│               └── rpimod.mixins.json : define common mixins here
├── fabric/ : fabric subproject
│   ├── build.gradle : fabric subproject build file
│   └── src/ :
│       └── main/ :
│           ├── java/com/quatalog/rpimod/fabric/ : fabric specific code goes here
│           │   ├── RPIModFabric.java : fabric setup & entrypoint
│           │   └── client/ : fabric client code goes here
│           │       └── RPIModFabricClient.java : fabric client setup & entrypoint
│           └── resources/ : fabric specific resources, not usually used much
│               └── fabric.mod.json : metadata-ish about your mod for fabric
├── forge/ : forge subproject
│   ├── build.gradle : forge subproject build file
│   ├── gradle.properties :
│   └── src/ :
│       └── main/ :
│           ├── java/com/quatalog/rpimod/forge/ : forge specific code goes here
│           │   ├── client/ : client code here
│           │   │   └── RPIModForgeClient.java : forge client setup & entrypoint-ish
│           │   └── RPIModForge.java : forge setup & entrypoint
│           └── resources/ : forge specific resources, again, not used much
│               ├── META-INF/ :
│               │   └── mods.toml : metadata-ish about your mod for forge
│               └── pack.mcmeta :
├── gradle/wrapper/ : makes gradle exist
│   ├── gradle-wrapper.jar :
│   └── gradle-wrapper.properties :
├── gradle.properties : properties that the gradle build files use
├── gradlew : for running gradle on linux/mac
├── gradlew.bat : for running gradle on windows
└── settings.gradle :
```