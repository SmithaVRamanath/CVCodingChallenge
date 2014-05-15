package com.cv.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cv.dao.SchoolDAO;
import com.cv.model.Result;
import com.cv.vo.SchoolResult;

/**
 * Spring Controller Class for SchoolResults related functionalities.
 * 
 * @author Smitha
 * 
 */
@Controller
public class SchoolController {
	
	private static Logger logger = Logger.getLogger(SchoolController.class);
	private static final String SEARCH_FIELD	=	"searchField";
	private static final String SEARCH_STRING	=	"searchString";
	private static final String SEARCH_OPER	=	"searchOper";
	
	
	@Autowired
	private SchoolDAO schoolDAO;
	/**
	 * Method to list school results. 
	 * Currently accessing DAO directly.(Ideally should go through a service class).
	 * Lists all the schools and creates {@link SchoolResult} for every unique combination of 
	 * school and subject. An array of these school results is returned.
	 * 
	 * @param map
	 * @return array of {@link SchoolResult}
	 */
	@RequestMapping(value="schoolList")
	@ResponseBody
	public SchoolResult[] listSchoolResults(Map<String, Object> map,
			@RequestParam(value = SEARCH_FIELD, required = false) String searchField,
			   @RequestParam(value = SEARCH_STRING, required = false) String searchString,
			   @RequestParam(value = SEARCH_OPER, required = false) String searchOper) {
		Set<SchoolResult> schoolResults = new HashSet<SchoolResult>();
		try{
			List<com.cv.model.School> schools = null;
		logger.debug("Enter");		
		 schools = schoolDAO.listSchool();		
		logger.debug("Returned from DAO - "+schools.size());
		String currentSchoolName="";
		String currentSubject = "";
		SchoolResult sr = null;
		for(com.cv.model.School school: schools){
			for(Result result: school.getResults()){
				if(StringUtils.isNotBlank(searchString) && !result.getSubject().getSubjectName().equals(searchString))
					continue;
				if(!school.getSchoolName().equals(currentSchoolName) && !result.getSubject().getSubjectName().equals(currentSubject)){					
					sr = new SchoolResult();
					schoolResults.add(sr);					
					com.cv.vo.School schoolVo = new com.cv.vo.School(school.getSchoolName());
					sr.setSubject(result.getSubject().getSubjectName());
					sr.setSchool(schoolVo);
					currentSchoolName = school.getSchoolName();
					currentSubject = result.getSubject().getSubjectName();
				}
				
				if(result.getYear().equals("Y3")){
					sr.setLatestY3(result.getResultScore());
				}else if(result.getYear().equals("Y5")){
					sr.setLatestY5(result.getResultScore());
				}else if(result.getYear().equals("Y7")){					
					sr.setLatestY7(result.getResultScore());
				}else if(result.getYear().equals("Y9")){					
					sr.setLatestY9(result.getResultScore());					
				}
			}
		}
		
		logger.debug("Exit. Returning school results. No of school results"+schoolResults.size());
		}catch(Exception ex){
			logger.debug(ex);
		}
		
		return schoolResults.toArray(new SchoolResult[schoolResults.size()]);		
	}	
}
