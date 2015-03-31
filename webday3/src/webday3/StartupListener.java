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
	
	public void contextInitialized(ServletContextEvent sce)  {	// �� ���ø����̼� ���� �� �ʱ�ȭ�� �� ȣ���
		ServletContext application = sce.getServletContext();
		BufferedReader reader = null;
		Integer count = null;
		try {
			String countFilePath = application.getRealPath(COUNT_FILE_NAME);
			reader = new BufferedReader(new FileReader(countFilePath));
			count = Integer.parseInt(reader.readLine().trim());
		} catch (FileNotFoundException e) {
			application.log("������ �������� �ʽ��ϴ�.", e);
			count = 0;
		} catch (NumberFormatException e) {
			application.log("�ùٸ� ���� ������ �ƴմϴ�.", e);
			count = 0;
		} catch (IOException e) {
			application.log("����� ������ �߻��߽��ϴ�.", e);
			count = 0;
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {}
			
			application.setAttribute("count", count);
			application.log("count ��Ʈ����Ʈ�� ���� " + count + "(��)�� �����߽��ϴ�.");
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
    		application.log("count ���� ���Ͽ� ����߽��ϴ�. (��: " + count + ")");
    	} catch (IOException e) {
    		application.log("����� ������ �߻��߽��ϴ�.", e);
    	} finally {
    		if (writer != null)
				try {
					writer.close();
				} catch (IOException e) {}
    	}
    }
	
}
