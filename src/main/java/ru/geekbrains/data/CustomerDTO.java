package ru.geekbrains.data;

public class CustomerDTO {

    private Integer id;
    private String firstName;
    private String familyName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public CustomerDTO() {
    }

    public CustomerDTO(Integer id, String firstName, String familyName) {
        this.id = id;
        this.firstName = firstName;
        this.familyName = familyName;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", familyName='" + familyName + '\'' +
                '}' + '\n';
    }
}
