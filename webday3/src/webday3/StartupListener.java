package webday3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

public class StartupListener implements ServletContextListener {
	
	private static final String COUNT_FILE_NAME = "/WEB-INF/count.txt";
	
	public void contextInitialized(ServletContextEvent sce)  {	// 웹 애플리케이션 시작 시 초기화될 때 호출됨
		ServletContext application = sce.getServletContext();
		BufferedReader reader = null;
		Integer count = null;
		try {
			String countFilePath = application.getRealPath(COUNT_FILE_NAME);
			reader = new BufferedReader(new FileReader(countFilePath));
			count = Integer.parseInt(reader.readLine().trim());
		} catch (FileNotFoundException e) {
			application.log("파일이 존재하지 않습니다.", e);
			count = 0;
		} catch (NumberFormatException e) {
			application.log("올바른 숫자 형식이 아닙니다.", e);
			count = 0;
		} catch (IOException e) {
			application.log("입출력 오류가 발생했습니다.", e);
			count = 0;
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {}
			
			application.setAttribute("count", count);
			application.log("count 어트리뷰트의 값을 " + count + "(으)로 설정했습니다.");
		}
	}
	
    public void contextDestroyed(ServletContextEvent sce)  {
    	ServletContext application = sce.getServletContext();
    	BufferedWriter writer = null;
    	try {
    		String countFilePath = application.getRealPath(COUNT_FILE_NAME);
    		Integer count = (Integer) application.getAttribute("count");
    		writer = new BufferedWriter(new FileWriter(countFilePath));
    		writer.write(count.toString());
    		application.log("count 값을 파일에 기록했습니다. (값: " + count + ")");
    	} catch (IOException e) {
    		application.log("입출력 오류가 발생했습니다.", e);
    	} finally {
    		if (writer != null)
				try {
					writer.close();
				} catch (IOException e) {}
    	}
    }
	
}
