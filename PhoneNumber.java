package assign02;

/**
 * This class represents a phone number.
 * 
 * @author CS 2420 course staff
 * @version 2025-05-15
 */
public class PhoneNumber {

	private String areaCode;
	private String trunk;
	private String rest;

	/**
	 * Creates a phone number by parsing the given string (e.g., 123-456-7890).
	 * 
	 * @param phoneNumberString - formatted string from which to create a PhoneNumber object
	 */
	public PhoneNumber(String phoneNumberString) {
		phoneNumberString = phoneNumberString.replaceAll("-|\\s|\\.|\\(|\\)", "");

		if(phoneNumberString.length() != 10) {
			throw new IllegalArgumentException("Phone number \"" + phoneNumberString + "\" does not have 10 digits");
    }
		for(int i = 0; i < 10; i++) {
			if(!Character.isDigit(phoneNumberString.charAt(i))) {
				throw new IllegalArgumentException("Phone number \"" + phoneNumberString + "\" contains non-digit characters");
      }
    }

		this.areaCode = phoneNumberString.substring(0, 3);
		this.trunk = phoneNumberString.substring(3, 6);
		this.rest = phoneNumberString.substring(6, 10);
	}

	/**
	 * Determines whether this phone number is the same as a given object.
	 * Two phone numbers are considered equal if they have the same area code, trunk, and remaining numbers.
	 * 
	 * @param other - object begin compared with this phone number
	 * @return true if other is a PhoneNumber type and is equal to this phone number,
	 *         false otherwise
	 */
	public boolean equals(Object other) {
		if(!(other instanceof PhoneNumber))
			return false;

		PhoneNumber otherPhoneNumber = (PhoneNumber) other;
		return (
      this.areaCode.equals(otherPhoneNumber.areaCode) && 
      this.trunk.equals(otherPhoneNumber.trunk) && 
			this.rest.equals(otherPhoneNumber.rest)
    );
	}

	/**
	 * Generates a textual representation of this phone number.
	 * 
	 * @return formatted string for this phone number
	 */
	public String toString() {
		return "(" + this.areaCode + ") " + this.trunk + "-" + this.rest;
	}
}
