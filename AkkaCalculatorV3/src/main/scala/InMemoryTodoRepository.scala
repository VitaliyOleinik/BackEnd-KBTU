import java.util.UUID
import scala.concurrent.{ExecutionContext, Future}

class InMemoryTodoRepository(initialTodos:Seq[Todo] = Seq.empty)(implicit ec:ExecutionContext) extends TodoRepository {

  private var todos: Vector[Todo] = initialTodos.toVector

  override def all(): Future[Seq[Todo]] = Future.successful(todos)

  override def done(): Future[Seq[Todo]] = Future.successful(todos.filter(_.done))

  override def pending(): Future[Seq[Todo]] = Future.successful(todos.filterNot(_.done))

  override def create(createTodo: CreateTodo): Future[Todo] =
    Future.successful {
      val todo = Todo(
        id = UUID.randomUUID().toString,
        title = createTodo.title,
        description = createTodo.description,
        done = false
      )
      todos = todos :+ todo
      todo
    }

  override def update(updateTodo: UpdateTodo): Future[Todo] =
    todos.find(_.id == updateTodo.id) match {
      case Some(_) =>
        Future.successful {
          val currentTodo = todos.find(_.id == updateTodo.id).get
          val index = todos.indexOf(currentTodo)
          val newTodo = Todo(
            id = currentTodo.id,
            title = updateTodo.title match {
              case Some(value) => value
              case None => currentTodo.title
            },
            description = updateTodo.description match {
              case Some(value) => value
              case None => currentTodo.description
            },
            done = updateTodo.done match {
              case Some(value) => value
              case None => currentTodo.done
            }
          )
          todos = todos.updated(index, newTodo)
          newTodo
        }
    }
}