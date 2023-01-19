package lvl1.skills

import cats.Monoid
import cats.data.NonEmptyList
import cats.implicits._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**Inspired by https://ericnormand.me/podcast/what-is-a-higher-order-function (Eric Normand)**/

class B_SecondOrderFunctions {

  //ZeroOrderFunction
  //Gets values, returns values
  def pow2(x:Int)=x*x

  //First Order Function
  //Gets at least a zero order function as a parameter or Returns a zero order function as a result
  def executeInThread[A,B](fn:A=>B, param1:A):Future[B]= Future {fn(param1)}

  //Second-Order Function
  //Gets at least a first order function as parameter or Returns a first order function as a result
  def massComputationOnMultipleThreadsExample[A,B](data:NonEmptyList[A], operation:(A=>B), reduceOp:(B,B)=>B, executorFunction:(A=>B,A)=>Future[B])(implicit monoid: Monoid[A],monoidb:Monoid[B]):Future[B] ={
    val computationalThreads=data.map(executorFunction(operation,_))
    val combineToOneFuture = computationalThreads.sequence
    combineToOneFuture.map(_.foldLeft(Monoid[B].empty)(reduceOp))
  }
  def main(args: Array[String]): Unit = {
    val operation:Int=>Int = pow2 //Zero Order Function
    val executor:(Int=>Int,Int)=>Future[Int]=executeInThread[Int,Int] //First Order Function
    //(NonEmptyList[Int],Int=>Int,(Int,Int)=>Int,(Int=>Int,Int)=>(Monoid[Int],Monoid[Int])=>Future[Int])
    val massCompute: (NonEmptyList[Int], Int => Int, (Int, Int) => Int, (Int => Int, Int) => Future[Int]) => Future[Int] = massComputationOnMultipleThreadsExample[Int, Int] //Second Order
    //From Second order onwards, becomes too messy. In the bibliography, you will find them as just 'Higher Order Functions'
    //Common examples are 'map,reduce,filter' etc
  }
}
