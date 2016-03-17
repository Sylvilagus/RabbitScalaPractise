package com.sylva.chapter2

/**
  * Created by sylva on 2016/2/16.
  */
object Chapter2 {
  def main(args:Array[String]): Unit ={
    //practise1
    println("puzzle 1")
    println(signnum(9))
    println(signnum(-1222))
    println(signnum(0))
    //3
    println("puzzle 3")
    var x:Unit=()
    var y:Int=9
    x=y=1
    //4
    println("puzzle 4")
    for(i<- (1 to 10).reverse)println(i)
    //5
    println("puzzle 5")
    count(6)
    //6
    println("puzzle 6")
    println(unicodeMultiply("Hello"))
    //7
    println("puzzle 7")

    println("Hello".map(_.toLong).fold(1L){(a1,a2)=>a1*a2})
    //9
    println("puzzle 9")
    println("recursion:")
    println(recursionCalculateStr("Hello"))
    println("tail recursion:")
    println(tailRecursionCalculateStr("Hello"))
    //10

  }
  def unicodeMultiply(str:String): Long ={
    var result=1L
    str.foreach(result*=_.toLong)
    result
  }
  def count(n:Int){
    for(i<- (0 to n).reverse)println(i)
  }
  def signnum(x:Int):Int=if(x>0) 1 else if(x==0) 0 else -1
  def recursionCalculateStr(str:String):Long=str.length match{
    case 0=>1L
    case _=>str(0).toLong*recursionCalculateStr(str.drop(1))
  }
  def tailRecursionCalculateStr(str:String):Long={
    def recursionCalculate(piece:String,accumulator:Long):Long=piece.length match{
      case 0=>accumulator
      case _=>recursionCalculate(piece.drop(1),piece(0).toLong*accumulator)
    }
    recursionCalculate(str,1L)
  }
}
