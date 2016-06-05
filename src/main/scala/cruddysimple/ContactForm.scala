package cruddysimple

import _root_.argonaut._
import _root_.argonaut.Argonaut._
import org.http4s.argonaut._
import org.http4s.{ EntityDecoder, EntityEncoder }

case class ContactForm(name: String, surname: String, address: String, email: String)

object ContactForm {
  implicit val ContactFormCodecJson: CodecJson[ContactForm] =
    casecodec4(ContactForm.apply, ContactForm.unapply)("name", "surname", "address", "email")

  implicit val ContactFormEntityDecoder: EntityDecoder[ContactForm] = jsonOf[ContactForm]
  implicit val ContactFormEntityEncoder: EntityEncoder[ContactForm] = jsonEncoderOf[ContactForm]
}
