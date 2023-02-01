package lvl2.skils

/***
 * Type classes(1), instances(2), and laws(3)
 */
//Study This fantastic article: https://typelevel.org/cats/typeclasses.html
//Also https://nrinaudo.github.io/scala-best-practices/tricky_behaviours/final_case_classes.html


//Thats a trait(1), just like an interface in java
trait Monoid[A]{
  def empty:A
  def combine(left:A,right:A):A
}
object Monoid{
  //here we create a type class, an instence(2) of that specific typeclass
  implicit val strMonoid :Monoid[String] = new Monoid[String] {
    override def empty: String = ""
    override def combine(left: String, right: String): String = left+right
  }
  //This non-sense will make sense later
  def apply[A](implicit monoid: Monoid[A]): Monoid[A] = monoid
}
object TypeClasses {
  /***
   * A few notes on Subtype Polymorphism vs Type Classes and how they dealt with Polymorphism
   * Preamble: Let a given interface A. There is generally 2 ways of exposing that interface
   * 1) Let ClassChild extend(or implement) A, Each ClassChild object will now contain the properties of interface A(OOP,Subtype Polymorphism)
   * 2) Implement a separate ClassChildInterfaceAImpl class which contains the implementation of ClassChild on interface A(TypeClasses, Ad-hoc style polymorphism)
   *
   * Both ways expose the interface A into an arbitrary number of implementations, Therefore A is polymorphic on either setup
   * As you can see, Type-classes sometimes are our only way(Monoid Implementation)
   * As a happy plus, but this is my personal opinion, keeps our models clean, by not enforcing us to over-extend and over-pollute our
   * classes with lots of features. You have a set of very purpose-specific classes, and various type-classes to serve your needs on demand
   *
   * Example, Monoid : The idea of combination, its way better to have it separately instead of every single instance(
   * Maybe a Generic class 'Mammal' is interested in 'combining', but is equally okay to say that an airplane can combine itself with other airplanes?
   * as what? passengers? capacity? are the airplanes mating? nope!)
   *
   */
  //Default implementation
  def combineAll[A](list:List[A],monoid: Monoid[A]):A=list.foldLeft(monoid.empty)(monoid.combine)
  //The following forces the A to be Subtype of Monoid, we cant implement this, as the Monoid functionalities themselves
  // are within A's in the list. what if the list is empty? paradoxically with an empty list we cant get a single A to
  // get A.empty(and it wouldn't make much sense to do so, as a if single element existed, we wouldn't need the empty element at all)
  def combineAllV2[A<:Monoid[A]](list: List[A]):A= ???
  //Be careful, A<:Monoid[A] means 'Is subtype and honors Monoid[A]'**1 , this is quite different than the next example
  def combineAllV3[A:Monoid](list:List[A]):A=list.foldLeft(Monoid[A].empty)(Monoid[A].combine)
  //In this example, A:Monoid means 'honors Monoid[A]', meaning that there is at least one implementation of Monoid[A]
  //somewhere, expecting to get her via contextual(implicit) parameters), That's the same as
  def combineAllV4[A](list:List[A])(implicit monoidA:Monoid[A]):A=list.foldLeft(Monoid[A].empty)(Monoid[A].combine)
  //This function enforces the same rules with a different syntax. We have an A and we need Monoid[A] to exist
  //**1)This interpretation is mine, so take it with a bit of salt


  //Laws

  /**
   * Every type class usually encapsulates a transformation between arbitrary objects of a specific type, and every transformation
   * is subject to laws. For example, Monoids .combine should be associative, and Monoids.empty should honor the identity law
   * On appropriate functional libraries, type-classes contain their own checks for their implicit laws(cats have kernel-laws and laws)
   */
  def main(args: Array[String]): Unit = {

  }
}
