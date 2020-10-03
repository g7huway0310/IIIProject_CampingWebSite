1package comment;

import java.util.Scanner;
import static java.lang.Thread.sleep;


public class TestComm {

	public TestComm() {
		
	}
	
	
	public static void main(String[] args) throws InterruptedException{
		CommData data= new CommData();	
		
		CommIn commin = new CommIn();
		Scanner sn=new Scanner(System.in);
	
		System.out.println("你好,歡迎進入系統,請輸入想要使用的功能:1.新增評價 2.退出");
		int opt = sn.nextInt();
		if (opt==1) {
			System.out.println("請輸入想要新增的評價內容");
			String Content =sn.next();
			data.setContent(Content);
			commin.insertData(data);}
			else if(opt==2) {
				System.out.println("確定退出?  1.確定 2.返回");

				if(sn.nextInt() == 1) {
					System.out.println("系統結束");
					sleep(3000);
					System.exit(0);
				}else{
					TestComm.main(args);
				}

			}else {
				System.out.println("輸入錯誤，請重新查詢");
				TestComm.main(args);

			}
			System.out.println("是否繼續使用? 1.是 2.否");
			if(sn.nextInt()== 1) {
				TestComm.main(args);	
			}else {
				System.out.println("系統結束");
				sleep(3000);
				System.exit(0);
				
			}
			sn.close();


	}
}