package org.code2040.dashboard.services

import java.util.List;
import org.code2040.dashboard.Answer
import org.code2040.dashboard.Question;


class ValidationService {

	def validateCandidateCreate(String email, String password, String secondPassword){
		if (email == null){
			return "Email is blank"
		}
		if (password == null){
			return "Email is blank"
		}
		if (secondPassword == null){
			return "Confirmation Password is blank"
		}
		
		if (password != secondPassword){
			return "Passwords doesn't match"
		}
	}
	
    def validateCandidateParams(String fname, String lname, String school, String graduationDate,
		 String phoneNumber, char gender, String race,
		String homeCountry, int fellowYear, List<Answer> answers, String homeState) {
		
		// Name
		if (basicValidation(fname, 2))
			return "First Name too short"
		
		if (basicValidation(lname, 2))
			return "Last Name too short"
		
		// School
		if (basicValidation(school, 4))
			return "School name too short"
		
		// Graduation Date
		if (basicValidation(graduationDate, 3))// TODO: Verify Pattern Month/YEAR
			return "Invalid Graduation Date"
		
		// Phone Number
		if (basicValidation(phoneNumber, 8))
			return "Phone Number is too short"
		
		// Gender
		if (gender == null || (gender != 'M' && gender != 'F'))
			return "Invalid Gender"
		
		// Race
		if (basicValidation(race, 4))
			return "Race is too short"
		
		// Home Country
		if (basicValidation(homeCountry, 3))
			return "Home Country is too short"
			
		// Fellow Year
		if (Calendar.getInstance().get(Calendar.YEAR) > fellowYear)
			return "Year is older than today"

		// Question
		if (answers != null) {
			for(Answer answer : answers) {
				if (basicValidation(answer.description, 3))
					return "A question is too short. Must be at least 3 letters"
			}
		}
		return null
    }
		
	private def basicValidation(String nameToValidate, int minSize) {
		if (nameToValidate == null || (minSize > 0 && nameToValidate.length() < minSize))
			return true
		return false
	}
}
