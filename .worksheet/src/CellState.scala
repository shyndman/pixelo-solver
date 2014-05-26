object CellState extends Enumeration {
  type WeekDay = Value;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(79); 
  val Mon = Value;System.out.println("""Mon  : CellState.Value = """ + $show(Mon ));$skip(43); 
  val Tue, Wed, Thu, Fri, Sat, Sun = Value;System.out.println("""Tue  : CellState.Value = """ + $show(Tue ));System.out.println("""Wed  : CellState.Value = """ + $show(Wed ));System.out.println("""Thu  : CellState.Value = """ + $show(Thu ));System.out.println("""Fri  : CellState.Value = """ + $show(Fri ));System.out.println("""Sat  : CellState.Value = """ + $show(Sat ));System.out.println("""Sun  : CellState.Value = """ + $show(Sun ))}
}

class Board {
}

object scratch {
  println("Welcome to the Scala worksheet")
}
