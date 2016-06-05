package cruddysimple

trait ContactDao {
  def getContacts: List[Contact]
  def getContact(id: Long): Option[Contact]
  def updateContact(contact: Contact): Option[Contact]
  def insertContact(contactForm: ContactForm): Contact
}
