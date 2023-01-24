package lvl2.skils

import cats.Semigroup
import cats.implicits.catsSyntaxSemigroup


//In OOP, we call it Generics
//In functional world, we call it 'Parametric Polymorphism'
//Thinking fast-and-loose those are the same thing, We will talk about the details later

object ParametricPolymorphism {
  //Ad-hoc version of the pow function
  def pow2(x:Int):Int=x*x

  //Polymorphic version of the pow function
  def pow2Generic[A:Semigroup](a:A):A=a combine a //<- that's a true parametric function


  //Not all type systems support parametric polymorphism
  //Famous example, C++ Templates, where you write the minimum amount of code nessesary
  //And the compiler generates multiple ad-hoc versions
  def main(args: Array[String]): Unit = {
    //i can call pow2 only on integers
    println(s"pow2(12) = ${pow2(12)}")
    //but i can call the generic function on whatever
    println(s"pow2Generic(12) = ${pow2Generic(12)}")
    println(s"pow2Generic(12.2f) = ${pow2Generic(12.2f)}")
    println(s"pow2Generic('Hello') = ${pow2Generic("Hello")}")
  }
}
