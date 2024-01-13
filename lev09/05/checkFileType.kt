// checks the file type based on its extension.

fun main() {
    print("Enter a file path: ")
    val path = readLine()

    if (path != null) {
        if (path.endsWith(".jpg") || path.endsWith(".jpeg")) {
            println("This is a jpeg!")
        } else if (path.endsWith(".htm") || path.endsWith(".html")) {
            println("This is an HTML page")
        } else if (path.endsWith(".doc") || path.endsWith(".docx")) {
            println("This is a Word document")
        } else {
            println("Unknown format")
        }
    }
}
