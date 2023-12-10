package com.mogila.api.repository;

import com.mogila.api.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    @Modifying
    void deleteAllByUserId(Long userId);

    List<Device> findAllByUserLogin(String username);
}
