import pixelo._

object scratch {
  Solver.possibilities(new LineDesc(Row, 0, Array(10, 5))).foreach(println(_))
                                                  //> Vector(_, _, _, _, O, O, O, O, O, O, O, O, O, O, _, O, O, O, O, O)
                                                  //| Vector(_, _, _, O, O, O, O, O, O, O, O, O, O, _, _, O, O, O, O, O)
                                                  //| Vector(_, _, _, O, O, O, O, O, O, O, O, O, O, _, O, O, O, O, O, _)
                                                  //| Vector(_, _, O, O, O, O, O, O, O, O, O, O, _, _, _, O, O, O, O, O)
                                                  //| Vector(_, _, O, O, O, O, O, O, O, O, O, O, _, _, O, O, O, O, O, _)
                                                  //| Vector(_, _, O, O, O, O, O, O, O, O, O, O, _, O, O, O, O, O, _, _)
                                                  //| Vector(_, O, O, O, O, O, O, O, O, O, O, _, _, _, _, O, O, O, O, O)
                                                  //| Vector(_, O, O, O, O, O, O, O, O, O, O, _, _, _, O, O, O, O, O, _)
                                                  //| Vector(_, O, O, O, O, O, O, O, O, O, O, _, _, O, O, O, O, O, _, _)
                                                  //| Vector(_, O, O, O, O, O, O, O, O, O, O, _, O, O, O, O, O, _, _, _)
                                                  //| Vector(O, O, O, O, O, O, O, O, O, O, _, _, _, _, _, O, O, O, O, O)
                                                  //| Vector(O, O, O, O, O, O, O, O, O, O, _, _, _, _, O, O, O, O, O, _)
                                                  //| Vector(O, O, O, O, O, O, O, O, O, O, _, _, _, O, O, O, O, O, _, _)
                                                  //| Vector(O, O, O, O, O, O, O, O, O, O, _, _, O, O, O, O, O, _, _, _)
                                                  //| Ve
                                                  //| Output exceeds cutoff limit.
  
}