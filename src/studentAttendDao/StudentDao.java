package studentAttendDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import studentAttendBean.StudentBean;

public class StudentDao {
	private Connection connection;
	//コンストラクター MySQLとの接続
	public StudentDao() throws SQLException{
		String url =  "jdbc:mysql://localhost:3306/student";
		String user = "Shu Sagara";
		String password = "";
		connection = DriverManager.getConnection(url, user, password);
	}

	public void close(){
		try{
			if(connection != null){
				connection.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	//生徒情報をすべて表示
	public ArrayList<StudentBean> getStudentData() throws SQLException{
		ArrayList<StudentBean> studentData = null;
		PreparedStatement pstatement = null;
		ResultSet rs = null;
		try{
			//SQLを取得するオブジェクトの作成
			String sql = "SELECT * FROM studentattend";
			pstatement = connection.prepareStatement(sql);
			rs = pstatement.executeQuery();
			studentData = new ArrayList<StudentBean>();
			while(rs.next()){
				StudentBean studentBean = new StudentBean();
				studentBean = new StudentBean();
				studentBean.setStudent_id(rs.getInt("student_id"));
				studentBean.setStudent_classId(rs.getInt("student_classId"));
				studentBean.setStudent_attendId(rs.getInt("student_attendId"));
				studentBean.setStudent_name(rs.getString("student_name"));
				studentBean.setStudent_attend(rs.getString("student_attend"));
				studentData.add(studentBean);
			}
			rs.close();
		}finally{
			pstatement.close();
		}
		return studentData;
	}

	//指定した情報をアップデート
	public int changeStudentData(String attend, int changeNum) throws SQLException{
		int numRow= 0;
		PreparedStatement pstatement = null;

		try{
			//SQLを変更するオブジェクトの作成
			connection.setAutoCommit(false);

			String sql = "UPDATE studentattend set student_attend = ? where student_id=?";
			pstatement = connection.prepareStatement(sql);
			pstatement.setString(1, attend);
			pstatement.setInt(2, changeNum);
			numRow = pstatement.executeUpdate();

			//※データの取得も同時に行いたい場合はここでgetStudentData()メソッドと同様にBeanを利用する

		}finally{
			if(numRow > 0){
				connection.commit();
			}else{
				connection.rollback();
			}
			pstatement.close();
		}
		return numRow;
	}
}
