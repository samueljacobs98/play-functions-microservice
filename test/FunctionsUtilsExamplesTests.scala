import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.must.Matchers
import utils.FunctionsUtils._

//
//
// THESE WILL FAIL AS FUNCTIONS WERE REFACTORED
// TESTS HAVE NOT BEEN UPDATED TO REFLECT REFACTORING
//
//

/** Test our Stack implementation in Spec style. */
class FunctionsUtilsExamplesTests extends AnyFunSpec with Matchers {
  describe("FunctionsUtils.longestConsecRecurse") {
    it("must return the two longest consecutive strings") {
      longestConsecRecurse(Array("one", "two", "three", "four", "five"), 2) mustBe "threefour"
    }

    it("must return the first possible answer if there are multiple correct solutions") {
      longestConsecRecurse(Array("two", "four", "six", "four"), 2) mustBe "twofour"
    }

    it("must return an empty string when provided with an empty array") {
      longestConsecRecurse(Array(), 2) mustBe ""
    }

    it("must return an empty string when k = 0") {
      longestConsecRecurse(Array("one", "two", "three", "four", "five"), 0) mustBe ""
    }

    it("must return an empty string when k = 0 and strArr is empty") {
      longestConsecRecurse(Array(), 0) mustBe ""
    }

    it("must return an empty string when k > strArr length") {
      longestConsecRecurse(Array("One", "Two", "Three"), 4) mustBe ""
    }

    // HOW TO TEST FOR ERRORS?
//    it("must throw error when k < 0") {
//      longestConsecRecurse(Array(), 0) mustBe ""
//    }

//    it("should not compile when given the wrong input type") {
//      longestConsecRecurse(Array(1, 2, 3), 2) must thro
//    }
  }

  describe("FunctionsUtils.numberOfDaysRec") {
    it("Must return 0 when all inputs are 0") {
      numberOfDaysRec(0, 0, 0) mustBe 0
    }

    it("Must return 0 when cost is 0 and other parameters are non-zero") {
      numberOfDaysRec(0, 10, 10) mustBe 0
    }

    it("Must return 0 when cost and savingsStart is 0 and offset is non-zero") {
      numberOfDaysRec(0, 0, 10) mustBe 0
    }

    it("Must return 0 when cost and offset is 0 and savingsStart is non-zero") {
      numberOfDaysRec(0, 10, 0) mustBe 0
    }

    it("Must return 0 when savingsStart > cost") {
      numberOfDaysRec(500, 1000, 0) mustBe 0
    }

    it("Must return 1 when cost = 1 and all other parameters = 0") {
      numberOfDaysRec(1, 0, 0) mustBe 1
    }

    it("Must return 178 for given parameter values") {
      numberOfDaysRec(10000, 2000, 30) mustBe 178
    }
  }

  describe("FunctionsUtils.warOfNumbers") {
    it("Should return 0 if parameter is an empty list") {
      warOfNumbers(List()) mustBe 0
    }
    it("Should return x if x is the only number in the list") {
      warOfNumbers(List(1)) mustBe 1
    }

    it("Should return x - y if x and y are the only numbers in the list and x > y") {
      warOfNumbers(List(20, 11)) mustBe 9
    }

    it("Should return y - x if x and y are the only numbers in the list and x < y") {
      warOfNumbers(List(127, 192)) mustBe 65
    }

    it("Returns the absolute sum of all the odd numbers subtract all the even numbers when odd.sum > even.sum") {
      warOfNumbers(List(11, 13, 15, 2, 4, 6)) mustBe 27
    }

    it("Returns the absolute sum of all the even numbers subtract all the odd numbers when odd.sum < even.sum") {
      warOfNumbers(List(1, 3, 5, 12, 14, 16)) mustBe 33
    }

    it("Returns 0 when the odds.sum == evens.sum") {
      warOfNumbers(List(12, 11, 1, 18, 7, 5, 1, 5)) mustBe 0
    }
  }
}