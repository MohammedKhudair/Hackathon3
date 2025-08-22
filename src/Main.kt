fun findMissingRanges(frames: List<Int>): Map<String, Any?> {
    // Handle empty input case with default values
    if (frames.isEmpty()) {
        return mapOf(
            "gaps" to emptyList<List<Int>>(),
            "longest_gap" to null,
            "missing_count" to 0
        )
    }

    // Step 1: Find max frame number
    var maxFrame = 0
    for (frame in frames) {
        if (frame > maxFrame) maxFrame = frame
    }

    // Step 2: // Create a boolean array to track received frames (index 0 is unused since frames start at 1)
    val received = BooleanArray(maxFrame + 1)
    for (frame in frames) {
        if (frame > 0) received[frame] = true
    }

 // Initialize variables to store:
// - gaps: list of all missing frame ranges, each range as [start, end]
// - missingCount: total number of missing frames
// - longestGap: range of the largest continuous missing frames sequence
// - longestGapSize: size of the longest gap

    val gaps = mutableListOf<List<Int>>()
    var missingCount = 0
    var longestGap: List<Int>? = null
    var longestGapSize = 0

    // Step 3: Traverse to detect missing ranges
    // Find all missing frame ranges in a simple, readable way
   var frameIndex = 1
    while (frameIndex <= maxFrame) {
        if (!received[frameIndex]) {
            val start = frameIndex
            // Move frameIndex forward until we find a received frame or reach the end
            while (frameIndex < maxFrame && !received[frameIndex + 1]) {
                frameIndex++
            }
            val end = frameIndex
            gaps.add(listOf(start, end))

            val size = end - start + 1
            missingCount += size
            if (size > longestGapSize) {
                longestGapSize = size
                longestGap = listOf(start, end)
            }
        }
        frameIndex++
    }

    return mapOf(
        "gaps" to gaps,
        "longest_gap" to longestGap,
        "missing_count" to missingCount
    )
}

// ------------------------------------
fun main() {
    val frames = listOf(1, 2, 3, 5, 6, 10, 11, 16)
    val result = findMissingRanges(frames)
    println(result)
}
