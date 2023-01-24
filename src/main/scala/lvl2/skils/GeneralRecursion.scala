package lvl2.skils

import cats.Functor
import cats.implicits._

//Target - Write a Functor for a Binary tree

//First thing, Define the binary tree
sealed trait BTree[A]
case class Branch[A](left:BTree[A],right:BTree[A]) extends BTree[A]
case class Leaf[A](value:A) extends BTree[A]

//Secondly, Define a Cats-Compatible Functor
object BTree{
  implicit val bTreeFunctor:Functor[BTree] = new Functor[BTree] {
    override def map[A, B](fa: BTree[A])(f: A => B): BTree[B] = fa match {
      case Branch(left, right) => Branch(map(right)(f),map(left)(f))
      case Leaf(value) => Leaf(f(value))
    }
  }
}


object GeneralRecursion {
  import BTree._
  def main(args: Array[String]): Unit = {
    val tree = Branch(Branch(Leaf(1),Leaf(2)),Branch(Leaf(3),Leaf(4)))
    val transformedTree = Functor[BTree].map(tree)("|"+_+"|")
    println(tree)
    println(transformedTree)
  }
}
