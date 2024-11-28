package com.vamos.spring.test.ajax.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.vamos.spring.test.ajax.domain.Booking;

@Mapper
public interface BookingRepository {

	
public List<Booking> selectBookingList();
	
	public int insertBooking(
			@Param("name") String name
			, @Param("date") Date date
			, @Param("day") int day
			, @Param("headcount") int headcount
			, @Param("phoneNumber") String phoneNumber
			, @Param("state") String state);
	
	public int deleteBooking(@Param("id") int id);
	
	public Booking selectBooking(
			@Param("name") String name
			, @Param("phoneNumber") String phoneNumber);

}
