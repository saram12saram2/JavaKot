fun main() {
    val urls = arrayOf("https://javarush.us", "https://google.com", "http://wikipedia.org", "facebook.com", "https://instagram", "codegym.cc")
    for (url in urls) {
        val protocol = checkProtocol(url)
        val domainExtension = checkDomainExtension(url)

        println("URL address: $url, network protocol - $protocol, domain extension - $domainExtension")
    }
}

fun checkProtocol(url: String): String {
    return when {
        url.startsWith("https") -> "https"
        url.startsWith("http") -> "http"
        else -> "unknown"
    }
}

fun checkDomainExtension(url: String): String {
    return when {
        url.endsWith("com") -> "com"
        url.endsWith("net") -> "net"
        url.endsWith("org") -> "org"
        url.endsWith("us") -> "us"
        else -> "unknown"
    }
}

/*
URL address: https://javarush.us, network protocol - https, domain extension - us
URL address: https://google.com, network protocol - https, domain extension - com
URL address: http://wikipedia.org, network protocol - http, domain extension - org
URL address: facebook.com, network protocol - unknown, domain extension - com
URL address: https://instagram, network protocol - https, domain extension - unknown
URL address: codegym.cc, network protocol - unknown, domain extension - unknown
*/