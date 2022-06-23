package utils

import play.api.libs.json.{JsValue, Json, OFormat}
import play.api.mvc.{AnyContent, Request}

object ParametersUtils {
  def parseBody(request: Request[AnyContent]): Option[JsValue] =
    request.body.asJson

  def getMaybeParams[A](request: Request[AnyContent], implicitVal: OFormat[A]): Option[A] = {
    val jsonObject = request.body.asJson
    jsonObject.flatMap(Json.fromJson[A](_)(implicitVal).asOpt)
  }
}
