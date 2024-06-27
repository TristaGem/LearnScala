case class Person(var username: String, var password: String) {
    var age = 0
    var firstName = ""
    var lastName = ""

    var address = None: Option[Address]
}

case class Address(city: String, state: String, zip: String)

object Test extends App {
    val p = Person("alivina", "secret")
    p.address = Some(Address("Lynnwood", "Washington", "98087"))

}