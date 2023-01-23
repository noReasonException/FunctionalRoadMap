package lvl1.test.adtvsoop
import lvl1.test.adtvsoop.IntegerAdder
//OOP vs ADT's
//Source :  https://www.cs.utexas.edu/users/wcook/papers/OOPvsADT/CookOOPvsADT90.pdf

//Object-oriented programming and abstract data types can also be viewed as complementary
//implementation techniques: objects are centered around the constructors of a data abstraction, while
//abstract data types are organized around the operations.

//The basic difference is in the mechanism used to achieve the abstraction
//barrier between a client and the data. In abstract data types, the primary mechanism is type abstraction,
//while in procedural data abstraction it is procedural abstraction. This means, roughly, that in an ADT
//the data is abstract by virtue of an opaque type: one that can be used by a client to declare variables but
//whose representation cannot be inspected directly. In PDA, the data is abstract because it is accessed
//through a procedural interface – although all of the types involved may be known to the user.

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
