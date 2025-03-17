package com.eventbooking.Controller;

import com.eventbooking.Model.SystemSettings;
import com.eventbooking.Model.SettingsDTO;
import com.eventbooking.Service.SystemSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/settings")
@CrossOrigin(origins = "*")
public class SystemSettingsController {
    @Autowired
    private SystemSettingsService settingsService;

    @GetMapping
    public ResponseEntity<SystemSettings> getCurrentSettings() {
        try {
            return ResponseEntity.ok(settingsService.getCurrentSettings());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> updateSettings(@RequestBody SettingsDTO settingsDTO) {
        try {
            SystemSettings systemSettings = null;
            settingsService.updateSettings(null);
            return ResponseEntity.ok("Settings updated successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Update failed: " + e.getMessage());
        }
    }
}