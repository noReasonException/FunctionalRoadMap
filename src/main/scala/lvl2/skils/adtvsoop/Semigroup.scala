package lvl2.adtvsoop

trait Semigroup[A] {
  val element:A
  def combine(rightNumber:Semigroup[A]):Semigroup[Int]
}

case class IntegerImpl(i:Int) extends Semigroup[Int]{
  override val element: Int = i
  override def combine(rightNumber: Semigroup[Int]): Semigroup[Int] = IntegerImpl(i+rightNumber.element)
}



