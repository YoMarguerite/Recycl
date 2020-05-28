package com.example.recyclappli.ui.company

class Receiver {

    lateinit var items: Array<Company>
    var hasMore: Boolean = false
    var limit: Int = 0
    var offset: Int = 0
    var count: Int = 0
    lateinit var links: List<Link>

    class Link{
        var rel: String = ""
        var href: String = ""
    }
}