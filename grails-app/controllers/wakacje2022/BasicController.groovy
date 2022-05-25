package wakacje2022

import grails.converters.JSON
import grails.converters.XML
import wakacje2022.core.Trip

class BasicController {

    InterestingPlacesService interestingPlacesService
    WeatherService weatherService

    def getWeather() {
        render weatherService.serviceMethod()

    }

    def index() {

        render Trip.findAllByStartingPointAndEndPoint("Gdańsk", "Paris") as XML
    }

    def otherEndPoint() {
        render "coś innego"
    }

    def newTrip() {
        Trip trip = new Trip(
                name: "Oglądanie wielorybów",
                startingPoint: "Gdańsk",
                endPoint: "Bergen",
                startDate: new Date(),
                endDate: "2022-06-06"
        )

        interestingPlacesService.saveNewTrip(trip);
        render trip as XML
    }
}
