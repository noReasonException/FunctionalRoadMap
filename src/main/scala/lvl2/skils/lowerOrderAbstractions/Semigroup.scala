package lvl2.skils.lowerOrderAbstractions

import cats.data.NonEmptyList

//TypeClass
trait Semigroup[A] {
  def combine(left:A,right:A):A
}

object Semigroup{
  //SyntaxClass
  implicit class SemigroupSyntaxOps[A](left:A){
    def combine(right:A)(implicit semigroupImpl:Semigroup[A])=semigroupImpl.combine(left, right)
  }
}
object SemigroupInstances{
  implicit val semigroupStrInstance:Semigroup[String]=new Semigroup[String] {
    override def combine(left: String, right: String): String = left+right
  }
  implicit val semigroupIntAddInstance:Semigroup[Int]=new Semigroup[Int] {
    override def combine(left: Int, right: Int): Int = left+right
  }
}
object SemigroupMain{
  def main(args: Array[String]): Unit = {
    val listA = NonEmptyList(1,(2 to 200).toList)
    println(listA.reduceLeft(SemigroupInstances.semigroupIntAddInstance.combine)) //used the reduceLeft as this is cats-independent
  }
}
