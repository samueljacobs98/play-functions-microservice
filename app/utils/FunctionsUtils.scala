package utils

import models.{LongestConsecParams, NumberOfDaysParams, WarOfNumbersParams}
import play.api.libs.json.{JsValue, Json}

import scala.annotation.tailrec

object FunctionsUtils {
  private def getString(strArr: Array[String], n: Int): String =
    (for (i <- 0 until n) yield strArr(i)).mkString

  def longestConsecRecurse(params: LongestConsecParams): JsValue = {
    val (strarr, k) = (params.strArr, params.k)
    @tailrec
    def go(strarr: Array[String], k: Int, cur: String): String = {
      if (strarr.length < k) cur
      else if (getString(strarr, k).length > cur.length
      ) go(strarr.tail, k, getString(strarr, k))
      else go(strarr.tail, k, cur)
    }
    val len = strarr.length
    Json.toJson(if (len < k || len == 0 || k == 0 ) "" else go(strarr, k, ""))
  }

  def numberOfDaysRec(params: NumberOfDaysParams): JsValue = {
    val (cost, savingsStart, offset) = (params.cost, params.savingsStart, params.offset)
    @tailrec
    def go(savings: Int, day: Int, week: Int): Int = {
      if (savings >= cost) day
      else {
        val newSavings = savings + offset + day % 7 + week
        val newWeek = if (day % 7 == 0) week + 1 else week
        go(newSavings, day + 1, newWeek)
      }
    }
    Json.toJson(go(savingsStart, 1, 0) - 1)
  }

  def warOfNumbers(params: WarOfNumbersParams): JsValue = {
    val list = params.list
    val (odds, evens) = list.partition(_ % 2 == 1)
    Json.toJson(Math.abs(odds.sum - evens.sum))
  }
}
