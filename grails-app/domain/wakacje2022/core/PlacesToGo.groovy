package wakacje2022.core

import org.grails.datastore.gorm.GormEntity

class PlacesToGo implements GormEntity<PlacesToGo> {

    String name
    Double ticketPrice
    String timeToSpend

    static belongsTo = [trip: Trip]

}
