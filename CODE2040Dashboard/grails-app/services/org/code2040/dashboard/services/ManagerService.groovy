package org.code2040.dashboard.services

import org.code2040.dashboard.Manager
import org.code2040.dashboard.SecRole
import org.code2040.dashboard.SecUserSecRole

class ManagerService {
	
	def createManager(String email, String password, String fname, String lname) {
		Manager m = new Manager()
		m.username = email
		m.password = password
		m.fname = fname;
		m.lname = lname;
		m.enabled = false;
		m.save(flush: true)
		if (!m.hasErrors()) {
			SecUserSecRole.create m, SecRole.findByAuthority("ROLE_ADMIN")
		}
		return m
	}

}
