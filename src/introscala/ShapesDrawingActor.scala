object Messages{
object Exit
object Finished
case class Response(message: String)
}

import akka.actor.Actor

class ShapesDrawingActor extends Actor{
	import Messages._

	def receive={
		case s: Shape=>
		s.draw(str=>println(s"SapesDrawingActor:$str"))
		sender ! Response(s"ShapesDrawingActor: $s drawn")
		case Exit =>
		println(s"ShapeDrawingActor: exiting...")
		sender ! Finished
		case unexpected=>//그 밖의 경우에는 "unexpected: Any"와 같음
		val response = Response(s"ERROR:Unkown message:$unexpected")
		println(s"ShapesDrawingActor:$response")
		sender ! response
	}
}
