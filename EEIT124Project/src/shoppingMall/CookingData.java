package shoppingMall;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CookingData {

		public static void main(String[] args) throws IOException, ParseException {

			try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xepdb1", "project2",
					"project2");) {
				connection.setAutoCommit(false);
				File file = new File("C:\\eclipse\\JavaWorkspace\\shoppingMall.csv");
				try (FileInputStream fi = new FileInputStream(file);
						BufferedInputStream bf = new BufferedInputStream(fi);
						InputStreamReader isr = new InputStreamReader(bf, "MS950");
						BufferedReader br = new BufferedReader(isr);) {
					String s = null;

					int counts = 0;
					s = br.readLine();
					while ((s = br.readLine()) != null) {
						String[] array = s.split(",");
						for (int i = 0; i < array.length; i++) {
							System.out.println(array[i]);

						}
						
						PreparedStatement pstmt = connection.prepareStatement(
								"insert into SHOPPINGDATA(PRODUCT_ID,PRODUCT_BRAND,PRODUCT_NAME,PRODUCT_PRICE,PRODUCT_SPEC,PRODUCT_STACK,PRODUCT_WARNING,PEOPLE) values(?,?,?,?,?,?,?,?)");

						pstmt.setString(1, array[0]);
						pstmt.setString(2, array[1]);
						pstmt.setString(3, array[2]);
						pstmt.setInt(4, Integer.parseInt(array[3]));
						pstmt.setString(5, array[4]);
						pstmt.setInt(6, Integer.parseInt(array[5]));
						pstmt.setString(7, array[6]);
						pstmt.setInt(8, Integer.parseInt(array[7]));

						pstmt.addBatch();
						pstmt.clearParameters();

						counts++;
						if (counts % 50 == 0) {
							int[] results = pstmt.executeBatch();
							pstmt.clearBatch();

						}

						int[] results = pstmt.executeBatch();
						pstmt.clearBatch();
						connection.commit();
					}
				} catch (FileNotFoundException e1) {
					connection.rollback();
					e1.printStackTrace();
				} catch (Exception e) {
					connection.rollback();
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}



	}
