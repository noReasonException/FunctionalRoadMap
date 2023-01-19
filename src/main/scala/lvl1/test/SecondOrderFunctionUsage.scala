package lvl1.test

object SecondOrderFunctionUsage {
  def transformList(list:List[Int],fn:Int=>Int):List[Int]=list.map(fn)
}
