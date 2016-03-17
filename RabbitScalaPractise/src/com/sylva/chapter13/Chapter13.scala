package com.sylva.chapter13

import scala.collection.mutable

/**
  * Created by sylva on 2016/2/24.
  */
object Chapter13 {
  def main(args:Array[String]): Unit ={
    println("puzzle 1")
    println(charIndexMap("Mississippi"))
    println("puzzle 3")
//    val mp=Map("000000127-02-HA01"->"1050.0")
////    val res=mp.map(x=>(x._1.reverse.dropWhile(_!='-').reverse,(x._1.reverse.takeWhile(_!='-').reverse,x._2)))
//    val res=mp.map {x=>
//      val lind=x._1.lastIndexOf("-")
//      (x._1.take(lind),(x._1.drop(lind+1),x._2))
//    }
//    println(res)
    val list=List(0,1,2,3,0,5,6,0,0,7,7,5)
    println(removeZero(list))
    println("puzzle 4")
    val arr=Array("Tom","Fred","Harry")
    val map=Map("Tom"->3,"Dick"->4,"Harry"->5)
    println(puzzle4(arr,map))
    println("puzzle 5")
    println(mkString(Array(1,2,3,4,5,6,7,8,9),"[",",","]"))
  }
  def charIndexMap(str:String):Map[Char,Set[Int]]={
    str.zip(0 until str.length).groupBy(_._1).map(x=>(x._1,x._2.map(_._2).toSet))
  }
  def removeZero(list:List[Int]): List[Int] ={
    list.filter(_!=0)
  }
  def puzzle4(arr:Array[String],map:Map[String,Int]):Array[Int]={
    arr.map(x=>(x,x.length)).intersect(map.toArray[(String,Int)]).map(_._2)
  }
  def mkString[B](arr:Array[B],left:String,separator:String,right:String):String={
    left+arr.map(_.toString).reduceLeft(_+separator+_)+right
  }
}
