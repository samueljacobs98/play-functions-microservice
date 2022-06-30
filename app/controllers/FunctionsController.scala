package controllers

import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}

import javax.inject.{Inject, Singleton}
import models._
import utils.FunctionsUtils._
import play.api.libs.json._
import utils.GenFun.genFun

@Singleton
class FunctionsController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def getNoContent: Action[AnyContent] = Action(NoContent)

  def getLongestConsec: Action[AnyContent] = Action { implicit request =>
    genFun[LongestConsecParams](request, longestConsecRecurse, Json.format[LongestConsecParams])
  }

  def getNumberOfDays: Action[AnyContent] = Action { implicit request =>
    genFun[NumberOfDaysParams](request, numberOfDaysRec, Json.format[NumberOfDaysParams])
  }

  def getWarOfNumbers: Action[AnyContent] = Action { implicit request =>
    genFun[WarOfNumbersParams](request, warOfNumbers, Json.format[WarOfNumbersParams])
  }
}
