package pixelo

sealed trait CellType { 
  val str: String 
  override def toString() = str
}
case object Filled extends CellType { val str = "■" }
case object Excluded extends CellType { val str = " " }
case object Empty extends CellType { val str= " " }