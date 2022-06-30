package utils

import play.api.mvc.{AnyContent, Request, Result}
import play.api.libs.json._
import play.api.mvc.Results.{BadRequest, Ok}
import utils.ParametersUtils._

object GenFun {
  def genFun[A](request: Request[AnyContent], f: A => JsValue, formatted: OFormat[A]): Result = {
    val maybeParams = getMaybeParams[A](request, formatted)

    maybeParams match {
      case Some(params) =>
        val ans: JsValue = f(params)
        Ok(ans)
      case None => BadRequest
    }
  }
}
