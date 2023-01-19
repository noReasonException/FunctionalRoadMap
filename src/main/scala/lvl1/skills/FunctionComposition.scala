package lvl1.skills

object FunctionComposition {
  val plusOne:Int=>Int=_+1
  val times2:Int=>Int=_*2

  def main(args: Array[String]): Unit = {
    print((plusOne andThen times2 andThen plusOne )(12) == (12+1)*2 + 1)
  }

}
