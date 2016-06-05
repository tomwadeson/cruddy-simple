package cruddysimple

import java.util.concurrent.atomic.AtomicLong

import scala.collection.concurrent.TrieMap

object ContactDaoMapImpl extends ContactDao {

  val store = new TrieMap[Long, Contact]()
  val idSequence = new AtomicLong(0)

  override def getContacts: List[Contact] = store.values.toList

  override def getContact(id: Long): Option[Contact] = store.get(id)

  override def updateContact(contact: Contact): Option[Contact] = {
    if (store.contains(contact.id)) {
      store.put(contact.id, contact)
      Some(contact)
    } else {
      None
    }
  }

  override def insertContact(contactForm: ContactForm): Contact = {
    val id = idSequence.incrementAndGet()
    val contact = Contact(id, contactForm.name, Option(contactForm.surname), Option(contactForm.address), Option(contactForm.email))
    store.put(id, contact)
    contact
  }
}
