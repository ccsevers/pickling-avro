# pickling-avro

## Usage (planned)

```scala
package topology.pickling.avro.binary.tests

import scala.pickling._
import topology.pickling.avro.binary_
import akka.util.ByteString

// a simple ADT for people
case class Person(name: String, age: Int)

// generate an Avro schema for type Person
val personSchema = implicitly[[SPickler[Person]]].schema
/*
  {
    "name": "Person",
    "type": "record",
    "fields": [
      {"name": "name", "type": "string"},
      {"name": "age", "type": "int"}
    ],
    "namespace": "topology.pickling.avro.binary.tests"
  }
*/

// an instance of Person
val originalAlan = Person("Alan Turing", 42)

// serialize the instance
val pickle = originalAlan.pickle
val bytes: ByteString = pickle.value

// reconstitute the instance
val unpickledAlan = AvroBinaryPickle(bytes).unpickle[Person]

unpickledAlan == originalAlan  // evaluates to `true`
```


## Reference
1. [Current Apache Avro Specification](http://avro.apache.org/docs/current/spec.html)
1. [Scala Pickling](http://lampwww.epfl.ch/~hmiller/pickling)


## Legal
Apache Avro is a trademark of The Apache Software Foundation.

pickling-avro-binary is distributed under the BSD 2-Clause License, the text of which follows:

Copyright (c) 2013, Connor Doyle  
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

- Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.

- Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
