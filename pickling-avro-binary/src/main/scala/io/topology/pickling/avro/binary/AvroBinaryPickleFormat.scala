package io.topology.pickling.avro.binary

import scala.pickling._
import scala.reflect.runtime.universe._

import akka.util.ByteString

class AvroBinaryPickleFormat extends PickleFormat {
  type PickleType = AvroBinaryPickle
  type OutputType = EncodingOutput[ByteString]
  def createBuilder() = new AvroBinaryPickleBuilder(this, null)
  def createBuilder(out: EncodingOutput[ByteString]): PBuilder = new AvroBinaryPickleBuilder(this, out)
  def createReader(pickle: AvroBinaryPickle, mirror: Mirror) = ??? // TODO: create reader
}