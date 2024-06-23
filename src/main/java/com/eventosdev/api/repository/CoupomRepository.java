package com.eventosdev.api.repository;

import com.eventosdev.api.domain.coupon.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoupomRepository  extends JpaRepository<Coupon, UUID> {
}
