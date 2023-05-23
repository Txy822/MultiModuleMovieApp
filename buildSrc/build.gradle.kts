plugins {
    `kotlin-dsl`
}
repositories {
//    we can use all of them to make sure we have access all dependancies and plugins
    //mavenCentral() // more generic and widely used,  we can use this
   // google() //or more specific android and provided by google
    gradlePluginPortal() // more specific

}