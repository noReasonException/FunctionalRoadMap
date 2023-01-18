package lvl1

case class Point2D(x:Int,y:Int)
object Point2D{
  def apply(x: Int, y: Int): Point2D = new Point2D(x, y)
  def unapply(arg: Point2D): Option[(Int, Int)] = Some((arg.x,arg.y))
}

object C_ConstructingAndDestructing {
  def main(args: Array[String]): Unit = {
    val point2D = Point2D(1,2) //we create a point with the constructor
    val deconstructPoint2D:Option[(Int,Int)]=Point2D.unapply(point2D) //we 'deconstruct' the object into its components, 2 integers!
    //That's how pattern match works!
    val quadrant = point2D match {
      case Point2D(x, y) if(x>0&&y>0) => 1
      case Point2D(x, y) if(x>0&&y<0) => 3
      case Point2D(x, y) if(x<0&&y>0) => 2
      case Point2D(x, y) if(x<0&&y<0) => 4
      case _ => ???
    }
  }

}
