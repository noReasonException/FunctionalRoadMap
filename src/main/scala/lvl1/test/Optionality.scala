package lvl1.test



sealed trait Maybe[+A]
case object NotFound extends Maybe[Nothing]
case class Found[A](a:A) extends Maybe[A]

object Optionality {
  def main(args: Array[String]): Unit = {
    val maybeNumber:Maybe[Int] = Found(12)

    maybeNumber match {
      case Found(number)=>print(s"Found, is $number")
      case NotFound=>print("Not found")
    }


  }
}
