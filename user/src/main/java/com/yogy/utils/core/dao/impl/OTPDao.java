package com.yogy.utils.core.dao.impl;

import com.yogy.utils.core.dao.interfaces.OTPRepository;
import com.yogy.utils.core.entity.OTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;

public class OTPDao implements OTPRepository {

	@Autowired
	private OTPRepository otpRepository;

	private final MongoTemplate mongoTemplate;

	public OTPDao(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public <S extends com.yogy.utils.core.entity.OTP> S save(S s) {
		s.setCreationTime(System.currentTimeMillis());
		return save(s);
	}

	@Override
	public <S extends OTP> List<S> saveAll(Iterable<S> iterable) {
		return null;
	}

	@Override
	public Optional<OTP> findById(String s) {
		return Optional.empty();
	}

	@Override
	public boolean existsById(String s) {
		return false;
	}

	@Override
	public List<OTP> findAll() {
		return null;
	}

	@Override
	public Iterable<OTP> findAllById(Iterable<String> iterable) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(String s) {

	}

	@Override
	public void delete(OTP otp) {

	}

	@Override
	public void deleteAll(Iterable<? extends OTP> iterable) {

	}

	@Override
	public void deleteAll() {

	}

	@Override
	public List<OTP> findAll(Sort sort) {
		return null;
	}

	@Override
	public Page<OTP> findAll(Pageable pageable) {
		return null;
	}

	@Override
	public <S extends OTP> S insert(S s) {
		return null;
	}

	@Override
	public <S extends OTP> List<S> insert(Iterable<S> iterable) {
		return null;
	}

	@Override
	public <S extends OTP> Optional<S> findOne(Example<S> example) {
		return Optional.empty();
	}

	@Override
	public <S extends OTP> List<S> findAll(Example<S> example) {
		return null;
	}

	@Override
	public <S extends OTP> List<S> findAll(Example<S> example, Sort sort) {
		return null;
	}

	@Override
	public <S extends OTP> Page<S> findAll(Example<S> example, Pageable pageable) {
		return null;
	}

	@Override
	public <S extends OTP> long count(Example<S> example) {
		return 0;
	}

	@Override
	public <S extends OTP> boolean exists(Example<S> example) {
		return false;
	}

	@Override
	public OTP getOTPByLoginParam(String loginparam) {
		Query query = new Query();
		query.addCriteria(Criteria.where(OTP.LOGIN_PARAM).is(loginparam));
		query.with(Sort.by(Sort.Direction.DESC, "creationTime"));
		query.limit(1);
		return mongoTemplate.findOne(query, OTP.class);
	}

}
