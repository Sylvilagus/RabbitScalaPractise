package com.sylva.chapter3

import java.util

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
  * Created by sylva on 2016/2/16.
  */
object Chapter3 {
  def main(args:Array[String]): Unit ={
    //1
    println("puzzle 1")
    println(generateRandomArray(20).mkString(","))
    //2
    println("puzzle 2")
    val arr=Array(1,2,3,4,5,6)
    coupleSwap(arr)
    println(arr.mkString(","))
    //3
    val arr1=Array(1,2,3,4,5,6)
    println("puzzle 3")
    println(generateCoupleSwaped(arr1).mkString(","))
    //4
    println("puzzle 4")
    val arr4:Array[Int] = Array(1, -4, 3, 0, 5, 11, -5, 6, -9, -52, -4, 13)
    println(remodelArray(arr4).mkString(","))
    //5
    println("puzzle 5")
    val ds:Array[Double]=Array(1,4,6,7,88)
    println(ds.sum/ds.length)
    //6
    println("puzzle 6")
    val is:Array[Int]=Array(1,4,6,7,88)
    println(is.reverse.mkString(","))
    revertArray(is)
    println(is.mkString(","))
    //7
    println("puzzle 7")
    val src:Array[Int]=Array(1,4,6,1,1,1,88,7,88)
    src.toBuffer.distinct.toArray.foreach(println(_))
  }
  def revertArray(arr : Array[Int]) = {
    for (i <- 0 until (arr.length / 2)) {
      val t = arr(i)
      arr(i) = arr(arr.length - 1 - i)
      arr(arr.length - 1 - i) = t
    }
  }
  def generateRandomArray(n:Int):Array[Int]={
    (for(i<- 0 until n) yield Random.nextInt(n)).toArray
  }
  def coupleSwap(arr:Array[Int]): Unit ={
    for(i<-0 until arr.length-1 if i%2==0){
      val temp:Int=arr(i)
      arr(i)=arr(i+1)
      arr(i+1)=temp
    }
  }
  def generateCoupleSwaped(arr:Array[Int]):Array[Int]={
    (for(i<- 0 until arr.length) yield{
      if(i%2==0&&i<arr.length-1){
        val temp:Int=arr(i)
        arr(i)=arr(i+1)
        arr(i+1)=temp
      }
      arr(i)
    }).toArray
  }
  def remodelArray(arr:Array[Int]):Array[Int]={
    val (a1,a2)=arr.partition(_>0)
    Array.concat(a1,a2)
  }
}
