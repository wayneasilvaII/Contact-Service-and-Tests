package com.example.contactservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertEquals(contact, service.getContact("12345"));
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.deleteContact("12345");
        assertNull(service.getContact("12345"));
    }

    @Test
    public void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateContact("12345", "Jane", "Smith", "0987654321", "456 Elm St");
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Elm St", contact.getAddress());
    }
}
