package com.example.cms_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cms_api.Model.Counselor;



public interface CounselorRepository extends JpaRepository<Counselor, Long> {
    // You can define custom queries or methods here if needed
}


