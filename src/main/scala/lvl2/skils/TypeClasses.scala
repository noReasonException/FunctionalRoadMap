package lvl2.skils

//Study This fantastic article: https://typelevel.org/cats/typeclasses.html
//Also https://nrinaudo.github.io/scala-best-practices/tricky_behaviours/final_case_classes.html
trait Monoid[A]{
  def empty:A
  def combine(left:A,right:A):A
}
object Monoid{
  implicit val strMonoid :Monoid[String] = new Monoid[String] {
    override def empty: String = ""
    override def combine(left: String, right: String): String = left+right
  }
  //This non-sense will make sence later
  def apply[A](implicit monoid: Monoid[A]): Monoid[A] = monoid
}
object TypeClasses {
  //Default implementation
  def combineAll[A](list:List[A],monoid: Monoid[A]):A=list.foldLeft(monoid.empty)(monoid.combine)
  //The following forces the A to be Subtype of Monoid, we cant implement this, as the Monoid functionalities themselves
  // are within A's in the list. what if the list is empty? paradoxically with an empty list we cant get a single A to
  // get A.empty(and it wouldn't make much sense to do so, as a if single element
  //existed, we wouldn't need the empty element at all)
  def combineAllV2[A<:Monoid[A]](list: List[A]):A= ???
  //Be careful, A<:Monoid[A] means 'Is subtype and honors Monoid[A]'**1 , this is quite different than the next example
  def combineAllV3[A:Monoid](list:List[A]):A=list.foldLeft(Monoid[A].empty)(Monoid[A].combine)
  //In this example, A:Monoid means 'honors Monoid[A]', meaning that there is at least one implementation of Monoid[A]
  //somewhere, expecting to get her via contextual(implicit) parameters), That's the same as
  def combineAllV4[A](list:List[A])(implicit monoidA:Monoid[A]):A=list.foldLeft(Monoid[A].empty)(Monoid[A].combine)
  //This function enforces the same rules with a different syntax. We have an A and we need Monoid[A] to exist

  //**1)This interpretation is mine, so take it with a bit of salt
  def main(args: Array[String]): Unit = {

  }
}
