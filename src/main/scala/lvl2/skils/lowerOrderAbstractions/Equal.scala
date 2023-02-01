package lvl2.skils.lowerOrderAbstractions

//Type Class
trait Equal[A] {
  def safeEquals(left:A,right:A):Boolean=left.hashCode()==right.hashCode()
}

object Equal{
  //Syntax-Class
  implicit class EqualOps[A](left:A) {
    def safeEquals(right:A)(implicit equalInstance:Equal[A]):Boolean=equalInstance.safeEquals(left,right)
  }
  //Instance
  implicit def equalGenericImpl[A]:Equal[A]=new Equal[A] {}
}

object EqualMain{
  import Equal._
  def main(args: Array[String]): Unit = {
    assert(12.safeEquals(12))
    assert(!12.safeEquals(13))
    println("All Tests Passed")
  }
}
