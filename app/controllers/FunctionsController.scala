package controllers

import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}

import javax.inject.{Inject, Singleton}
import models._
import utils.FunctionsUtils._
import play.api.libs.json._
import utils.ParametersUtils._

@Singleton
class FunctionsController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def getNoContent: Action[AnyContent] = Action(NoContent)

  def getLongestConsec: Action[AnyContent] = Action { implicit request =>
    val maybeParams = getMaybeParams[LongestConsecParams](request, Json.format[LongestConsecParams])

    maybeParams match {
      case Some(params) =>
        val ans = longestConsecRecurse(params.strArr.toArray, params.k)
        Ok(Json.toJson(ans))
      case None => BadRequest
    }
  }

  def getNumberOfDays: Action[AnyContent] = Action { implicit request =>
    val maybeParams = getMaybeParams[NumberOfDaysParams](request, Json.format[NumberOfDaysParams])

    maybeParams match {
      case Some(params) =>
        val ans = numberOfDaysRec(params.cost, params.savingsStart, params.offset)
        Ok(Json.toJson(ans))
      case None => BadRequest
    }
  }

  def getWarOfNumbers: Action[AnyContent] = Action { implicit request =>
    val maybeParams = getMaybeParams[WarOfNumbersParams](request, Json.format[WarOfNumbersParams])

    maybeParams match {
      case Some(params) =>
        val ans = warOfNumbers(params.list)
        Ok(Json.toJson(ans))
      case None => BadRequest
    }
  }
}
