import models.VendingMachine
import org.scalatest.FunSuite
import services.UserRequests

import scala.collection.mutable

class TestingVendingMachine extends FunSuite{

  val adminuser = new VendingMachine(mutable.Map("Chips" -> 10 , "Nuts" -> 15 , "Candies" -> 5, "Biscuits" -> 20, "Cold drinks" -> 20), List(1,2,5,10), List(10,20,50,100))
  val user = new UserRequests(adminuser.showItems(), List(1,2,5,10), List(10,20,50,100))






  //------------------- TEST CASES--------------------------
  test("Story 1 Acceptance Criteria 1"){

    adminuser.addItems("buns" , 30)
    adminuser.addItems("Cake",100)
    adminuser.addItems("Hot Chocolate" , 70)
    assert(adminuser.showItems().contains("buns") == true)
    assert(adminuser.showItems().contains("Cake") == true)
    assert(adminuser.showItems().contains("Hot Chocolate") == true)
  }

  test("Story 1 Acceptance Criteria 2"){
    adminuser.addCoins(50)
    adminuser.addCoins(100)
    assert(adminuser.showCoins() == List(100,50,1,2,5,10))

    adminuser.addnotes(200)
    assert(adminuser.showNotes() == List(200,10,20,50,100))
  }


  test("Story 2 Acceptance Criteria 1"){
    assert(user.viewAllItems() == adminuser.showItems())
  }

  test("Story 2 Acceptance Criteria 2"){
    assert(user.viewSelectedItems("Nuts") == Map("Nuts" -> 15))
    assert(user.viewSelectedItems("Candies") == Map("Candies" -> 5))
    assert(user.viewSelectedItems("Biscuits") == Map("Biscuits" -> 20))
    assert(user.viewSelectedItems("Cold drinks") == Map("Cold drinks" -> 20))
    assert(user.viewSelectedItems("Chips") == Map("Chips" -> 10))
  }

}
