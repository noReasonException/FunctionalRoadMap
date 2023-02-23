package lvl3

import java.util.concurrent.TimeUnit
import scala.concurrent.duration.FiniteDuration

case class MyIO[A](unsafeRun: () => A){
  def map[B](fn:A=>B):MyIO[B] = MyIO(()=>fn(unsafeRun()))
  def flatMap[B](fn:A=>MyIO[B]) :MyIO[B]= MyIO(()=>fn(unsafeRun()).unsafeRun())
}

object Timing extends App{
  val clock:MyIO[Long]= MyIO[Long](()=>System.currentTimeMillis())
  def time[A](action:MyIO[A]):MyIO[(FiniteDuration,A)] = {
    for{
      startTime <- clock
      action <- action
      endTime <- clock
    }yield (FiniteDuration.apply(endTime-startTime,TimeUnit.MILLISECONDS),action)
  }
  val timedHello = Timing.time(MyIO(()=>println("Hello World")))
  timedHello.unsafeRun() match {
    case (duration,_)=>println(s"Took $duration ")
  }
}
