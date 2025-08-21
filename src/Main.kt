fun calculateDiscountPrice(price: Double, discount: Double): Double {
    return price - (price * discount / 100)
}

// Returns the discount percentage associated with a redeem code.
// Unknown or invalid codes return 0.0 (no discount).
fun redeemCode(code: String): Double {
    return when (code.trim().uppercase()) {
        "SAVE10" -> 10.0
        "SAVE20" -> 20.0
        "SAVE40" -> 40.0
        "WELCOME5" -> 5.0
        "VIP30" -> 30.0
        else -> 0.0
    }
}

// Example usage
fun main() {
    val code = "SAVE10"
    val discount = redeemCode(code)
    val priceWithCode = calculateDiscountPrice(price = 70.0, discount = discount)
    println("The price after applying code '$code' is: $priceWithCode")
}
