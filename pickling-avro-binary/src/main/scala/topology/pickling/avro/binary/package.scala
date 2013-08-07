package topology.pickling.avro

package object binary {

  implicit val pickleFormat: AvroBinaryPickleFormat =
    new AvroBinaryPickleFormat

}