package lvl3

case class MyIO[A](unsafeRun:()=>A){
  def map[B](f:A=>B):MyIO[B]=MyIO(()=>f(unsafeRun()))
  //def flatMap[B](f:A=>MyIO[B]):MyIO[B]=f(unsafeRun()) //this implementation immediately triggers execution,therefore makes the effect unlawful
  def flatMap[B](f:A=>MyIO[B]):MyIO[B]=MyIO[B](()=>f(unsafeRun()).unsafeRun()) //this implementation does not immediately triggers execution
}

object MyIO{
  def apply[A](fn: () => A): MyIO[A] = new MyIO(fn)
}

object Main{
  def main(args: Array[String]): Unit = {
    val effect = MyIO[Unit](()=>println("Hello world"))
    println("Effect created")
    println("Executing effect...")
    effect.unsafeRun()
    println("Mapping effect to some other effect")
    val mappedEffect =effect.map(_=>println("bye world!"))
    println("Executing mapped effect")
    mappedEffect.unsafeRun()
  }
}
