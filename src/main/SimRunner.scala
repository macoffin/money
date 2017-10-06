/**
  * Created by marie on 10/4/17.
  */

package main

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object SimRunner extends App{

  // This is the function that actually runs the simulation.

  def runSim(family: Family, retFunds: Seq[RetirementFund], monthlySpend: Double, simYears: Int) = {
    val nMonths: Int = simYears * 12
    val nFunds = retFunds.length
    val investmentPerFund = 100.0/nFunds
    val nAccrualsPerYear = 4
    val interestRate = 0.03
    val accrualRate = interestRate/nAccrualsPerYear

    val monthIndex = (1 to nMonths).toList
    monthIndex.foreach{m =>
      //println(investmentPerFund)
      val income = family.getMonthlyIncome
      retFunds.head.invest(100)
      retFunds.map{r => r.invest(investmentPerFund)}
      if (m % 4 == 0) retFunds.map{ r => r.accrueValue(accrualRate)}
      if (m % 12 == 0) {
        val investmentBalance =  retFunds.map(r => r.fundBalance).sum
        println("Current retirement fund balance is " + investmentBalance)
      }
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

  val retirementFund = RetirementFund("Generic fund", 1200000.0)

  /*  Read in the event file for the family */

  val monthlySpend = 8000.0

  val simulationYears = 10 //Just to try it out

  runSim(family=fryeFamily, Seq(retirementFund), monthlySpend, simulationYears)
}
