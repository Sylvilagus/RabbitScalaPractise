package com.sylva.test

import scala.actors.Actor

/**
  * Created by sylva on 2016/2/18.
  */
object ActorTest {
  def main(args:Array[String]): Unit ={
    val ma=new MyActor
    ma.start()
    ma!"fuck you"
    ma!"hello"
    ma!"hi"
    ma!"Hi"
  }

}
class MyActor extends Actor{
  override def act()={
    while(true){
      receive{
        case "Hi"=>print("Hello")
        case _=>print("what?")
      }
    }
  }
}
