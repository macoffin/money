/**
  * Created by marie on 10/4/17.
  */
package main

import java.time.LocalDate

class Actor(name: String, birthDate: LocalDate, initialIncome: Double) {

  private var monthlyIncome = initialIncome

  def updateIncome(newIncome: Double) = {
    monthlyIncome = newIncome
  }

  def getIncome = monthlyIncome
}
