/**
  * Created by marie on 10/4/17.
  */
package Money
import java.time.LocalDate

case class Actor(
                name: String,
                birthDate: LocalDate,
                monthlyIncome: Double
                ) {

  def updateIncome(newIncome: Double) = {
    this.copy(monthlyIncome = newIncome)
  }
}
