package models.Client;

/**
 *
 * @author Phu Bao
 */
public class ClientInfoModel {
<<<<<<< HEAD
    private String personId, rolePerson, namePerson, email, phoneNumber, addressPerson;
=======
    private String personId, rolePerson, namePerson, email, phoneNumber, addressPerson; //Person
>>>>>>> 6e243b03eed302ba85b240bae895b29a90342dfe

    public ClientInfoModel() {
    }
        
    public ClientInfoModel(String personId, String rolePerson, String namePerson, String email, String phoneNumber, String addressPerson) {
        this.personId = personId;
        this.rolePerson = rolePerson;
        this.namePerson = namePerson;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addressPerson = addressPerson;
    }

    public ClientInfoModel(String personId, String namePerson, String email, String phoneNumber, String addressPerson) {
        this.personId = personId;
        this.namePerson = namePerson;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addressPerson = addressPerson;
    }
    
<<<<<<< HEAD
    
=======
>>>>>>> 6e243b03eed302ba85b240bae895b29a90342dfe
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getRolePerson() {
        return rolePerson;
    }

    public void setRolePerson(String rolePerson) {
        this.rolePerson = rolePerson;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddressPerson() {
        return addressPerson;
    }

    public void setAddressPerson(String addressPerson) {
        this.addressPerson = addressPerson;
    }
<<<<<<< HEAD

}
=======
    
}
>>>>>>> 6e243b03eed302ba85b240bae895b29a90342dfe
