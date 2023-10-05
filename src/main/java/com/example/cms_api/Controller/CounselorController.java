package com.example.cms_api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.cms_api.Model.Counselor;
import com.example.cms_api.Services.CounselorService;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/counselors")
public class CounselorController {
    private final CounselorService counselorService;

    @Autowired
    public CounselorController(CounselorService counselorService) {
        this.counselorService = counselorService;
    }

    @PostMapping("/save")
    public Counselor addCounselor(@RequestBody Counselor counselor) {
        return counselorService.saveCounselor(counselor);
    }

    @GetMapping("/getall")
    public List<Counselor> getAllCounselors() {
        return counselorService.getAllCounselors();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Counselor> updateCounselor(@PathVariable Long id, @RequestBody Counselor updatedCounselor) {
        Counselor counselor = counselorService.updateCounselor(id, updatedCounselor);
        if (counselor != null) {
            return new ResponseEntity<>(counselor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCounselor(@PathVariable Long id) {
        counselorService.deleteCounselor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    
}


