package com.briup.apps.poll.service;

import java.util.List;
import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;

public interface ISurveyService {
	
	List<SurveyVM> findAll() throws Exception;
	
	SurveyVM findById(long id) throws Exception;
	
	void saveOrUpdate(Survey survey)throws Exception;
	
    void deleteById(long id) throws Exception;
	
	void batchDelete(long[] ids) throws Exception;

	List<Survey> query(String keywords) throws Exception;

    Survey findSurveyById(long id) throws Exception;
    
    List<SurveyVM> findByStatus(String status) throws Exception;
}
