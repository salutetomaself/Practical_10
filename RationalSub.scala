class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator must not be zero")

  private val g = gcd(n.abs, d.abs)
  val numerator: Int = n / g
  val denominator: Int = d / g

  def this(n: Int) = this(n, 1)

  def neg: Rational = new Rational(-numerator, denominator)

  def add(that: Rational): Rational = 
    new Rational(
      numerator * that.denominator + that.numerator * denominator, 
      denominator * that.denominator
    )

  def sub(that: Rational): Rational = 
    new Rational(
      numerator * that.denominator - that.numerator * denominator, 
      denominator * that.denominator
    )

  def mul(that: Rational): Rational = 
    new Rational(numerator * that.numerator, denominator * that.denominator)

  def div(that: Rational): Rational = 
    new Rational(numerator * that.denominator, denominator * that.numerator)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  override def toString: String = s"$numerator/$denominator"
}

object RationalTest extends App {
 
  val x = new Rational(3, 4)
  val y = new Rational(5, 8)
  val z = new Rational(2, 7)

  val result = x.sub(y.sub(z))

  println(s"Result of x - (y - z): $result")
}
