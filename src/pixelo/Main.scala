package pixelo



object Main extends App {
  def time[A](a: => A) = {
    val now = System.nanoTime
    val result = a
    val micros = (System.nanoTime - now) / 1000
    println("%d microseconds".format(micros))
    result
  }
  
  
  val b = new Board(20)
  
  b.colDesc(0,  3)
  b.colDesc(1,  5, 1, 2)
  b.colDesc(2,  13, 2)
  b.colDesc(3,  1, 6, 2)
  b.colDesc(4,  1, 11, 1)
  b.colDesc(5,  1, 2, 4, 1)
  b.colDesc(6,  1, 1, 10, 1)
  b.colDesc(7,  6, 1, 1)
  b.colDesc(8,  6, 1, 5, 2)
  b.colDesc(9,  6, 3, 2)
  b.colDesc(10, 18)
  b.colDesc(11, 15)
  b.colDesc(12, 13)
  b.colDesc(13, 11)
  b.colDesc(14, 9, 1)
  b.colDesc(15, 5, 2)
  b.colDesc(16, 2)
  b.colDesc(17, 0)
  b.colDesc(18, 0)
  b.colDesc(19, 0)

  b.rowDesc(0,  7)
  b.rowDesc(1,  1, 6)
  b.rowDesc(2,  1, 9)
  b.rowDesc(3,  1, 2, 8)
  b.rowDesc(4,  1, 1, 9)
  b.rowDesc(5,  15)
  b.rowDesc(6,  6, 6)
  b.rowDesc(7,  6, 1, 6)
  b.rowDesc(8,  6, 6)
  b.rowDesc(9,  4, 10)
  b.rowDesc(10, 3, 1, 7)
  b.rowDesc(11, 1, 1, 1, 7)
  b.rowDesc(12, 1, 1, 1, 1, 4, 1)
  b.rowDesc(13, 1, 1, 1, 1, 3, 2)
  b.rowDesc(14, 3, 2, 2)
  b.rowDesc(15, 1, 1, 1)
  b.rowDesc(16, 2, 1)
  b.rowDesc(17, 2, 2)
  b.rowDesc(18, 8)
  b.rowDesc(19, 1, 1)
  
  println(time(Solver.solve(b)))
}