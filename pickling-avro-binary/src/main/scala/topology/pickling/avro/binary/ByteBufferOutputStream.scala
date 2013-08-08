package topology.pickling.avro.binary

import java.io.OutputStream
import java.nio.ByteBuffer

class ByteBufferOutputStream(buffer: ByteBuffer) extends OutputStream {

  val log = org.slf4j.LoggerFactory.getLogger(getClass.getName)

  def write(value: Int): Unit = {
    log.debug("write({})", value)
    buffer put value.toByte
  }

  override def write(bytes: Array[Byte], offset: Int, length: Int): Unit = {
    log.debug("write({})", bytes)
    buffer.put(bytes, offset, length)
  }

  override def write(bytes: Array[Byte]): Unit = {
    log.debug("write({})", bytes)
    buffer put bytes
  }

  override def flush(): Unit = { /* does nothing! */ }

  override def close(): Unit = { /* does nothing! */ }

}