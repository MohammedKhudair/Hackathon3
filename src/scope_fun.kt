import kotlin.math.roundToInt

data class Product(
    val name: String,
    val price: Double,
    val discount: Double
)

fun Product.calculateDiscountPrice(): Double =
    (price - (price * discount / 100)).roundToInt().toDouble()

/**
 * Entry point of the application.
 *
 * Demonstrates the creation of a `Product` instance and calculates its discounted price
 * using the `run` scope function. Outputs the product details, including name, original price,
 * discount percentage, and the final price after applying the discount.
 */
fun main() {
    val product = Product("Laptop", 1000.0, 15.0)

    product.run {
        println("Product: $name")
        println("Original price: $price")
        println("Discount: $discount%")
        println("Final price: ${calculateDiscountPrice()}")
    }
}
   

