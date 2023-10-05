package com.example.cms_api.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cms_api.Model.Counselor;
import com.example.cms_api.Repository.CounselorRepository;

import java.util.List;

@Service
public class CounselorService {
    private final CounselorRepository counselorRepository;

    @Autowired
    public CounselorService(CounselorRepository counselorRepository) {
        this.counselorRepository = counselorRepository;
    }

    public Counselor saveCounselor(Counselor counselor) {
        // You can add business logic here before saving, if needed
        return counselorRepository.save(counselor);
    }

    public List<Counselor> getAllCounselors() {
        return counselorRepository.findAll();
    }

    public Counselor getCounselorById(Long id) {
        return counselorRepository.findById(id).orElse(null);
    }

    public void deleteCounselor(Long id) {
        counselorRepository.deleteById(id);
    }

    public Counselor updateCounselor(Long id, Counselor updatedCounselor) {
        // Check if the counselor with the given id exists
        Counselor existingCounselor = counselorRepository.findById(id).orElse(null);

        if (existingCounselor != null) {
            // Update the existing counselor with the new data
            existingCounselor.setName(updatedCounselor.getName());
            existingCounselor.setDate(updatedCounselor.getDate());
            existingCounselor.setDailyDemo(updatedCounselor.getDailyDemo());
            existingCounselor.setWeeklyDemo(updatedCounselor.getWeeklyDemo());
            existingCounselor.setCallyzerReport(updatedCounselor.getCallyzerReport());
            existingCounselor.setTalkTime(updatedCounselor.getTalkTime());

            // Save the updated counselor
            return counselorRepository.save(existingCounselor);
        }

        return null; // Counselor not found
    }

    
}


