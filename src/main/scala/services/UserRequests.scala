package services

import models.VendingMachine

import scala.collection.mutable

class UserRequests  (private val items : mutable.Map[String,Int], val coins : List[Int] , val notes : List[Int]){

  def viewAllItems(): mutable.Map[String,Int] = {
    items
  }

  def viewSelectedItems(i : String) : Map[String,Int] = {
    if(!items.contains(i)){
      val temp : Map[String,Int] = Map("" -> 0)
      return temp
    }
    else {
      val temp: Map[String, Int] = Map(i -> items(i))
      return temp
    }

  }

}
