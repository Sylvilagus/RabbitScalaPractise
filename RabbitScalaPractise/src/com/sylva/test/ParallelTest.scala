package com.sylva.test

/**
  * Created by sylva on 2016/2/24.
  */
object ParallelTest {
  def main(args:Array[String]): Unit ={
    timmingExecute(println((1 to 10).par.product))
    timmingExecute(println((1 to 10000000).par.product))
    timmingExecute(println((1 to 10000000).product))
  }
  def timmingExecute(procedure: =>Unit): Unit ={
    val start=System.currentTimeMillis()
    procedure
    val time=System.currentTimeMillis()-start
    println("calculate cost :"+time)
  }

}
