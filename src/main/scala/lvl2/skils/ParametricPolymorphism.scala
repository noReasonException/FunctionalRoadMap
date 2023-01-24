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



  def main(args: Array[String]): Unit = {
    //i can call pow2 only on integers
    println(s"pow2(12) = ${pow2(12)}")
    //but i can call the generic function on whatever
    println(s"pow2Generic(12) = ${pow2Generic(12)}")
    println(s"pow2Generic(12.2f) = ${pow2Generic(12.2f)}")
    println(s"pow2Generic('Hello') = ${pow2Generic("Hello")}")
  }

  //Not all type systems support parametric polymorphism
  //Famous example, C++ Templates, where you write the minimum amount of code necessary
  //And the compiler generates multiple ad-hoc versions, this idea of 'multiple implementations for specific types'
  //Is called Ad-hoc polymorphism
  //This idea also applies to other types of polymorphism. Generics/Parametric polymorphism uses the 'vehicle' of
  //types to achieve multiple-forms(Greek poly(πολύ)(many) morphism(μορφες)(shapes)). There are other 'vehicles' such as
  //Subtypes(Extend/Inheritance in OOP) . In Subtypes, when you override a specific implementation of a method for a subtype
  //You effectively do ad-hoc polymorphism(overloading)
}
