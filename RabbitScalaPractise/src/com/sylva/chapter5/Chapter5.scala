package com.sylva.chapter5

import scala.beans.BeanProperty
import scala.collection.mutable.ArrayBuffer

/**
  * Created by sylva on 2016/2/18.
  */
object Chapter5 {
  def main(args:Array[String]): Unit ={
    //1
    println("chapter 1")
    val counter=new Counter()
    println(counter.current)
    println(counter.increment)
    //2
    println("chapter 2")
    val bankAccount=new BankAccount(100)
    println(bankAccount.balance)
    println(bankAccount.withDraw(50))
    println(bankAccount.deposit(25))
    println(bankAccount.balance)
    //3
    println("chapter 3")
    val t1=Time(22,22)
    val t2=Time(22,21)
    val t3=Time(23,21)
    val arr=ArrayBuffer(t1,t2,t3)
    println(arr.mkString(","))
    arr.sortWith((t1,t2)=>t1.before(t2))
    println(arr.mkString(","))
    println(t1.before(t2))
    println(t2.before(t1))
    println(t3.before(t1))
    //5
    println("chapter 5")
    val tom=new Student("tom",1L)
    tom.id=2
    tom.setId(3)
    tom.name="Jerry"
    tom.setName("Naruto")
    println(tom.name)
    println(tom.getName)
    println(tom.id)
    println(tom.getId)
  }
}
class Counter{
  private var value=Int.MaxValue
  def current=value
  def increment=if(value<Int.MaxValue) value+1 else value
}
class BankAccount(var balance:Double){
  def deposit(money:Double):Double={
    balance+=money
    balance
  }
  def withDraw(money:Double):Double={
    balance-=money
    balance
  }
}
class Time(val hours:Int,val minute:Int){
  def before(other:Time):Boolean={
    hours<other.hours||(hours==other.hours&&minute<other.minute)
  }
  override def toString=hours+":"+minute
}
object Time{
  def apply(hour:Int,minute:Int)=new Time(hour,minute)
}
class Student(@BeanProperty var name:String,@BeanProperty var id:Long){
  override def toString:String="name is "+name+",id is "+id
}
//class Car(val factory:String,val typeCode:String,val typeYear:Int= -1,var serialCode:String=""){
//  def this(factory:String,typeCode:String)=this(factory,typeCode)
//  def this(factory:String,typeCode:String,typeYear:Int)=this(factory,typeCode,typeYear)
//}
