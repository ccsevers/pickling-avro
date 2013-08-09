package topology.pickling.avro.binary

import scala.reflect.runtime.universe._
import scala.pickling._

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
    // TODO
    this
  }

  def endEntry(): Unit = {
    // TODO
  }

  def beginCollection(): PReader = {
    // TODO
    this
  }

  def readLength(): Int = {
    // TODO
    ???
  }

  def readElement(): PReader = {
    // TODO
    this
  }

  def endCollection(): Unit = {
    // TODO
  }

}