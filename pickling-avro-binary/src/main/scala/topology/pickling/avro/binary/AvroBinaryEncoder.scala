package topology
package pickling.avro.binary

import scala.pickling.Output
import java.nio.ByteBuffer

import org.apache.avro.io.{ EncoderFactory, DirectBinaryEncoder }

/**
  * Not thread-safe!
  */
class AvroBinaryEncoder extends Output[ByteBuffer] {

  private val buffer = ByteBuffer.allocate(256)

  private val bufferOutputStream = new ByteBufferOutputStream(buffer)

  import AvroBinaryEncoder.{ apacheEncoderFactory => factory }
  private val apacheEncoder = factory.directBinaryEncoder(
    bufferOutputStream,
    null // the encoder to (not) re-use
  )

  def put(bs: ByteBuffer): this.type = {
    buffer put bs
    this
  }

  def result(): ByteBuffer = buffer.asReadOnlyBuffer

  final val trueByte = 1.toByte
  final val falseByte = 0.toByte

  def writeBoolean(value: Boolean): Unit =
    writeByte(if (value) trueByte else falseByte)

  def writeNull(): Unit = { /* does nothing */ }

  def writeByte(value: Byte): Unit = buffer put value

  def writeBytes(bytes: Seq[Byte]): Unit = buffer put bytes.toArray

  def writeBytes(bytes: Array[Byte]): Unit = buffer put bytes

  def writeString(value: String): Unit = apacheEncoder writeString value

  def writeChar(value: Char): Unit = apacheEncoder writeInt value.toInt

  def writeShort(value: Short): Unit = apacheEncoder writeInt value.toInt

  def writeInt(value: Int): Unit = apacheEncoder writeInt value

  def writeLong(value: Long): Unit = apacheEncoder writeLong value

  def writeFloat(value: Float): Unit = apacheEncoder writeFloat value

  def writeDouble(value: Double): Unit = apacheEncoder writeDouble value

}

object AvroBinaryEncoder {
  private[topology] val apacheEncoderFactory = EncoderFactory.get()
}