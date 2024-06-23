package com.eventosdev.api.services;


import com.eventosdev.api.domain.coupon.Coupon;
import com.eventosdev.api.domain.coupon.CouponRequestDTO;
import com.eventosdev.api.domain.event.Event;
import com.eventosdev.api.exception.Exception;
import com.eventosdev.api.repository.CoupomRepository;
import com.eventosdev.api.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class CouponService {

    //Ter a injeção de dependencia de Evento e Cupom
    @Autowired
    private CoupomRepository coupomRepository;

    @Autowired
    private EventRepository eventRepository;


    public Coupon addCouponToEvent(UUID eventid, CouponRequestDTO couponData) {
        Optional<Event> event = eventRepository.findById(eventid);
        if (event.isEmpty()) {
            throw new Exception("Event not found");
        }else{
            Coupon coupon = new Coupon();
            coupon.setCode(couponData.code());
            coupon.setDiscount(couponData.discount());
            coupon.setValid(new Date(couponData.valid()));
            coupon.setEvent(coupon.getEvent());

            return coupomRepository.save(coupon);
        }

    }
}














