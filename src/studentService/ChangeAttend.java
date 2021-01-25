package studentService;

import javax.servlet.http.HttpServletRequest;

import studentAttendBean.StudentBean;
import studentAttendDao.StudentDao;

public class ChangeAttend {
	public void execute(HttpServletRequest request)throws Exception{
		StudentDao dao = null;
		String id = request.getParameter("id");
		String attend = request.getParameter("attend");
		try{
			if(id != null && !id.isEmpty()
				&&	attend != null && !attend.isEmpty()){
				StudentBean bean = new StudentBean();
				bean.setStudent_attend(attend);
				dao = new StudentDao();
				int numRow = dao.changeStudentData(Integer.parseInt(id));
				if(numRow > 0){
					request.setAttribute("message", "出欠情報を登録できました。");
				}else{
					request.setAttribute("message", "出欠情報を登録できませんでした。");
				}
			}else{
				request.setAttribute("message", "出欠情報に不備があるため、登録できませんでした。");
			}
		}finally{
			if(dao != null){
				dao.close();
			}
		}
	}
}
