/**
  * Created by marie on 10/4/17.
  */
package main

import java.time.LocalDate

case class Event(
                occurrenceDate: LocalDate,
                owner: Actor,
                eventType: String
           ) {

}
