package lvl3.higherOrderAbstractions

import cats.implicits._
object Applicative {
  //Option is applicative
  val maybeComputation1:Option[Int]=12.some
  val maybeComputation2:Option[Int]=42.some
  def main(args: Array[String]): Unit = {
    def add(x: Int, y: Int) = x + y

    //Applicativ'es way of expressing the combination
    val combinedApplicative: Option[Int] = (maybeComputation1, maybeComputation2).mapN(add)



    //Manual expression
    def mapN(option1: Option[Int], option2: Option[Int], fn: (Int, Int) => Int): Option[Int] = {
      val combinedManuallyStep1: Option[Int => Int] = option1.map(x => fn(x, _))
      val combineManuallyStep3: Option[Int] = (combinedManuallyStep1, option2) match {
        case (Some(fn1), Some(value)) => (fn1(value)).some
        case _ => None
      }
      combineManuallyStep3
    }

    println(combinedApplicative)
    println(mapN(maybeComputation1, maybeComputation2, add))


    //Cats impl vs mine is approx same(note the pattern matching)
    //Semigroupal -> map2 -> functor.map(semigroupal.product(f0, f1)) { case (a0, a1) => f(a0, a1) }
  }

}
