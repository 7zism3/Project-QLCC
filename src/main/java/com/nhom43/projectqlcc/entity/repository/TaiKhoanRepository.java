package com.nhom43.projectqlcc.entity.repository;

import com.nhom43.projectqlcc.entity.model.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Long> {
}
