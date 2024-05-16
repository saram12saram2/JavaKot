type CacheNode struct {
	key       int
	value     int
	frequency int
	time      int
	index     int
}

type CacheHeap []*CacheNode

func (h CacheHeap) Len() int { return len(h) }
func (h CacheHeap) Less(i, j int) bool {
	return h[i].frequency < h[j].frequency || (h[i].frequency == h[j].frequency && h[i].time < h[j].time)
}
func (h CacheHeap) Swap(i, j int) { h[i], h[j] = h[j], h[i]; h[i].index, h[j].index = i, j }

func (h *CacheHeap) Push(x interface{}) {
	n := len(*h)
	node := x.(*CacheNode)
	node.index = n
	*h = append(*h, node)
}

func (h *CacheHeap) Pop() interface{} {
	old := *h
	n := len(old)
	node := old[n-1]
	node.index = -1 // for safety
	*h = old[0 : n-1]
	return node
}

func (h *CacheHeap) update(node *CacheNode, value int, time int) {
	node.value = value
	node.frequency++
	node.time = time
	heap.Fix(h, node.index)
}

type LFUCache struct {
	capacity  int
	clock     int
	cacheMap  map[int]*CacheNode
	cacheHeap CacheHeap
}

func Constructor(capacity int) LFUCache {
	h := make(CacheHeap, 0, capacity)
	return LFUCache{
		capacity:  capacity,
		clock:     0,
		cacheMap:  make(map[int]*CacheNode),
		cacheHeap: h,
	}
}

func (this *LFUCache) Get(key int) int {
	if node, found := this.cacheMap[key]; found {
		this.cacheHeap.update(node, node.value, this.clock)
		this.clock++
		return node.value
	}
	return -1
}

func (this *LFUCache) Put(key int, value int) {
	if this.capacity == 0 {
		return
	}
	if node, found := this.cacheMap[key]; found {
		this.cacheHeap.update(node, value, this.clock)
		this.clock++
		return
	}
	if len(this.cacheMap) == this.capacity {
		node := heap.Pop(&this.cacheHeap).(*CacheNode)
		delete(this.cacheMap, node.key)
	}
	node := &CacheNode{key: key, value: value, frequency: 1, time: this.clock}
	this.cacheMap[key] = node
	heap.Push(&this.cacheHeap, node)
	this.clock++
}

