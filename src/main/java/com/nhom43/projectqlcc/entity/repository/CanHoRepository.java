package com.nhom43.projectqlcc.entity.repository;


import com.nhom43.projectqlcc.entity.model.CanHo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanHoRepository extends JpaRepository<CanHo, Long> {
    CanHo findByIdCanHo(Long id);
}

