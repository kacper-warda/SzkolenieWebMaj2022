package wakacje2022

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/trip"(controller: "trip", action: "index")

        "/"(view: "/index")
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
