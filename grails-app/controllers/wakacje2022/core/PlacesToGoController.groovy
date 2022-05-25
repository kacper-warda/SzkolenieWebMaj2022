package wakacje2022.core

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PlacesToGoController {

    PlacesToGoService placesToGoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond placesToGoService.list(params), model:[placesToGoCount: placesToGoService.count()]
    }

    def show(Long id) {
        respond placesToGoService.get(id)
    }

    def create() {
        respond new PlacesToGo(params)
    }

    def save(PlacesToGo placesToGo) {
        if (placesToGo == null) {
            notFound()
            return
        }

        try {
            placesToGoService.save(placesToGo)
        } catch (ValidationException e) {
            respond placesToGo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'placesToGo.label', default: 'PlacesToGo'), placesToGo.id])
                redirect placesToGo
            }
            '*' { respond placesToGo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond placesToGoService.get(id)
    }

    def update(PlacesToGo placesToGo) {
        if (placesToGo == null) {
            notFound()
            return
        }

        try {
            placesToGoService.save(placesToGo)
        } catch (ValidationException e) {
            respond placesToGo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'placesToGo.label', default: 'PlacesToGo'), placesToGo.id])
                redirect placesToGo
            }
            '*'{ respond placesToGo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        placesToGoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'placesToGo.label', default: 'PlacesToGo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'placesToGo.label', default: 'PlacesToGo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
