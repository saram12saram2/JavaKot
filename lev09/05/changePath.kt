fun main() {
    val path = "/usr/java/jdk1.8/bin"
    val jdk13 = "jdk-13"
    println(changePath(path, jdk13)) 
}

fun changePath(path: String, jdk: String): String {
    val firstIndex = path.indexOf("jdk")

    val lastIndex = path.indexOf("/", firstIndex)

    // Extract the old JDK substring from the path
    val oldJdk = path.substring(firstIndex, lastIndex)

    // Replace the old JDK version in the path with the new JDK version
    return path.replace(oldJdk, jdk)
}



// output:      /usr/java/jdk-13/bin
