 // Top-level build file where you can add configuration options common to all sub-projects/modules.

 buildscript{
     dependencies {
         classpath ("org.jetbrains.kotlin:kotlin-serialization:1.6.21")

     }
 }

 plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false

}