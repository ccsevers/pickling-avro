package topology.pickling.avro.binary

import scala.pickling._
import java.nio.ByteBuffer

case class AvroBinaryPickle(value: ByteBuffer) extends Pickle {
  type ValueType = ByteBuffer
  type PickleFormatType = AvroBinaryPickleFormat
}
