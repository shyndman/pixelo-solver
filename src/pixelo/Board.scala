package pixelo

class Board(val size: Int) {  
  val cells = Array.fill[CellType](size, size) { Empty }
  val rowDescs = Array.ofDim[LineDesc](size)
  val colDescs = Array.ofDim[LineDesc](size)
  
  def row(i: Int): Array[CellType] = cells(i)
  def col(i: Int): Array[CellType] = cells.map(_(i))
 
  def update(i: Int, j: Int, c: CellType) = cells(i)(j) = c 
  
  def rowDesc(i: Int, blocks: Int*) = rowDescs(i) = new LineDesc(Row, i, blocks.toArray)
  def colDesc(i: Int, blocks: Int*) = colDescs(i) = new LineDesc(Col, i, blocks.toArray)
  
  override def toString = {
    cells.map((row: Array[CellType]) => row.mkString("")).mkString("\n")
  }
}


