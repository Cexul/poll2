package com.briup.apps.poll.service;

import java.util.List;
import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.extend.ClazzVM;
import com.briup.apps.poll.bean.extend.GradeVM;

public interface IGradeService {
	List<Grade> findAll() throws Exception;
	
	List<GradeVM> findAllGradeVM() throws Exception;
	
	void save(Grade grade) throws Exception;
	
	void update(Grade grade) throws Exception;
	
	void deleteById(long id) throws Exception;
	
	void batchDelete(List<Long> ids) throws Exception;//批量删除
	


}
