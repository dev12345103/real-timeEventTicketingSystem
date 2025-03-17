package com.eventbooking.Service;

import com.eventbooking.Model.SystemSettings;
import com.eventbooking.Repository.SystemSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemSettingsService {
    private final SystemSettingsRepository settingsRepository;

    @Autowired
    public SystemSettingsService(SystemSettingsRepository settingsRepository) {
        this.settingsRepository = settingsRepository;
    }

    public SystemSettings getCurrentSettings() {
        try {
            return settingsRepository.loadSettings();
        } catch (Exception e) {
            return new SystemSettings(0, 0, 0, 0);
        }
    }

    public void updateSettings(SystemSettings settings) {
        settingsRepository.saveSettings(settings);
    }
}

