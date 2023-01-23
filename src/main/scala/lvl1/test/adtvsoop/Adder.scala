package lvl1.test.adtvsoop

abstract class Adder[A] {
  protected var state:A
  def op(add:A):Unit
  def result:A=state
}

class IntegerAdder extends Adder[Int]{
  override var state: Int = 0
  override def op(add: Int): Unit = state+add

}
