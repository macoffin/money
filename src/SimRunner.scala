/**
  * Created by marie on 10/4/17.
  */

package Money
import java.time.LocalDate
import java.time.format.DateTimeFormatter

import scala.collection.immutable.Range.Inclusive

object SimRunner extends App{

  def runSim(family: Family, monthlySpend: Double, simYears: Int) = {
    val nMonths: Int = simYears * 12

    val monthIndex = (1 to nMonths).toList
    monthIndex.foreach{m =>
      val income = family.getMonthlyIncome
      println("Income: " + income)
    }

  }

  val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

  /*  Create the family  */

  val dwight = Actor(
    name="Dwight",
    birthDate = LocalDate.parse("1954-08-04", formatter),
    monthlyIncome = 5000.0
  )

  val marie = Actor(
    name="Marie",
    birthDate = LocalDate.parse("1962-12-21", formatter),
    monthlyIncome=5000.0
  )

  val theresa = Actor(
    name="Theresa",
    birthDate = LocalDate.parse("1960-03-24", formatter),
    monthlyIncome = 0.0
  )

  val fryeFamily = Family("Frye", Seq(dwight, theresa, marie))

  /*  Read in the event file for the family */

  val monthlySpend = 8000.0

  val simulationYears = 10 //Just to try it out

  runSim(family=fryeFamily, monthlySpend, simulationYears)
}
