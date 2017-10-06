/**
  * Created by marie on 10/4/17.
  */
package main

case class RetirementFund(
                         fundName: String,
                         fundBalance: Double
                         ) {

  def withdrawPrinciple(amount: Double) = {
    val newBalance = fundBalance - amount
    copy(fundBalance = newBalance)
  }

  def invest(amount: Double) = {
    val newBalance = this.fundBalance + amount
    this.copy(fundBalance = newBalance)
  }

  def accrueValue(pct: Double) = {
    val newBalance = fundBalance * (1 + pct)
    copy(fundBalance = newBalance)
  }
}
