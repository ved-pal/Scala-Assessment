import models.VendingMachine
import org.scalatest.FunSuite

import scala.collection.mutable

class TestingVendingMachine extends FunSuite{

  val adminuser = new VendingMachine(mutable.Map("Chips" -> 10 , "Nuts" -> 15 , "Candies" -> 5, "Biscuits" -> 20, "Cold drinks" -> 20), List(1,2,5,10), List(10,20,50,100))

  test("Acceptance Criteria 1"){

    adminuser.addItems("buns" , 30)
    assert(adminuser.showItems().contains("buns") == true)
  }

  test("Acceptance Criteria 2"){
    adminuser.addCoins(50)
    assert(adminuser.showCoins() == List(50,1,2,5,10))

    adminuser.addnotes(200)
    assert(adminuser.showNotes() == List(200,10,20,50,100))
  }

}
