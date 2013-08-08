package topology.pickling.avro.binary

import scala.pickling._
import scala.reflect.runtime.universe._

import org.slf4j.LoggerFactory

/**
  * Not thread-safe!
  */
class AvroBinaryPickleBuilder(format: AvroBinaryPickleFormat, encoder: AvroBinaryEncoder = new AvroBinaryEncoder)
    extends PBuilder
    with PickleTools {

  import format._

  val log = LoggerFactory.getLogger(getClass.getName)
  import log._

  private var currentEntryType: Type = _

  def beginEntry(value: Any): this.type = withHints { hints =>
    debug("{}.beginEntry({})", getClass.getName, value)
    debug("\twhere hints.tag.tpe = {}", hints.tag.tpe)

    currentEntryType = hints.tag.tpe

    if (value == null) encoder.writeNull()
    else value match {
      case _: Unit    => encoder.writeNull()
      case v: Byte    => encoder writeByte (v)
      case v: Boolean => encoder.writeBoolean(v)
      case v: String  => encoder.writeString(v)
      case v: Char    => encoder.writeChar(v)
      case v: Short   => encoder.writeShort(v)
      case v: Int     => encoder.writeInt(v)
      case v: Long    => encoder.writeLong(v)
      case v: Float   => encoder.writeFloat(v)
      case v: Double  => encoder.writeDouble(v)
      case v: Any     => beginComplex(v, hints)
    }

    this
  }

  protected def beginComplex(value: Any, hints: Hints) {
    // TODO
  }

  def putField(name: String, pickler: this.type => Unit): this.type = {
    debug("{}.putField({}, {})", getClass.getName, name, pickler)
    // TODO
    this
  }

  def endEntry(): Unit = {
    debug("{}.endEntry()", getClass.getName)
    // TODO
  }

  def beginCollection(length: Int): this.type = {
    debug("{}.beginCollection({})", getClass.getName, length)
    // TODO
    this
  }

  def putElement(pickler: this.type => Unit): this.type = {
    debug("{}.putElement({})", getClass.getName, pickler)
    // TODO
    this
  }

  def endCollection(l: Int): Unit = {
    debug("{}.endCollection({})", getClass.getName, l)
    // TODO
  }

  def result(): AvroBinaryPickle = {
    debug("{}.result()", getClass.getName)
    AvroBinaryPickle(encoder.result)
  }

}