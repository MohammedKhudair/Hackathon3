fun findMissingRanges(frames: List<Int>): Map<String, Any?> {
    if (frames.isEmpty()) {
        return mapOf(
            "gaps" to emptyList<List<Int>>(),
            "longest_gap" to null,
            "missing_count" to 0
        )
    }

    // Step 1: Find max frame number
    var maxFrame = 0
    for (f in frames) {
        if (f > maxFrame) maxFrame = f
    }

    // Step 2: Mark received frames
    val received = BooleanArray(maxFrame + 1)
    for (f in frames) {
        if (f > 0) received[f] = true
    }

    val gaps = mutableListOf<List<Int>>()
    var missingCount = 0
    var longestGap: List<Int>? = null
    var longestGapSize = 0

    // Step 3: Traverse to detect missing ranges
    // Find all missing frame ranges in a simple, readable way
    var i = 1
    while (i <= maxFrame) {
        if (!received[i]) {
            val start = i
          // Move i forward until we find a received frame or reach the end
            while (i < maxFrame && !received[i + 1]) {
                i++
            }
            val end = i
            gaps.add(listOf(start, end))

            val size = end - start + 1
            missingCount += size
            if (size > longestGapSize) {
                longestGapSize = size
                longestGap = listOf(start, end)
            }
        }
        i++
    }

    return mapOf(
        "gaps" to gaps,
        "longest_gap" to longestGap,
        "missing_count" to missingCount
    )
}

// ------------------ Test ------------------
fun main() {
    val frames = listOf(1, 2, 3, 5, 6, 10, 11, 16)
    val result = findMissingRanges(frames)
    println(result)
}
