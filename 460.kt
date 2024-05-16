class CacheNode(key: Int, value: Int, frequency: Int, time: Int) : Comparable<CacheNode> {
    var key = 0
    var value = 0
    var frequency = 0
    var time = 0

    init {
        this.key = key
        this.value = value
        this.frequency = frequency
        this.time = time
    }

    override fun compareTo(other: CacheNode): Int {
        return if (this.frequency != other.frequency) this.frequency - other.frequency else this.time - other.time
    }
}

class LFUCache(capacity: Int) {
    /*var head: Node? = null
    var tail: Node? = null*/
    //val values = HashMap<Int, Int>(capacity)
    val cacheMap = HashMap<Int, CacheNode>(capacity)
    val freqTree = TreeSet<CacheNode>()
    var capacity = 0
    var clock = 0

    init {
        this.capacity = capacity
    }

    fun get(key: Int): Int {
        if (!cacheMap.containsKey(key)) {
            return -1
        }
        val node = cacheMap.get(key)!!
        val value = node.value
        updateFreq(node)
        return value
    }

    fun put(key: Int, value: Int) {
        if (capacity == 0) {
            return
        }
        if (cacheMap.containsKey(key)) {
            //key exists: update value and updateFreq
            val node = cacheMap.get(key)!!
            node.value = value
            updateFreq(node)
            return
        }
        //if inserting item when cache is capacity,
        if (cacheMap.size == capacity) {
            //remove the first node in the tree,because it's least frequency or haven't been visited recently
            val first = freqTree.first()
            cacheMap.remove(first.key)
            freqTree.remove(first)
        }
        //create new node
        //clock++,represent in use this moment
        val node = CacheNode(key, value, 1, clock++)
        cacheMap.put(key, node)
        freqTree.add(node)
    }

    private fun updateFreq(node: CacheNode) {
        freqTree.remove(node)
        node.time = clock++
        node.frequency++
        freqTree.add(node)
    }
}
