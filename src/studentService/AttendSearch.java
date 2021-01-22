package studentService;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import studentAttendBean.StudentBean;
import studentAttendDao.StudentDao;



public class AttendSearch {
	public void execute(HttpServletRequest request)throws Exception{
		StudentDao dao = null;
		try{
			dao = new StudentDao();
			ArrayList<StudentBean> studentList =  dao.getStudentData();
				if(studentList.isEmpty()){
					request.setAttribute("message", "生徒情報はありません");
				}else{
					request.setAttribute("studentList", studentList);
				}
		}finally{
			if(dao != null){
				dao.close();
			}
		}
	}
}
