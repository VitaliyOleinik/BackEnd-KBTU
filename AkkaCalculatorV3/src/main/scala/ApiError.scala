import akka.http.scaladsl.model.{StatusCode, StatusCodes}

final case class ApiError private(statusCode: StatusCode, message: String)

object ApiError {
  private def apply(statusCode: StatusCode, message: String): ApiError = new ApiError(statusCode, message)
  // один из вариантов ошибок
  val generic: ApiError = new ApiError(StatusCodes.InternalServerError, "Unknown error.")
  val emptyTitleField: ApiError = new ApiError(StatusCodes.BadRequest, message = "Empty title.")
  val emptyIdField: ApiError = new ApiError(StatusCodes.BadRequest, "Empty ID field.")
  val emptyDescriptionField: ApiError = new ApiError(StatusCodes.BadRequest, "Empty description.")
  val duplicateTitleField: ApiError = new ApiError(StatusCodes.BadRequest, "Title already exists.")
}