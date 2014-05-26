sealed trait CellType { def str: String }
case object Filled extends CellType {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(95);  def str = "o" };System.out.println("""str: => String""")}
case object X extends CellType { def str = "x" }
case object Empty extends CellType { def str= " " }

class Board {
  val cells = Array.ofDim[CellType](20, 20)
  
  override def toString = {
    cells.map((row: Array[CellType]) => row.mkString("")).mkString("\n")
  }
}


object scratch {
  println("123")
}
