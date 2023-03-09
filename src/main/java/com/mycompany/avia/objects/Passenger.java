package com.mycompany.avia.objects;

import com.mycompany.avia.annotations.ExceptionMessage;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@ExceptionMessage(message = "Объект passenger должен быть заполнен")
public class Passenger {
    private long id;
    
    @XmlElement(required = true)
    @ExceptionMessage(message = "Заполните имя пассажира")
    private String givenName;
    private String middleName;
    
    @XmlElement(required = true)
    @ExceptionMessage(message = "Заполните фамилию пассажира")
    private String familyName;
    
    @XmlElement(required = true)
    @ExceptionMessage(message = "Заполните номер документа")
    private String documentNumber;
    private String email;
    private String phone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
