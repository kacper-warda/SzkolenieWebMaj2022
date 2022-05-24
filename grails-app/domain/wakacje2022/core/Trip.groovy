package wakacje2022.core

import org.grails.datastore.gorm.GormEntity

class Trip implements GormEntity<Trip> {

    String name;
    String startingPoint;
    String endPoint;
    Date startDate;
    Date endDate

    static hasMany = [placesToGo: PlacesToGo]

    static constraints = {
        name blank: false, size: 0..40
    }

}
