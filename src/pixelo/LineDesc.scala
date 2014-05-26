package pixelo

sealed trait DescType { 
  val str: String 
  override def toString() = str
}
case object Row extends DescType { val str = "R" }
case object Col extends DescType { val str = "C" }

class LineDesc(val descType: DescType, val idx: Int, val blocks: Array[Int]) {
  
  def fillCount: Int = blocks.sum
  
  override def toString = s"$descType@$idx(${blocks.mkString(" ")})"
}
