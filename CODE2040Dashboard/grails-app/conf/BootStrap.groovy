import org.code2040.dashboard.SecRole
import org.code2040.dashboard.Manager
import org.code2040.dashboard.Candidate
import org.code2040.dashboard.SecUser
import org.code2040.dashboard.SecUserSecRole


class BootStrap {
	
	def springSecurityService
	def emailConfirmationService

    def init = { servletContext ->
		
		// Email Confirmation Services
		
		emailConfirmationService.onConfirmation = { email, uid ->
			log.info("User with id $uid has confirmed their email address $email")
			// now do something…
			// Then return a map which will redirect the user to this destination
			return [controller:'candidate', action:'welcome', params: [email : email, uid : uid]]
		  }
		  emailConfirmationService.onInvalid = { uid ->
			log.warn("User with id $uid failed to confirm email address after 30 days")
			// The email was already confirmed...
			return [controller:'candidate', action:'welcome', params: [email : 'INVALID', uid : 'ONINVALID']]
		  }
		  emailConfirmationService.onTimeout = { email, uid ->
			 log.warn("User with id $uid failed to confirm email address after 30 days")
			 // User took too long...
			return [controller:'candidate', action:'welcome', params: [email : 'INVALID', uid : 'ONTIMEOUT']]
		  }
		
		  // Dummy Users
		  // Creating the SecRoles for User and ADMIN
		  def userRole = SecRole.findByAuthority("ROLE_USER") ?: new SecRole(authority: "ROLE_USER").save()
		  def adminRole = SecRole.findByAuthority("ROLE_ADMIN") ?: new SecRole(authority: "ROLE_ADMIN").save()
		
		  def dummyUser = new Candidate(
			  username: "dummy@user.com",
			  password: "dummyuser",
			  enabled: true)
			
		  dummyUser.save(flush: true, failOnError:true)
		  SecUserSecRole.create dummyUser, userRole
			
		  def dummyAdmin = new Manager(
			  username: "manager@2040.com",
			  password: "manager",
			  enabled: true)
			
		  dummyAdmin.save(flush: true, failOnError:true)
		  SecUserSecRole.create dummyAdmin, adminRole
    }
    def destroy = {
    }
}
