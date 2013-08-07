package topology.pickling.avro.binary

import scala.pickling._
import scala.reflect.runtime.universe.Mirror

import akka.util.ByteString

class AvroBinaryPickleFormat extends PickleFormat {

  type PickleType = AvroBinaryPickle
  type OutputType = EncodingOutput[ByteString]

  def createBuilder() = new AvroBinaryPickleBuilder(this)

  def createBuilder(out: EncodingOutput[ByteString]): PBuilder = out match {
    case encoder: AvroBinaryEncoder => new AvroBinaryPickleBuilder(this, encoder)
    case _                          => new AvroBinaryPickleBuilder(this)
  }

  def createReader(pickle: AvroBinaryPickle, mirror: Mirror) =
    new AvroBinaryPickleReader(pickle.value, mirror, this)

  // primitive keys
  val KEY_NULL = FastTypeTag.Null.key
  val KEY_BYTE = FastTypeTag.Byte.key
  val KEY_SHORT = FastTypeTag.Short.key
  val KEY_CHAR = FastTypeTag.Char.key
  val KEY_INT = FastTypeTag.Int.key
  val KEY_LONG = FastTypeTag.Long.key
  val KEY_BOOLEAN = FastTypeTag.Boolean.key
  val KEY_FLOAT = FastTypeTag.Float.key
  val KEY_DOUBLE = FastTypeTag.Double.key
  val KEY_UNIT = FastTypeTag.Unit.key

  // string keys
  val KEY_SCALA_STRING = FastTypeTag.ScalaString.key
  val KEY_JAVA_STRING = FastTypeTag.JavaString.key

  // primitive array keys
  val KEY_ARRAY_BYTE = FastTypeTag.ArrayByte.key
  val KEY_ARRAY_INT = FastTypeTag.ArrayInt.key
  val KEY_ARRAY_LONG = FastTypeTag.ArrayLong.key

  val primitives = Set(
    KEY_NULL, KEY_BYTE, KEY_SHORT, KEY_CHAR, KEY_INT,
    KEY_LONG, KEY_BOOLEAN, KEY_FLOAT, KEY_DOUBLE, KEY_UNIT,
    KEY_SCALA_STRING, KEY_JAVA_STRING,
    KEY_ARRAY_BYTE, KEY_ARRAY_INT, KEY_ARRAY_LONG
  )

  val nullablePrimitives = Set(
    KEY_NULL, KEY_SCALA_STRING, KEY_JAVA_STRING,
    KEY_ARRAY_BYTE, KEY_ARRAY_INT, KEY_ARRAY_LONG
  )

}