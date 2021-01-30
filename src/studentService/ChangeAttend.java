package studentService;

import javax.servlet.http.HttpServletRequest;

import studentAttendDao.StudentDao;

public class ChangeAttend {
	public void execute(HttpServletRequest request)throws Exception{
		StudentDao dao = null;
		String id[] = request.getParameterValues("id");					//複数行文送られてくる
		String attend[] = request.getParameterValues("attend");
		request.setAttribute("id", id);

		try{
			if(id != null	&&	attend != null){
				dao = new StudentDao();
				for(int i = 0; i < id.length; i++){
					int numRow = dao.changeStudentData(attend[i], Integer.parseInt(id[i])); //ここのエラー、解決済み
					if(numRow > 0){
						request.setAttribute("message", "出欠情報を登録できました。");
					}else{
						request.setAttribute("message", "出欠情報を登録できませんでした。");
					}
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

/*
  以下のコードは未使用
//複数のidの受け取り
Enumeration ids = request.getParameterValues("id");
while(ids.hasMoreElements()){
	String id = (String)ids.nextElement();
	String idList[] = request.getParameterValues(id);
}
//複数のattendの受け取り
Enumeration attends = request.getParameterNames();
while(attends.hasMoreElements()){
	String attend = (String)attends.nextElement();
	String attendList[] = request.getParameterValues(attend);
}
*/