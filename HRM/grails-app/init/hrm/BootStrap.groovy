package hrm

import com.hrm.Role
import com.hrm.User
import com.hrm.UserRole
import grails.converters.JSON

class BootStrap {


    /*def init = {servletContext -> registerMarshallers() }


    private void registerMarshallers(){
        JSON.registerObjectMarshaller(User) {

            def map = [

                    'id'                        : it.id?:"",
                    'username'                  : it.username?:"",
                    'password'                  : it.password?:"",
            ]
            return map
        }

    }
    //def userRole = new Role(authority: 'ROLE_USER').save()
    def adminRole = new Role(authority: 'ROLE_ADMIN').save()*/

    def init = { servletContext -> registerMarshallers()

        def adminRole = new Role(authority: 'ROLE_ADMIN').save()

        def testUser = new User(username: 'me', password: 'password').save()

        UserRole.create testUser, adminRole

        UserRole.withSession {
            it.flush()
            it.clear()
        }
    }
    private void registerMarshallers(){
        JSON.registerObjectMarshaller(User) {

            def map = [

                    'id'                        : it.id?:"",
                    'username'                  : it.username?:"",
                    'password'                  : it.password?:"",
            ]
            return map
        }

    }
}
