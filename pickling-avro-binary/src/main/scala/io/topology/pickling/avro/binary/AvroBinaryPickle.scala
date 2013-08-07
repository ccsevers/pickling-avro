package io.topology.pickling.avro.binary

import scala.pickling._
import akka.util.ByteString

case class AvroBinaryPickle(value: ByteString) extends Pickle {
  type ValueType = ByteString
  type PickleFormatType = AvroBinaryPickleFormat
}
