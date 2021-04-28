import scala.concurrent.{ExecutionContext, Future}
//                                   default = sequence = empty
class InMemoryTodoRepository(initialTodos:Seq[Todo] = Seq.empty)(implicit ec:ExecutionContext) extends TodoRepository {

  private var todos: Vector[Todo] = initialTodos.toVector

  override def all(): Future[Seq[Todo]] = Future.successful(todos)

  override def done(): Future[Seq[Todo]] = Future.successful(todos.filter(_.done)) // _.done -> all of objects, their done

  override def pending(): Future[Seq[Todo]] = Future.successful(todos.filterNot(_.done))
}