package lvl1.skills

object A_ImmutableData {
  //Why Immutability matters
  //let the following example
  def immutableAbsentExample():Unit={
    var i = 10        //A variable, is a commitment.
    def pow2(x:Int):Int = x*x   //And commitments are used to build more complex stuff
    pow2(i)                     //pow2 given the quantity 'i' will always result into the same result, determinism
    //...
    //...                       //Let a huge program with multiple contact points for this commitment
    //...
    i=20                        //..If you change the commitments
    pow2(i)                     //, ..you also change everything that used that 'commitment', implicitly
    //This is a source of bugs and slows development down. Is not feasible for a single mind to calculate all of the
    //different possible disruptions of a single variable change.
  }
  def immutabilityPresentExample():Unit={
    val i = 10 //A constant , is a commitment that you can safely build complex structures onto
    //..
    //..
    def pow2(x:Int):Int = x*x //Given a pure function, and a constant
    pow2(i) == 100 // referentially transparency guaranteed, you can build whatever on top of i, you don't need to
    //think about consequences
    //if you need to a new value based on i, you don't change i, you create a copy!
    val copyOfi = i+42 //this is a new symbol, free of commitments, nothing will collapse!

    //That being said, immutability plays well with locality, otherwise you will severely pollute your namespace
    //So immutable and local data, small purpose-build and composeable functions.
  }

  def main(args: Array[String]): Unit = {

  }
}
