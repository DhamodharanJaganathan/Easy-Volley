# Easy-Volley

Volley is an HTTP library that makes networking for Android apps easier and, most importantly, faster.

## Add as dependency
This library is not yet released in Maven Central, until then you can add as a library module or use JitPack.io

add remote maven url

```groovy

    allprojects {
        repositories {
            maven {
                url "https://jitpack.io"
            }
        }
    }
```
    
then add a library dependency. **Remember** to check for latest release [here](https://github.com/scottyab/showhidepasswordedittext/releases) 
                             
```groovy
    dependencies {
        compile 'com.github.DhamodharanJaganathan:Easy-Volley:1.0.0'
    }
```
