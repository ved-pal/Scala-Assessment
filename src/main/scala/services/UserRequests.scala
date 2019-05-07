package services

import models.VendingMachine

import scala.collection.mutable

class UserRequests  (private val items : mutable.Map[String,Int], val coins : List[Int] , val notes : List[Int]){

  def viewAllItems(): mutable.Map[String,Int] = {
    items
  }

  def viewSelectedItems(i : String) : Map[String,Int] = {   //view selected items and thier prices
    if (!items.contains(i)) {
      val temp: Map[String, Int] = Map("" -> 0)
      return temp
    }
    else {
      val temp: Map[String, Int] = Map(i -> items(i))
      return temp
    }
  }

   //------------------ story 3 funtions-----
    def buyItem(itemname : String) ( insertedcoins : List[Int] , insertednotes :List[Int]): Map[Int, Boolean] = {

      if(insertedcoins.isEmpty || insertednotes.isEmpty){
        return Map(0 -> false)
      }


      val amountinserted = insertedcoins.sum + insertednotes.sum   // total amount inserted

      if(items.contains(itemname)){
        val amountrefund = amountinserted- items(itemname)     //items(itemname) = price of that item

        //val res = ischangeavailable(amountrefund)  // function to check change

        return Map(amountrefund -> true)
      }
      else{
        return Map((insertedcoins.sum + insertednotes.sum) -> false)
      }
    }



// function to check notations for refund
  def ischangeavailable(amf : Int) : Boolean = {
    var temp = coins ::: notes

    var a = amf
    if((coins.sum + notes.sum) >= amf ){
      while(a >0 )
      if(notes.max <= amf ){a = a - temp.max; temp = temp.filter(_ < temp.max)}
      if(coins.max <= amf ){a = a - temp.max; temp = temp.filter(_ < temp.max)}
    }

    if(a == 0) true
    else false
  }
}
