package campingInfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class testfile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xepdb1", "hr",
				"hr");) {
			PreparedStatement pstmt = null;
			File file = new File("C:\\Users\\Student\\Desktop\\project2\\campinf.csv");
			InputStreamReader ips = new InputStreamReader(new FileInputStream(file), "BIG5");
			BufferedReader bf = new BufferedReader(ips);

			String jdbc_insert_sql = "INSERT INTO CAMPINF" + "(C_NUMBER,C_NAME,CITY,ADRESS,OPRICE,WPRICE,TENTNUM,ELEVATION,FEATURE,FACILITY,PET,SERVICE,PARKING) VALUES" 
			+ "(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(jdbc_insert_sql);

			String lineText = null;
			while ((lineText = bf.readLine()) != null) {
				String[] data = lineText.split(",");
				String nnumber = data[0];
				String c_name = data[1];
				String city = data[2];
				String adress = data[3];
				String opprice = data[4];
				String wpprice = data[5];
				String ttentnum = data[6];
				String elevation = data[7];
				String feature = data[8];
				String facility = data[9];
				String pet = data[10];
				String service = data[11];
				String parking = data[12];				
				
				int c_number = Integer.parseInt(nnumber);
				int oprice = Integer.parseInt(opprice);
				int wprice = Integer.parseInt(wpprice);
				int tentnum = Integer.parseInt(ttentnum);
				
				pstmt.setInt(1, c_number);
				pstmt.setString(2, c_name);
				pstmt.setString(3, city);
				pstmt.setString(4, adress);				
				pstmt.setInt(5, oprice);
				pstmt.setInt(6, wprice);
				pstmt.setInt(7, tentnum);
				pstmt.setString(8, elevation);	
				pstmt.setString(9, feature);	
				pstmt.setString(10, facility);	
				pstmt.setString(11, pet);	
				pstmt.setString(12, service);	
				pstmt.setString(13, parking);	
				pstmt.addBatch();
				
				pstmt.executeBatch();
				pstmt.clearBatch();
				


				
				
				System.out.println(c_number+" "+c_name+" "+city+" "+adress+" "+oprice+" "+wprice+" "+tentnum+" "+elevation
						+" "+feature+" "+facility+" "+pet+" "+service+" "+parking);
				

				
			}
			bf.close();

			System.out.println("done");
			
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
