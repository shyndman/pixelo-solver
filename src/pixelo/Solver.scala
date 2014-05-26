package pixelo

import scala.collection.mutable.Queue
import scala.collection.mutable.Map
import scala.collection.mutable.Buffer
import scala.collection.mutable.Set

object Solver {
  
  def addBlock(line: Vector[CellType], pos: Int, block: Int): Vector[CellType] =
    line.padTo(pos, Empty) ++ Vector.fill(block)(Filled)
  
  def possibilities(b: Board, desc: LineDesc): Vector[Vector[CellType]] = {
    def iter(pos: Int, blocks: Array[Int], acc: Vector[Vector[CellType]]): Vector[Vector[CellType]] = {
      if (blocks.isEmpty) 
        acc.map(_.padTo(b.size, Empty)) 
      else if (pos + (blocks.sum + blocks.length - 1) > b.size)
        Vector()
      else {
        // generate block added array
        val blockAdded = 
          if (acc.isEmpty)
            Vector(addBlock(Vector(), pos, blocks.head))
          else
            acc.map(addBlock(_, pos, blocks.head))
          
        iter(pos + 1, blocks, acc) ++ // skip cell 
        iter(pos + blocks.head + 1, blocks.tail, blockAdded) 
      }
    }
    
    iter(0, desc.blocks, Vector())
  }
  
  def solve(b: Board): Board = {
    var steps = 0
    val rowPoss = Buffer(b.rowDescs.map((desc) => (desc, possibilities(b, desc))): _*)
    val colPoss = Buffer(b.colDescs.map((desc) => (desc, possibilities(b, desc))): _*)
    val q = (new Queue) ++= b.colDescs ++= b.rowDescs
    val incomplete = Set() ++= b.colDescs ++= b.rowDescs 
    
    while (!q.isEmpty) {
      val desc = q.dequeue
      
      // 1. get line from board, and possibilities for desc
      
      val (boardLine, thisSidePoss, otherSidePoss, linePoss) = 
        if (desc.descType == Row)
          (b.row(desc.idx), rowPoss, colPoss, rowPoss(desc.idx)._2)
        else
          (b.col(desc.idx), colPoss, rowPoss, colPoss(desc.idx)._2)
      
      // 2. filter all possibilities where a filled overlaps an exclude, or
      //    a board filled overlaps a possibility empty
      
      val filteredPoss =
        linePoss.filterNot(poss => {
          poss.view.zipWithIndex.exists(e => {
            (boardLine(e._2) == Excluded && e._1 == Filled) ||
            (boardLine(e._2) == Filled && e._1 == Empty)
          })
        })
      
      thisSidePoss(desc.idx) = (desc, filteredPoss)
      
      // 3. mark all cells where every possibility is filled as filled 
      //    in the board (enqueuing all incident lines)

      def markCell(i: Int, outType: CellType) = {
        boardLine(i) = outType
        if (desc.descType == Col)
          b(i, desc.idx) = outType 
        else 
          b(desc.idx, i) = outType
      }
      
      def markCells(pred: Int => Boolean, outType: CellType) =
        q ++= 
          (0 until b.size)
            .view
            .filter(boardLine(_) != outType)
            .filter(pred)
            .map(i => { // not really a map -- it's a tap
              markCell(i, outType)              
              i 
              })
            .map(i => i)
            .map(i => otherSidePoss(i)._1)
      
      def typeInAllPossibilities(cellType: CellType): Int => Boolean =
        (i) => linePoss.forall(_(i) == cellType)
            
      markCells(typeInAllPossibilities(Filled), Filled)
      
      if ((incomplete contains desc) && boardLine.filter(_ == Filled).length == desc.fillCount) {
        println(desc, "Filling with excludes")
        incomplete -= desc
        markCells((i) => boardLine(i) == Empty, Excluded)
      } else {
        markCells(typeInAllPossibilities(Empty), Excluded)
      }
      
      steps += 1
      
      if (q.isEmpty)
        q ++= incomplete
    }
    
    println(s"Still incomplete ${incomplete.size}")
    println(s"Solved in $steps steps")
    
    b
  }
}