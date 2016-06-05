package cruddysimple

import org.http4s._
import org.http4s.dsl._

object CruddySimpleService {
  val contactDao: ContactDao = ContactDaoMapImpl

  val service = HttpService {
    case GET -> Root / "contacts" =>
      Ok(contactDao.getContacts)

    case GET -> Root / "contacts" / LongVar(id) =>
      contactDao.getContact(id).fold(NotFound())(Ok(_))

    case req @ POST -> Root / "contacts" =>
      req.decode[ContactForm] { form =>
        Created(contactDao.insertContact(form))
      }

    case req @ PUT -> Root / "contacts" / LongVar(id) =>
      req.decode[ContactForm] { form =>
        val contact = Contact(id, form.name, Option(form.surname), Option(form.address), Option(form.email))
        contactDao.updateContact(contact).fold(NotFound())(Ok(_))
      }
  }
}
