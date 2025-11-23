package com.reminder.personal_reminder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reminder.personal_reminder.entity.Reminder;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, Long> {

}
