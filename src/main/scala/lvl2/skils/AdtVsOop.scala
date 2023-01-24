package lvl2.skils

import lvl2.adtvsoop.{Adder, IntegerAdder, IntegerImpl, Semigroup}

/***
 * Feature    OOP(PDA)                                                                  ADT
 * State      State is part of the object - Objects are full on machines                Data types do not have state,state is external and always as local as possible
 * Domain     The domain is spread at the implementations, more extensible,less safe    Closed type domain(sealed) and pre-defined operations, less extensible,more compiler-secure
 * Safety     More extensible, less compiler-safe                                       Less extensible, increased safety
 *
 *
 *
 */
object AdtVsOop {

  def objectExample={
    val obj:Adder[Int] = new IntegerAdder()
    obj.op(+12)
    obj.op(-12)// Observe how the state is internal to Object
    assert(obj.result==0)
  }

  def adtExample={
    val number:Semigroup[Int] = IntegerImpl(12)
    val anotherNumber:Semigroup[Int]=IntegerImpl(-12)
    val result = number combine anotherNumber //Observe how the state is external to ADT
    assert(result.element==0)
  }
  def main(args: Array[String]): Unit = {
    objectExample
    adtExample
  }



}
