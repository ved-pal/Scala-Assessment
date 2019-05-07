package models

import scala.collection.mutable

case class VendingMachine (private var items : mutable.Map[String,Int], var coins : List[Int] , var notes : List[Int]){

//   var items : scala.collection.mutable.Map[String, Int]
//   var coins : List[Int]
//   var notes : List[Int]


  //------SETTERS--------------------------------------
  def addItems(newitem : String , newprice : Int) = {
    this.items +=  (newitem -> newprice)
  }

  def addCoins(newcoin : Int) = {
    this.coins = newcoin :: coins
  }

  def addnotes(newnote : Int) = {
    this.notes = newnote :: notes
  }
//--------------------------------------------------------



  //------GETTERS-------
  def showItems(): mutable.Map[String, Int] = {
    return items
  }

  def showCoins():  List[Int] = {
    return coins
  }

  def showNotes() : List[Int] = {
    return notes
    //------------------------------------------
  }
}
