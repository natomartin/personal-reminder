package com.reminder.personal_reminder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reminder.personal_reminder.entity.Reminder;
import com.reminder.personal_reminder.service.ReminderService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;



@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("api/reminder")
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    @GetMapping
    public List<Reminder> getReminders() {
        return reminderService.getAllReminder();
    }

    @GetMapping("/{id}")
    public Reminder getReminderById(@PathVariable Long id) {
        return reminderService.getReminderById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteReminderById(@PathVariable Long id) {
        reminderService.deleteReminderById(id);
    }

    @PutMapping("/{id}")
    public Reminder updateReminder(@RequestBody Reminder reminder, @PathVariable Long id) {
        return reminderService.updateReminder(reminder, id);
    }

    @PostMapping
    public Reminder addReminder(@RequestBody Reminder reminder) {
        return reminderService.addReminder(reminder);
    }

    @DeleteMapping("/all")
    public void deleteAllReminders() {
        reminderService.deleteAllReminders();
    }
}
