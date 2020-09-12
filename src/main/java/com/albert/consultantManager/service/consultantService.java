package com.albert.consultantManager.service;

import java.util.List;

import com.albert.consultantManager.model.Consultant;

public interface consultantService {
List < Consultant > getAllConsultants();
void saveConsultant(Consultant consultant);
void deleteConsultantById(long id);
Consultant getConsultantById(long id);
}
