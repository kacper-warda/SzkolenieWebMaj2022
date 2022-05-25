import wakacje2022.security.PersonPasswordEncoderListener

// Place your Spring DSL code here
beans = {
    personPasswordEncoderListener(PersonPasswordEncoderListener)
    rest(grails.plugins.rest.client.RestBuilder)

}
