package wakacje2022

import grails.gorm.transactions.Transactional
import grails.plugins.rest.client.RestBuilder
import wakacje2022.core.WeatherForecast

@Transactional
class WeatherService {

    def serviceMethod() {
//        String addr = "https://api.openweathermap.org/data/3.0/onecall?lat=33.44&lon=-94.04&exclude=hourly,daily&appid=85d99420fe168da8079d397ff3467b12"
        String addr = "https://jsonplaceholder.typicode.com/todos/1"
        def resp = new RestBuilder().get(addr)

        Map map = [test:"test"];
        new WeatherForecast([temperature: 2.0, humility: 0.56, rain: "heavy"])
        new WeatherForecast(resp.json).save()
    }
}
