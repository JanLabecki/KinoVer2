package org.example.kino.template;

import org.example.kino.model.Record;

import java.util.HashMap;

public abstract class AddRes {
    public void addRes(Record record) {
        if (validateData(record.getPropertiesForValidation())) {
            saveToDatabase(record.toString());
        }
    }
    public abstract boolean validateData(HashMap<String, String> properties);
    public abstract void saveToDatabase(String csv);

}
