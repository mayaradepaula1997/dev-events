package com.eventosdev.api.controller;

import com.eventosdev.api.domain.coupon.Coupon;
import com.eventosdev.api.domain.coupon.CouponRequestDTO;
import com.eventosdev.api.services.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/coupon")
public class CouponController {

    @Autowired
   private CouponService couponService;


    public ResponseEntity<Coupon> addCouponsToEvent (@PathVariable UUID eventId, @RequestBody CouponRequestDTO data){
        Coupon coupon = couponService.addCouponToEvent(eventId, data);
        return ResponseEntity.ok(coupon);
    }
}
