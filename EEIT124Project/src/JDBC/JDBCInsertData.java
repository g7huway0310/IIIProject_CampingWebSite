package JDBC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCInsertData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try ( Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@//localhost:1521/XEPDB1","scott", "tiger");
				
        ) {
		File file = new File("C:\\data.csv");
		
		InputStream is = new FileInputStream(file);
	    BufferedReader br= new BufferedReader(new InputStreamReader(is,"UTF-8"));
        String strLine = null;
        while((strLine = br.readLine())!=null) {
        	String[] array=strLine.split(",");//因為預設是用"，"分開所以用split切開存入字串陣列
//			System.out.println(strLine);
//			System.out.println(array[0]);
//			System.out.println(array[3]);
//			System.out.println(array[4]);
			for(int i=0;i<array.length;i++){//偷看陣列元素有沒有切對

			}
			String qryInsert="insert into shoppingdata values(?,?,?,?,?,?,?,?)";//動態SQL指令
			
			PreparedStatement pstmt= conn.prepareStatement(qryInsert);//因為是insert所以用PreparedStatement來接
			
			pstmt.setString(1,array[0]);
			pstmt.setString(2,array[1]);
			pstmt.setString(3,array[2]);
			pstmt.setDouble(4,Double.parseDouble(array[3]));
			pstmt.setString(5,array[4]);
			pstmt.setString(6,array[5]);
			pstmt.setDouble(7,Double.parseDouble(array[6]));
			pstmt.setString(8,array[7]);
			
			pstmt.execute();
			
        };
		System.out.println("query finished");
            
        } catch (SQLException e) {
        	
            e.printStackTrace();
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}