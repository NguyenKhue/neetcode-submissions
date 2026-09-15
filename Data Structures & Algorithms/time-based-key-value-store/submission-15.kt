class TimeMap() {
    init {
        // println("${search(listOf(1,2,3,5,6,7,8), 4)} -> expect 3")
        // println("${search(listOf(1,2,3,5,6,7,8), 9)} -> expect 8")
        // println("${search(listOf(1,2,3,5,6,7,8), 0)} -> expect null")
        // println("${search(listOf(1,2,3,5,6,7,8), 6)} -> expect 6")
        // println("${search(listOf(1,2,3,5,6,7,8), 2)} -> expect 2")
        // println("${search(listOf(5), 5)} -> expect 5")
        // println("${search(listOf(5), 4)} -> expect null")
        // println("${search(listOf(5, 6), 5)} -> expect 5")
        // println("${search(listOf(1, 3, 5, 7), 4)} -> expect 3")
        // println("${search(listOf(1, 2, 4, 5, 6), 2)} -> expect 2")
    }
    
    val map = mutableMapOf<String, MutableMap<Int, String>>()

    fun set(key: String, value: String, timestamp: Int) {
        map.getOrPut(key) {
            mutableMapOf()
        }.put(timestamp, value)
    }

    fun get(key: String, timestamp: Int): String {
        val value = map.get(key) ?: return ""

        val time = search(value.keys.toList(), timestamp) ?: return ""
        
        return value.get(time) ?: ""
    }

    fun search(times: List<Int>, time: Int): Int? {
        if(time < times[0]) return null
        if(time >= times[times.size - 1]) return times[times.size - 1]

        var l = 0
        var r = times.size - 1

        while(l <= r) {
            val mid = l + (r - l)/2

            if(time == times[mid]) return time

            if(time > times[mid]) {
                val nextTimeIndex = mid + 1

                if(nextTimeIndex == times.size || 
                    time < times[nextTimeIndex]) return times[mid]

                l = mid + 1
            } else r = mid - 1
        }

        return null
    }
}
