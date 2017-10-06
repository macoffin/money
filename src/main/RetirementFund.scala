/**
  * Created by marie on 10/4/17.
  */
package main

class RetirementFund (fundName: String, startingBalance: Double) {

  private var fundBalance = startingBalance

  def withdrawPrinciple(amount: Double) = {
    fundBalance -= amount
  }

  def invest(amount: Double) = {
    fundBalance += amount
  }

  def accrueValue(pct: Double) = {
    fundBalance += fundBalance * pct
  }

  def getBalance = fundBalance
}
