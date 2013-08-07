package topology.pickling.avro.binary

import scala.pickling.EncodingOutput
import akka.util.{ ByteString, ByteStringBuilder }

class AvroBinaryEncoder extends EncodingOutput[ByteString] {

  private val builder = new ByteStringBuilder

  def put(bs: ByteString): this.type = {
    builder append bs
    this
  }

  def result(): ByteString = builder.result

  def writeByte(value: Byte): Unit = {
    builder putByte value
  }

  def writeBoolean(value: Boolean): Unit = writeByte(
    if (value) 1.toByte
    else 0.toByte
  )

  def writeLong(value: Long): Unit = {
    // TODO: write variable-length zig-zag encoded integer
  }

  def writeString(value: String): Unit = {
    // TODO: write string as UTF-8 encoded bytes
  }

  def writeFloat(value: Float): Unit = {
    // TODO: write float as 4 bytes
  }

  def writeDouble(value: Double): Unit = {
    // TODO: write double as 8 bytes
  }

  def encodeByteAtEnd(pos: Int, value: Byte): Unit = writeByte(value)
  def encodeShortAtEnd(pos: Int, value: Short): Unit = writeLong(value.toLong)
  def encodeCharAtEnd(pos: Int, value: Char): Unit = writeLong(value.toLong)
  def encodeIntAtEnd(pos: Int, value: Int): Unit = writeLong(value.toLong)
  def encodeLongAtEnd(pos: Int, value: Long): Unit = writeLong(value)
  def encodeByteTo(pos: Int, value: Byte): Int = {
    writeByte(value)
    0
  }
  def encodeIntTo(pos: Int, value: Int): Int = {
    writeLong(value.toLong)
    0
  }
  def encodeStringTo(pos: Int, value: String): Int = {
    writeString(value)
    0
  }
  def encodeBooleanTo(pos: Int, value: Boolean): Int = {
    writeBoolean(value)
    0
  }

  // unsupported
  def encodeIntArrayTo(pos: Int, ia: Array[Int]): Int = ???
  def copyTo(pos: Int, bytes: Array[Byte]): Int = ???
  def decodeByteFrom(pos: Int): (Byte, Int) = ???
  def decodeShortFrom(pos: Int): (Short, Int) = ???
  def decodeCharFrom(pos: Int): (Char, Int) = ???
  def decodeIntFrom(pos: Int): (Int, Int) = ???
  def decodeLongFrom(pos: Int): (Long, Int) = ???
  def decodeStringFrom(pos: Int): (String, Int) = ???
  def decodeBooleanFrom(pos: Int): (Boolean, Int) = ???
  def decodeIntArrayFrom(pos: Int): (Array[Int], Int) = ???
}
