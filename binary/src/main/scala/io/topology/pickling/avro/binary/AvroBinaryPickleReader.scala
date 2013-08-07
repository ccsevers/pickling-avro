package io.topology.pickling.avro.binary

import scala.reflect.runtime.universe._
import scala.pickling._
import akka.util.ByteString

class AvroBinaryPickleReader(
    bytes: ByteString,
    val mirror: Mirror,
    format: AvroBinaryPickleFormat) extends PReader with PickleTools {

  def beginEntryNoTag(): String = {
    // TODO
    ???
  }

  def beginEntry(): FastTypeTag[_] = {
    // TODO
    ???
  }

  def atPrimitive: Boolean = {
    // TODO
    ???
  }

  def readPrimitive(): Any = {
    // TODO
    ???
  }

  def atObject: Boolean = !atPrimitive

  def readField(name: String): AvroBinaryPickleReader = {
    this
  }

  def endEntry(): Unit = {
    // TODO
  }

  def beginCollection(): PReader = this

  def readLength(): Int = {
    // TODO
    ???
  }

  def readElement(): PReader = this

  def endCollection(): Unit = {
    // TODO
  }

}