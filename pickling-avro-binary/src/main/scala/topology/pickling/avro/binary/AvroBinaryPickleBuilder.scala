package topology.pickling.avro.binary

import scala.pickling._
import scala.reflect.runtime.universe._

import akka.util.{ ByteString, ByteStringBuilder }

import org.slf4j.LoggerFactory

class AvroBinaryPickleBuilder(format: AvroBinaryPickleFormat, encoder: AvroBinaryEncoder = new AvroBinaryEncoder)
    extends PBuilder
    with PickleTools {

  import format._

  val log = LoggerFactory.getLogger(getClass.getName)
  import log._

  private var currentEntryType: Type = _

  def beginEntry(picklee: Any): this.type = withHints { hints =>
    debug("{}.beginEntry({})", getClass.getName, picklee)
    debug("\twhere hints.tag.tpe = {}", hints.tag.tpe)

    currentEntryType = hints.tag.tpe
    // TODO

    this
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