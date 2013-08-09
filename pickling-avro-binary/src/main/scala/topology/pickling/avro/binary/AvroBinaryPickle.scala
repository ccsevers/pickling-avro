package topology.pickling.avro.binary

import scala.pickling._

case class AvroBinaryPickle(value: ByteString) extends Pickle {
  type ValueType = ByteString
  type PickleFormatType = AvroBinaryPickleFormat
}
