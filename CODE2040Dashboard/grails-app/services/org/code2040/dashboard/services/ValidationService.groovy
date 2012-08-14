package org.code2040.dashboard.services

import java.util.List;

import org.code2040.dashboard.Question;
import org.code2040.dashboard.RecruitmentInfo;

class ValidationService {

    def validateCandidateParams(String name, String school, String graduationDate, String email,
		String password, String secondPassword, String phoneNumber, char gender, String race,
		String homeCountry, int fellowYear, List<Question> questions,
		List<RecruitmentInfo> recruitmentInfo, String homeState, String picture, String resume) {
		
		// Name
		if (basicValidation(name, 6))
			return "Name too short"
		
		if (!name.contains(" "))
			return "Name needs to have at least one last name"
		
		// School
		if (basicValidation(school, 4))
			return "School name too short"
		
		// Graduation Date
		if (basicValidation(graduationDate, 3))// TODO: Verify Pattern Month/YEAR
			return "Invalid Graduation Date"
		String delims = "[/]"
		String[] gradDate = graduationDate.split(delims)
		if (gradDate.length>2)
			return "Input Graduation Date as mm/yy"
		Integer month = Integer.valueOf(gradDate[0])
		Integer year = Integer.valueOf(gradDate[1])
		if ((month.SIZE < 3 && month.SIZE > 0) && (month < 1 || month > 12))
			return "Enter Graduation Month as a number between 01 and 12"
		if ((year.SIZE < 3 && year.SIZE > 0) && (year > 0 || year > 100))
			return "Enter Graduation year as a number between 00 and 99"
			
		// EMail
		if (basicValidation(email, 5))
			return "E-Mail address too short"
		
		if (!email.contains(".") || !email.contains("@")) // TODO: Create a Pattern
			return "Invalid E-Mail Address"
		
		// Passwords
		if (basicValidation(password, 8))
			return "Password too short"
		if (secondPassword == null || secondPassword != password)
			return "Re-typed password is wrong"
		
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
		for(Question question:questions){
			if (basicValidation(question.description, 3))
				return "A question is too short. Must be at least 3 letters"
		}
		
		// Recruitment Info
		for(RecruitmentInfo info:recruitmentInfo){
			if (basicValidation(info.name, 3))
				return "A name in a recruitment field is too short. Must be at least 3 letters"
			if (basicValidation(info.email, 3))
				return "An email in a recruitment field is too short. Must be at least 3 letters"
			if (basicValidation(info.title, 3))
				return "A title in a recruitment field is too short. Must be at least 3 letters"
		}
			
		return null
    }
		
	private def basicValidation(String nameToValidate, int minSize) {
		if (nameToValidate == null || (minSize > 0 && nameToValidate.length() < minSize))
			return false
		return true
	}
}
