package com.sylva.chapter4

import scala.io.Source

/**
  * Created by sylva on 2016/2/17.
  */
object Chapter4 {
  def main(args:Array[String]): Unit ={
    //1
    println("puzzle 1")
    val gears=Array("GameBoy","X-box","PlayStation","Macbook","Thinkpad")
    val prices=Array(1400,7300,7500,13800,8000)
    val gearsAndPrices=gears.zip(prices).toMap
    println(gearsAndPrices)
    val discounted=for((k,v)<-gearsAndPrices)yield(k,v*0.9)
    println(discounted)
    //2
    println("puzzle 2")
    val names=Source.fromFile("d:/names.txt").mkString.split("\\s+").map((_,1)).groupBy(_ _1).map(x=>(x._1,x._2.length))
    println(names.mkString(","))

  }

}
