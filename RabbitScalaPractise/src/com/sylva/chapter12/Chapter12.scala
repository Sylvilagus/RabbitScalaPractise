package com.sylva.chapter12

/**
  * Created by sylva on 2016/2/19.
  */
object Chapter12 {
  def main(args:Array[String]): Unit ={
    //1
    println("puzzle 1")
    values((x)=>x+10,-5,5).foreach(println(_))
    //2
    println("puzzle 2")
    val arr1=Array(1,-4,2,6,10,-5,-6,-5,8,7,8,27,6,-7)
    val max=arr1.reduceLeft((l,r)=>if(l>r) l else r)
    println(max)
    //3
    println("puzzle 3")
    println(factorial(3))
    println(factorial(4))
    //4
    println("puzzle 4")
    println(foldFactorial(0))
    println(foldFactorial(4))
    //5
    println("puzzle 5")
    println(largest(x=>10*x-x*x,1 to 10))
    //6
    println("puzzle 6")
    println(largestInput(x=>10*x-x*x,1 to 10))
    //7
    println("puzzle 7")
    println(adjustToPair(_*_)((6,7)))
    //8
    println("puzzle 8")
    val strs=Array("tom","Jerry","cheese","michael")
    val lens=Array(3,5,6,7)
    val lens1=Array(3,5,6,8)
    println(strs.corresponds(lens)(_.length==_))
    println(strs.corresponds(lens1)(_.length==_))
    //9
    println("puzzle 9")
    println(correspondsNoCurrying(strs,lens,(a:String,b:Int)=>a.length==b))
    println(correspondsNoCurrying(strs,lens1,(a:String,b:Int)=>a.length==b))
  }
  def values(fun:Int=>Int,low:Int,high:Int):Array[(Int,Int)]= (low to high).toArray.map(x=>(x,fun(x)))
  def factorial(x:Int):Int=(1 to x).toArray.reduceLeft(_*_)
  def foldFactorial(x:Int):Int=(1 to x).toArray.foldLeft(1)(_*_)
  def largest(fun:(Int)=>Int,input:Seq[Int]):Int=input.map(x=>fun(x)).reduceLeft((x,y)=>if(x>y) x else y)
  def largestInput(fun:(Int)=>Int,input:Seq[Int]):Int=input.map(x=>(x,fun(x))).reduceLeft((x,y)=>if(x._2>y._2) x else y)._1
  def adjustToPair(fun:(Int,Int)=>Int):((Int,Int))=>Int=(x:(Int,Int))=>fun(x._1,x._2)
  def correspondsNoCurrying[A,B](a:Array[A],b:Array[B],f:(A,B)=>Boolean):Boolean=a.zip(b).find(x=>(!f(x._1,x._2))).isEmpty

}
