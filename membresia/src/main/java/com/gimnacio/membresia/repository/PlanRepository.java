package com.gimnacio.membresia.repository;

import com.gimnacio.membresia.entity.Planes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Planes, Integer> {
}
