// Scope_funKtTest.kt
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Test class for validating the calculateDiscountPrice function in the Product class.
 *
 * The calculateDiscountPrice method calculates the discounted price of a product by applying
 * the provided discount percentage. The result is rounded to the nearest whole number.
 */
class Scope_funKtTest {

    @Test
    fun `calculateDiscountPrice should calculate correct price with 15 percent discount`() {
        val product = Product(name = "Laptop", price = 1000.0, discount = 15.0)

        val result = product.calculateDiscountPrice()

        assertEquals(850.0, result)
    }

    @Test
    fun `calculateDiscountPrice should calculate correct price with 50 percent discount`() {
        val product = Product(name = "Headphones", price = 200.0, discount = 50.0)

        val result = product.calculateDiscountPrice()

        assertEquals(100.0, result)
    }

    @Test
    fun `calculateDiscountPrice should calculate correct price with 0 percent discount`() {
        val product = Product(name = "Mouse", price = 50.0, discount = 0.0)

        val result = product.calculateDiscountPrice()

        assertEquals(50.0, result)
    }

    @Test
    fun `calculateDiscountPrice should return 0 when product price is 0`() {
        val product = Product(name = "Keyboard", price = 0.0, discount = 10.0)

        val result = product.calculateDiscountPrice()

        assertEquals(0.0, result)
    }

    @Test
    fun `calculateDiscountPrice should calculate correct price for large discount`() {
        val product = Product(name = "Tablet", price = 1000.0, discount = 99.0)

        val result = product.calculateDiscountPrice()

        assertEquals(10.0, result)
    }

    @Test
    fun `calculateDiscountPrice should calculate correct price for very small discount`() {
        val product = Product(name = "Monitor", price = 500.0, discount = 0.5)

        val result = product.calculateDiscountPrice()

        assertEquals(498.0, result)
    }
}