package wakacje2022.core

import grails.gorm.services.Service

@Service(PlacesToGo)
interface PlacesToGoService {

    PlacesToGo get(Serializable id)

    List<PlacesToGo> list(Map args)

    Long count()

    void delete(Serializable id)

    PlacesToGo save(PlacesToGo placesToGo)

}