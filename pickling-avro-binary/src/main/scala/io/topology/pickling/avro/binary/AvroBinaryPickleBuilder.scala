package io.topology.pickling.avro.binary

import scala.pickling._
import scala.reflect.runtime.universe._

import akka.util.{ ByteString, ByteStringBuilder }

class AvroBinaryPickleBuilder(format: AvroBinaryPickleFormat, out: EncodingOutput[ByteString])
    extends PBuilder
    with PickleTools {

  private val builder = new ByteStringBuilder

  def beginEntry(picklee: Any): this.type = withHints { hints =>
    // TODO
    this
  }

  def putField(name: String, pickler: this.type => Unit): this.type = {
    // TODO
    this
  }

  def endEntry(): Unit = {
    // TODO
  }

  def beginCollection(length: Int): this.type = {
    // TODO
    this
  }

  def putElement(pickler: this.type => Unit): this.type = {
    // TODO
    this
  }

  def endCollection(l: Int): Unit = {
    // TODO
  }

  def result(): AvroBinaryPickle = AvroBinaryPickle(builder.result)

}