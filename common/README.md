# Common

This is the common subproject. It contains the subproject's build file, `build.gradle` as well as all of the common code and resources in `src`. 

This code will be used in both the `fabric` and `forge` subprojects/jars, so it has access to neither of their APIs. Instead you'll need a common API that has implementations for each loader, such as Architectury API. 

### DIY Common API tips

If you choose not to use Architectury API or find something it doesn't cover, then you'll need to make your own API-ish thing, or just implement your feature for each loader. 

I've grown quite fond of the Botania `IXPlatAbstractions` style. The basic idea is to have some interface in common, `IXPlatWhatever` with all the methods you need to call, and then implementations of this interface in each loader, so some classes `FabricXPlatWhatever` and `ForgeXPlatWhatever`. Then when the sided code is initialized, it can give an instance of its implementation to common. In the simplest form this is just a static field of type `IXPlatWhatever` somewhere in your common code that then gets assigned to the loader specific implementation from the loader code. 

There's also the `@ExpectPlatform` annotation from Architectury, but I find that it just makes the code more confusing to follow.