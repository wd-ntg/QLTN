/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

public class PersonModel {
<<<<<<< HEAD

    private String PersonId,PassworrdAcc, RolePerson, NamePerson, Email, PhoneNumber, AddressPerson;
    
    public PersonModel(String PersonId, String PasswordAcc, String RolePerson, String NamePerson, String Email, String PhoneNumber, String AddressPerson) {
=======
    private String PersonId, RoleValue;
    private String PassworrdAcc, RolePerson, NamePerson, Email, PhoneNumber, AddressPerson;
    
    public PersonModel( String NamePerson, String Email,String AddressPerson,String PhoneNumber){
        this.NamePerson = NamePerson;
        this.Email = Email;
        this.AddressPerson = AddressPerson;
        this.PhoneNumber = PhoneNumber;
    }
    
    
    public PersonModel(String PersonId, String PasswordAcc, String RolePerson, String NamePerson, String Email, String PhoneNumber, String AddressPerson) {

>>>>>>> 6e243b03eed302ba85b240bae895b29a90342dfe
        this.PersonId = PersonId;
        this.PassworrdAcc = PasswordAcc;
        this.RolePerson = RolePerson;
        this.NamePerson = NamePerson;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.AddressPerson = AddressPerson;
<<<<<<< HEAD

=======
>>>>>>> 6e243b03eed302ba85b240bae895b29a90342dfe
    }
    
    public PersonModel (String NamePerson, String RolePeson, String EmailPerson, String AddressPerson, String PhoneNumberPerson, String PasswordAcc)  {
        this.NamePerson = NamePerson;
        this.RolePerson = RolePeson;
        this.Email = EmailPerson;
        this.AddressPerson = AddressPerson;
        this.PhoneNumber = PhoneNumberPerson;
        this.PassworrdAcc = PasswordAcc;
    }
    
//    public PersonModel (String PersonId ,String NamePerson, String RolePeson, String EmailPerson, String AddressPerson, String PhoneNumberPerson)  {
//        this.PersonId = PersonId;
//        this.NamePerson = NamePerson;
//        this.RolePerson = RolePeson;
//        this.Email = EmailPerson;
//        this.AddressPerson = AddressPerson;
//        this.PhoneNumber = PhoneNumberPerson;
//    }
<<<<<<< HEAD
//    
=======
    
>>>>>>> 6e243b03eed302ba85b240bae895b29a90342dfe
    public  PersonModel (String NamePerson, String RolePeson, String EmailPerson, String AddressPerson, String PhoneNumberPerson)  {
        this.NamePerson = NamePerson;
        this.RolePerson = RolePeson;
        this.Email = EmailPerson;
        this.AddressPerson = AddressPerson;
        this.PhoneNumber = PhoneNumberPerson;
    }
    
    public PersonModel(String PersonId, String NamePerson, String AddressPerson) {
        this.PersonId = PersonId;
        this.NamePerson = NamePerson;
        this.AddressPerson = AddressPerson;
    }
    
    public PersonModel () {
        
    }
    
    // Getter methods
    public String getPersonId() {
        return PersonId;
    }
    
    public String getPasswordAcc () {
        return PassworrdAcc;
    }


    public String getRolePerson() {
        return RolePerson;
    }

    public String getNamePerson() {
        return NamePerson;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getAddressPerson() {
        return AddressPerson;
    }
    
    // Setter methods
    public void setPersonId(String personId) {
        this.PersonId = personId;
    }
    
    public void setPasswordAcc (String PasswordAcc) {
        this.PassworrdAcc = PasswordAcc;
    }

<<<<<<< HEAD
=======

>>>>>>> 6e243b03eed302ba85b240bae895b29a90342dfe
    public void setRolePerson(String rolePerson) {
        this.RolePerson = rolePerson;
    }

    public void setNamePerson(String namePerson) {
        this.NamePerson = namePerson;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }

    public void setAddressPerson(String addressPerson) {
        this.AddressPerson = addressPerson;
    }
    
    
    public void setRoleValue(String roleValue){
        this.RoleValue = roleValue;
    }
    public String getRoleValue(){
        return this.RoleValue;
    }
}

