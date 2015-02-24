import scala.concurrent.{Future, Await, ExecutionContext}

/**
 * Created by jdesjardins on 11/13/14.
 */
object Main extends App {
  import ExecutionContext.Implicits.global
  import scala.async.Async.{async, await}
  import scala.concurrent.duration._

//  val a = Future{ Thread.sleep(2000); 4}
//  val b = Future{ Thread.sleep(3000); 4}
//  val c = Future{ Thread.sleep(500); throw new Exception("hi")}
//
//  val future = async {
//   await(a) + await(c) + await(b)
//  }
//
//  val t = Await.result(future, 1.second)
//
//  println(t)
//
//  async {
//    val p = await(phone)
//    val h = await(home)
//    val w = await(work)
//    prepareResponse(p,h,w)
//  }

//  println(System.currentTimeMillis())
//  async {
//    List(1,2,3).map{y => await(Future{Thread.sleep(y * 1000); y * 7})}.map(_ + 7)
//  }
//  println(System.currentTimeMillis())

  def doThing(a: Int => Int, b: Int, c: Int) = a(b) + c

  async { doThing(a => await(Future(5)), await(Future(10)), await(Future(20)))}

}
