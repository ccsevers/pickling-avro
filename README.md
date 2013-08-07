# pickling-avro

## Usage (planned)

```scala
import scala.pickling._
import io.topology.pickling.avro.binary_

// a simple ADT for people
case class Person(name: String, age: Int)

// generate an Avro schema for type Person
val personSchema = implicitly[[SPickler[Person]].schema

// an instance of Person
val originalAlan = Person("Alan Turing", 42)

// serialize the instance
val bytes = originalAlan.pickle.value

// reconstitute 
val unpickledAlan = AvroBinaryPickle(bytes).unpickle[Person]

unpickledAlan == originalAlan  // true
```
