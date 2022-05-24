package wakacje2022

import grails.gorm.transactions.Transactional
import wakacje2022.core.PlacesToGo
import wakacje2022.core.Trip

@Transactional
class InterestingPlacesService {

    def addEifleTower() {
        PlacesToGo toGo = new PlacesToGo(
                name: "Wieża Ajfla",
                ticketPrice: 100,
                timeToSpend: "2h")

        Trip.findByEndPoint("Paris").addToPlacesToGo(toGo).save(flush: true, failOnError: true);
    }

    def saveNewTrip(Trip trip){
        trip.save(flush:true, failOnError: true)
    }
}
