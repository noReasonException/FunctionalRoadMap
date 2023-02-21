package lvl2.skils.lowerOrderAbstractions

import cats.data.NonEmptyList

trait Monoid[A] extends Semigroup[A]{
  def empty:A
}

object Monoid{
  //Syntax class cannot be defined
  def apply[A:Monoid](): Monoid[A] = implicitly[Monoid[A]]
}
object MonoidInstances{
  implicit def monoidIntImpl(semigroupIntImpl:Semigroup[Int]):Monoid[Int]=new Monoid[Int] {
    override def empty: Int = 0
    override def combine(left: Int, right: Int): Int = semigroupIntImpl.combine(left, right)
  }
}
object MonoidMain{
  import SemigroupInstances.semigroupIntAddInstance
  import MonoidInstances.monoidIntImpl
  def main(args: Array[String]): Unit = {
    val listA = NonEmptyList(1,(2 to 200).toList)


    //println(listA.foldLeft(Monoid.apply[Int].empty)(SemigroupInstances.semigroupIntAddInstance.combine)) //used the reduceLeft as this is cats-independent
  }
}