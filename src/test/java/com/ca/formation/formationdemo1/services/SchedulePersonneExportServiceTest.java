package com.ca.formation.formationdemo1.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SchedulePersonneExportServiceTest {

    @Mock
    Logger logger;

    @InjectMocks
    SchedulePersonneExportService schedulePersonneExportService;

    @Test
    void envoyerListePersonnes() {
        schedulePersonneExportService.envoyerListePersonnes();
        verify(logger)
                .info(" Envoyer la liste des personne :{} ", System.currentTimeMillis() / 1000);
    }
}