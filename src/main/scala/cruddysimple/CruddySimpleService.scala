package cruddysimple

import org.http4s._
import org.http4s.dsl._

object CruddySimpleService {
  val service = HttpService {
    case GET -> Root => Ok("Hello, World!")
  }
}
