package com.his.dao;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import com.his.entities.ErrorCode;
import com.his.util.Constants;

public interface ErrorCodeRepository extends CrudRepository<ErrorCode, Long> {

	@Cacheable(cacheNames = Constants.CACHE_NAME_ERROR_CODE)
	ErrorCode findByErrorCode(String errorCode);

}
