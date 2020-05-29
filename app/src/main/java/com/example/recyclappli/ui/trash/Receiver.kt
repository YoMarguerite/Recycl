package com.example.recyclappli.ui.trash

class Receiver {

    lateinit var items: Array<Trash>
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