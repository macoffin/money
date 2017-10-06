/**
  * Created by marie on 10/4/17.
  */
package main

case class Family(
                 familyName: String,
                 members: Seq[Actor]
                 ) {
  def getMonthlyIncome = members.map(m => m.monthlyIncome).sum

}
