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
import com.will.ceil.service.Core;
import com.will.ceil.service.CoreDaoService;

@Service("coreDaoService")
public class CoreDaoServiceImpl implements CoreDaoService {
	
	@Autowired
	CoreRepository coreRepository;
	private CoreConverter coreConverter = new CoreConverter();

	@Override
	public Page<Core> findByBo(Core search) {
		Pageable pageable = null;
		Page<Core> page = coreRepository.findAll(new Specification<CoreE>() {
			
			@Override
			public Predicate toPredicate(Root<CoreE> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				List<Expression<Boolean>> expression = predicate.getExpressions();
				if(search.getName() != null){
					expression.add(cb.like(root.get("name"),search.getName()));
				}
				return predicate;
			}
		},pageable).map(coreConverter);
		return page;
	}

	@Override
	public Core add(Core Core) {
		CoreE CoreE = new CoreE();
		BeanUtils.copyProperties(Core, CoreE);
		CoreE = coreRepository.saveAndFlush(CoreE);
		BeanUtils.copyProperties(CoreE, Core);
		return Core;
	}

	@Override
	public Core delete(String id) {
		CoreE CoreE = coreRepository.findOne(id);
		coreRepository.delete(id);
		Core Core = new Core();
		BeanUtils.copyProperties(CoreE, Core);
		return Core;
	}

	@Override
	public Core update(Core Core) {
		CoreE CoreE = new CoreE();
		BeanUtils.copyProperties(Core, CoreE);
		coreRepository.saveAndFlush(CoreE);
		return Core;
	}
	
	class CoreConverter implements Converter<CoreE,Core>{

		@Override
		public Core convert(CoreE CoreE) {
			Core Core = new Core();
			if(CoreE != null){
				BeanUtils.copyProperties(CoreE, Core);
				if(CoreE.getCeil() != null){
					Ceil target = new Ceil();
					BeanUtils.copyProperties(CoreE.getCeil(), target);
					Core.setCeil(target);
				}
			} else {
				Core = null;
			}
			return Core;
		}
		
		
	}
}
