package com.example;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService service;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("001", "Alice", "Smith", "1234567890", "456 Oak St");
        // This should not throw an exception
        service.addContact(contact);
        // If we reach here, the test passes
    }

    @Test
    public void testAddDuplicateIdThrowsException() {
        Contact contact1 = new Contact("001", "Alice", "Smith", "1234567890", "456 Oak St");
        Contact contact2 = new Contact("001", "Bob", "Brown", "0987654321", "789 Pine St");
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2));
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("002", "Charlie", "Brown", "1234567890", "101 Maple St");
        service.addContact(contact);
        // This should not throw an exception
        service.deleteContact("002");
        // If we reach here, the test passes
    }

    @Test
    public void testDeleteNonExistentContactThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("999"));
    }

    @Test
    public void testUpdateFirstName() {
        Contact contact = new Contact("003", "David", "Wilson", "1234567890", "202 Elm St");
        service.addContact(contact);
        // This should not throw an exception
        service.updateFirstName("003", "Dave");
        // If we reach here, the test passes
    }

    @Test
    public void testUpdateFirstNameNonExistentContactThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("999", "Dave"));
    }

    @Test
    public void testUpdateLastName() {
        Contact contact = new Contact("004", "Eve", "Johnson", "1234567890", "303 Pine St");
        service.addContact(contact);
        // This should not throw an exception
        service.updateLastName("004", "Jones");
        // If we reach here, the test passes
    }

    @Test
    public void testUpdatePhone() {
        Contact contact = new Contact("005", "Frank", "Miller", "1234567890", "404 Oak St");
        service.addContact(contact);
        // This should not throw an exception
        service.updatePhone("005", "9876543210");
        // If we reach here, the test passes
    }

    @Test
    public void testUpdateAddress() {
        Contact contact = new Contact("006", "Grace", "Davis", "1234567890", "505 Maple St");
        service.addContact(contact);
        // This should not throw an exception
        service.updateAddress("006", "606 New Street");
        // If we reach here, the test passes
    }

    @Test
    public void testUpdateAfterDeleteThrowsException() {
        Contact contact = new Contact("007", "Henry", "Garcia", "1234567890", "707 Cedar St");
        service.addContact(contact);
        service.deleteContact("007");
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("007", "Hank"));
    }
}
