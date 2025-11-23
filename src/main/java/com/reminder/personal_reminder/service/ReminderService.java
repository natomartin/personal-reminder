package com.reminder.personal_reminder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reminder.personal_reminder.entity.Reminder;
import com.reminder.personal_reminder.repository.ReminderRepository;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    // delete remider by id
    public void deleteReminderById(Long id) {
        reminderRepository.deleteById(id);
    }

    // add remider
    public Reminder addReminder(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    // get reminder by id
    public Reminder getReminderById(Long id) throws RuntimeException {
        return reminderRepository.findById(id)
        .orElseThrow(() -> 
            new RuntimeException("Reminder with id " + id + " not found"));
        }

    // update reminder
    public Reminder updateReminder(Reminder reminder, Long id) throws RuntimeException {
        Reminder existingReminder = reminderRepository.findById(id)
        .orElseThrow(() -> 
            new RuntimeException("Reminder with id " + id + " not found"));

        existingReminder.setTitle(reminder.getTitle());
        existingReminder.setDescription(reminder.getDescription());
        existingReminder.setRemindAt(reminder.getRemindAt());
        existingReminder.setIntervalMinutes(reminder.getIntervalMinutes());

        return reminderRepository.save(existingReminder);
    }

    // get all reminder
    public List<Reminder> getAllReminder(){
        return reminderRepository.findAll();
    }

    // delete all reminders (only for testing purposes)
    public void deleteAllReminders() {
        reminderRepository.deleteAll();
    }
}
