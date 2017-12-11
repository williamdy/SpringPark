package com.will.ceil.serviceImpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.will.ceil.service.Ceil;
import com.will.ceil.service.CeilDaoService;

@Service("ceilDaoService")
public class CeilDaoServiceImpl implements CeilDaoService {
	
	@Autowired
	CeilRepository celRepository;
	private CeilConverter ceilConverter = new CeilConverter();

	@Override
	public Page<Ceil> findByBo(Ceil search) {
		Pageable pageable = null;
		Page<Ceil> page = celRepository.findAll(new Specification<CeilE>() {
			
			@Override
			public Predicate toPredicate(Root<CeilE> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				List<Expression<Boolean>> expression = predicate.getExpressions();
				if(search.getName() != null){
					expression.add(cb.like(root.get("name"),search.getName()));
				}
				return predicate;
			}
		},pageable).map(ceilConverter);
		return page;
	}

	@Override
	public Ceil add(Ceil ceil) {
		CeilE ceilE = new CeilE();
		BeanUtils.copyProperties(ceil, ceilE);
		ceilE = celRepository.saveAndFlush(ceilE);
		BeanUtils.copyProperties(ceilE, ceil);
		return ceil;
	}

	@Override
	public Ceil delete(String id) {
		CeilE ceilE = celRepository.findOne(id);
		celRepository.delete(id);
		Ceil ceil = new Ceil();
		BeanUtils.copyProperties(ceilE, ceil);
		return ceil;
	}

	@Override
	public Ceil update(Ceil ceil) {
		CeilE ceilE = new CeilE();
		BeanUtils.copyProperties(ceil, ceilE);
		celRepository.saveAndFlush(ceilE);
		return ceil;
	}
	
	class CeilConverter implements Converter<CeilE,Ceil>{

		@Override
		public Ceil convert(CeilE ceilE) {
			Ceil ceil = new Ceil();
			if(ceilE != null){
				BeanUtils.copyProperties(ceilE, ceil);
			} else {
				ceil = null;
			}
			return ceil;
		}
		
	}
	public static void main(String a[]){
		System.out.println((-3)/2);
	}
}
