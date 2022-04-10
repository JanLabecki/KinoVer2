package org.example.kino.application;

import org.example.kino.model.Client;

public class ClientValidationService {

    public boolean validateClientData(Client client) {
        if (client.getName().isEmpty()) {
            return false;
        }

        if (client.getSurname().isEmpty()) {
            return false;
        }

        if (client.getName().matches("[0-9]+")){
            return false;
        }
        return true;
    }
}
