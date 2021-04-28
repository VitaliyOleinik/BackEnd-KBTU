import scala.concurrent.Future

trait TodoRepository {
  // future -> в будущем будет список to do
  def all(): Future[Seq[Todo]] // all to do

  def done(): Future[Seq[Todo]] // if it done

  def pending(): Future[Seq[Todo]] // in process
}