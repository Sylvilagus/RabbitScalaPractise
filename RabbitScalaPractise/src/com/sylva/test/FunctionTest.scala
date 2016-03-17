package com.sylva.test

/**
  * Created by sylva on 2016/2/18.
  */
object FunctionTest {
  def main(args:Array[String]): Unit ={
    def s1=sum(5,_:Int)
    println(s1(6))
  }
  def sum(x:Int,y:Int):Int={
    x+y
  }
//  def sum(x:Int)(y:Int):Int={
//    x+y
//  }

}
