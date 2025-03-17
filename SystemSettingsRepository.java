package com.eventbooking.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.eventbooking.Model.SystemSettings;
import org.springframework.stereotype.Repository;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Repository
public class SystemSettingsRepository {
    private final String SETTINGS_FILE = "settings.json";
    private final ObjectMapper mapper = new ObjectMapper();

    public SystemSettings loadSettings() {
        File file = Paths.get(SETTINGS_FILE).toFile();
        if (!file.exists()) {
            return new SystemSettings(0, 2, 3, 100);
        }
        try {
            return mapper.readValue(file, SystemSettings.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load settings: " + e.getMessage());
        }
    }

    public void saveSettings(SystemSettings settings) {
        try {
            mapper.writeValue(Paths.get(SETTINGS_FILE).toFile(), settings);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save settings: " + e.getMessage());
        }
    }
}


