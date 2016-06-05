package cruddysimple

import _root_.argonaut._
import _root_.argonaut.Argonaut._
import org.http4s.argonaut._
import org.http4s.{ EntityDecoder, EntityEncoder }

case class Contact(id: Long, name: String, surname: Option[String], address: Option[String], email: Option[String])

object Contact {
  implicit val ContactCodecJson: CodecJson[Contact] =
    casecodec5(Contact.apply, Contact.unapply)("id", "name", "surname", "address", "email")

  implicit val ContactEntityDecoder: EntityDecoder[Contact] = jsonOf[Contact]
  implicit val ContactEntityEncoder: EntityEncoder[Contact] = jsonEncoderOf[Contact]
  implicit val ContactListEntityEncoder: EntityEncoder[List[Contact]] = jsonEncoderOf[List[Contact]]
}
