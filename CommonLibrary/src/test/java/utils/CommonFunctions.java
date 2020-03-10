package utils;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class CommonFunctions {
	public static String f_get_next_run_id(){
		String s_query;
		String s_current_id;
		String s_next_id;
		try{
			s_query = "Select NEXT_ID from " + Global.DB_LOG_RUN_ID_TABLE_NAME;
			s_current_id = f_get_sql_result(s_query);
			s_next_id = Integer.toString(Integer.parseInt(s_current_id) +1);
			s_query = "Update  " + Global.DB_LOG_RUN_ID_TABLE_NAME + " Set NEXT_ID ='" + s_next_id + "'";
			f_insert_record_in_db(s_query);
			f_write_logs("info","New Run ID generated and assigned to this execution. Run Id: " + s_next_id);
			return s_next_id;
		}catch(Exception e){
			f_write_logs("warn","New Run ID not generated for this execution. This however will not halt the execution. Logs for this execution can be viewed locally. Err:" + CommonFunctions.f_err_string(e));
			return "false";
		}
	}
	public static String f_write_log_in_db_old(){
		String s_query;
		String s_current_id;
		String s_next_id;
		try{
			s_query = "Select NEXT_ID from " + Global.DB_LOG_RUN_ID_TABLE_NAME;
			System.out.println(Global.DB_LOG_RUN_ID_TABLE_NAME);
			s_current_id = f_get_sql_result(s_query);
			s_next_id = Integer.toString(Integer.parseInt(s_current_id) +1);
			s_query = "Update  " + Global.DB_LOG_RUN_ID_TABLE_NAME + " Set NEXT_ID ='" + s_next_id + "'";
			f_insert_record_in_db(s_query);
			f_write_logs("info","New Run ID generated and assigned to this execution. Run Id: " + s_next_id);
			return s_next_id;
		}catch(Exception e){
			f_write_logs("warn","New Run ID not generated for this execution. This however will not halt the execution. Logs for this execution can be viewed locally.");
			return "false";
		}
	}
	public static void f_write_logs(String s_message) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			Date obj = new Date();
			fw = new FileWriter(System.getProperty("user.dir") + "\\log.log", true);
			bw = new BufferedWriter(fw);
			bw.write(obj.toString() + "|" + Thread.currentThread().getStackTrace()[2].getMethodName() + "|" + s_message);
			bw.newLine();
			System.err.println(obj.toString() + "|" + Thread.currentThread().getStackTrace()[2].getMethodName() + "|" + s_message);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	public static void f_write_logs(String s_log_level, String s_message ) {
		String SCREEN_SHOT_FILE_PATH = null;
		Global.TC_STEP_NAME = Thread.currentThread().getStackTrace()[2].getMethodName();
		if(Global.CAPTURE_SCREEN_SHOT){
			if (  (s_log_level.toUpperCase().equals("PASS")) ||  (s_log_level.toUpperCase().equals("FAIL")) ||  
					(s_log_level.toUpperCase().equals("FAIL_NOT_EXIT")) ){
				File o_dir = new File(Global.CONFIG_DATA.get("SCREEN_SHOT_ROOT_PATH") + Global.RUN_ID);
				if(!(o_dir.exists())){
					o_dir.mkdir();
				}
				if (  (Global.TC_STEP_NAME.contains("_mq_")) || (Global.TC_STEP_NAME.contains("_trigger_")) ) {
					SCREEN_SHOT_FILE_PATH = "No Screen shot captured as it is not UI Step";
				}else{
					SCREEN_SHOT_FILE_PATH = Global.CONFIG_DATA.get("SCREEN_SHOT_ROOT_PATH") + Global.RUN_ID + "\\" + CommonFunctions.f_generate_time_based_unique_integer() + ".jpeg";
					Screenshot o_scrn_shot = new Screenshot(SCREEN_SHOT_FILE_PATH);
					o_scrn_shot.f_take_screen_shot();
				}
			}
		}else{
			if (  (s_log_level.toUpperCase().equals("PASS")) ||  (s_log_level.toUpperCase().equals("FAIL")) ||  
					(s_log_level.toUpperCase().equals("FAIL_NOT_EXIT")) ){
				SCREEN_SHOT_FILE_PATH = "No Screen shot captured as CAPTURE_SCREEN_SHOT is not marked as true in Config.xlsx file";
			}
		}
		if (! (Global.SDS_ID==null)){
			Global.SDS_ID = Global.SDS_ID.replace("'", "''"); 
		}
		if (Global.SDS_ID!=null){
			if (!(Global.SDS_ID_MAP.containsValue(Global.SDS_ID))){
				int i_sds_id_count = Global.SDS_ID_MAP.size();
				Global.SDS_ID_MAP.put((i_sds_id_count+1), Global.SDS_ID);
			}
		}
		if (Global.WF_ID!=null){
			if (!((Global.WF_ID_MAP.containsValue(Global.WF_ID)))){
				int i_wf_id_count = Global.WF_ID_MAP.size();
				Global.WF_ID_MAP.put((i_wf_id_count+1), Global.WF_ID);
			}
		}
		BufferedWriter bw = null;
		FileWriter fw = null;
		String s_message_db_log = s_message;
		s_message_db_log = s_message_db_log.replace("'", "''");
		s_message_db_log = s_message_db_log.replace(",", ",,");
				s_message_db_log = s_message_db_log.replace("&", "&amp;");
		Global.TC_STEP_ID = Global.TC_STEP_ID + 1;
		String s_module_name = Global.MODULE_NAME;
		String s_tc_name = Global.TC_NAME;
		String s_tc_descp = Global.TC_DESCP;
		String s_tc_pass_fail_status = Global.TC_PASS_FAIL_STATUS;
		String s_tc_class_file_name = Global.CLASS_FILE_NAME;
		String s_tc_step_name = Global.TC_STEP_NAME;
		Global.TC_PASS_FAIL_STATUS = Global.TC_PASS_FAIL_STATUS + "~" + s_log_level;
		String s_log_file_name = Global.LOG_FILE_NAME;
		File o_dir_log = new File(System.getProperty("user.dir") + "\\logs\\");
		if(!(o_dir_log.exists())){
			o_dir_log.mkdir();
		}
		String s_log_file_path = System.getProperty("user.dir") + "\\logs\\" + s_log_file_name +".csv";
		try {
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			s_message = timeStamp + "|" + s_log_level + "|" + s_module_name +"|" + s_tc_class_file_name + "|" +  s_tc_name +"|" + s_tc_descp 
					+ "|" + s_tc_step_name + "|" + s_message.replace("\n", "") + "|" + SCREEN_SHOT_FILE_PATH + "|" + Global.TC_STEP_ID;
			File f = new File(s_log_file_path);
			if (f.exists()){
				fw = new FileWriter(s_log_file_path, true);
				bw = new BufferedWriter(fw);
				bw.write(s_message.replace(",", " "));
				bw.newLine();
				if (Global.IS_DB_LOG_ENABLE){
					String s_db_log_level;
					String s_query = "";
					String s_step_status = s_log_level;
					if ((s_log_level.toUpperCase().contains("WARN")) || (s_log_level.toUpperCase().contains("PASS")) || (s_log_level.toUpperCase().contains("FAIL")) || (s_log_level.toUpperCase().contains("FAIL_NOT_EXIT"))){
						s_db_log_level = "USER_LOG";
					}else{
						s_db_log_level = "FW_LOG";
					}
					if ((s_log_level.trim().toUpperCase().equals("PASS"))){
						s_step_status = "True";
					}else if (s_log_level.trim().toUpperCase().equals("PASS_NO_SS")){
						s_step_status = "True";							
					}else if (s_log_level.trim().toUpperCase().equals("FAIL_NO_SS")){
						s_step_status = "False";						
					}else if (s_log_level.trim().toUpperCase().equals("FAIL")){
						s_step_status = "False";
					}else if (s_log_level.trim().toUpperCase().equals("FAIL_NOT_EXIT")){
						s_step_status = "False";
					}else if (s_log_level.trim().toUpperCase().equals("FAIL_NOT_EXIT_NO_SS")){
						s_step_status = "False";
					}
					try{
						String s_db_values = null;
						s_db_values = "'" + Global.SDS_RELEASE_ID + "','" + Global.HOST_NAME + "','" + 
								System.getProperty("user.name") + "','" + Global.RUN_ID + "','" + Global.MODULE_NAME+"_"+s_tc_class_file_name + "','" + 
								new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date())  + "','" + s_db_log_level + "','" +
								Global.TC_NAME + "','" + Global.TC_STEP_ID + "','" + Global.TC_STEP_NAME + "','" +
								s_step_status + "','" + s_message_db_log + "','" + SCREEN_SHOT_FILE_PATH + "','" + 
								Global.SDS_ID + "','" + Global.ENV_NAME + "_" + Global.SDS_VERSION + "'";
						s_query = "Insert into " + Global.DB_LOG_TC_LOG_TABLE_NAME + "(" + Global.DB_LOG_TC_LOG_CLM_NAMES + ") "
								+ "values (" + s_db_values + ")";
						if (Global.WRITE_LOG_IN_DB_BULK_INSERT_QUERY.equals("")){
							Global.WRITE_LOG_IN_DB_BULK_INSERT_QUERY = s_query;
						}else{
							Global.WRITE_LOG_IN_DB_BULK_INSERT_QUERY = Global.WRITE_LOG_IN_DB_BULK_INSERT_QUERY 
									+ "~~" + s_query ;
						}
					}catch(Exception enew){ 
						f_write_logs("Warning. Error while Inserting log in to Db. Query: " + s_query + " Stack Trace: " + enew.getMessage());
					}
				}
			}else{
				fw = new FileWriter(s_log_file_path, true);
				bw = new BufferedWriter(fw);
				bw.write(Global.LOG_FILE_CLM_NAMES);
				bw.newLine();
			}
			if ( (s_log_level.toUpperCase().equals("FAIL"))){
				System.err.println(s_message + "\n");
			}else if( (s_log_level.toUpperCase().equals("FAIL_NO_SS"))){
				System.err.println(s_message + "\n");
			}else if( (s_log_level.toUpperCase().equals("FAIL_NOT_EXIT"))){
				System.err.println(s_message + "\n");
			}else if( (s_log_level.toUpperCase().equals("FAIL_NOT_EXIT_NO_SS"))){
				System.err.println(s_message + "\n");			
			}else{
				System.out.println(s_message + "\n");
			}
			if  (  (s_log_level.toUpperCase().equals("FAIL"))  || (s_log_level.toUpperCase().equals("FAIL_NO_SS"))  ){
				CommonFunctions.f_write_logs("Due to failure in one of the step;"
						+ "Breaking the current Test Case and passing control to next test case.");
				throw new CancellationException();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
				if ( (s_log_level.toUpperCase().equals("FAIL"))){
					System.out.println("Cancellation exception thrown.");
					throw new CancellationException();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	public static String f_generate_log_file_name(){
		String result;
		String y,mon,d,h,min,s,mil;
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1; 
		int day = now.get(Calendar.DAY_OF_MONTH);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		int millis = now.get(Calendar.MILLISECOND);
		y = Integer.toString(year);
		mon = Integer.toString(month);
		d = Integer.toString(day);
		h = Integer.toString(hour);
		min = Integer.toString(minute);
		s = Integer.toString(second);
		mil = Integer.toString(millis);
		result = y+mon+d+h+min+s;
		return result;
	}
	public static void f_write_log_in_db(String s_query){
		String s_result;
		String connectionUrl;
		String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
		if(  (s_query.toUpperCase().contains("TC_STATUS_SUMMARY")) || (s_query.toUpperCase().contains("TC_LOG_TABLE")) 
				|| (s_query.toUpperCase().contains("AUTO_TC_RUN_ID")) ){
			connectionUrl = Global.DB_REPORT_CONNECTION_STRING;
		}else{
			connectionUrl = Global.SDS_DB_CONNECTION_STRING;  
		}
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(connectionUrl);		      
			stmt = conn.createStatement();
			boolean result_flag = stmt.execute(s_query);
			conn.close();
			conn = null;
			stmt = null;
		}catch(Exception e){
			try {
				conn.close();
				conn = null;
				stmt = null;
			} catch (SQLException e1) {
				CommonFunctions.f_write_logs("fail,Unable to close the Connection: " + e1.getMessage());
			}
			CommonFunctions.f_write_logs("fail. DB connection or sql generated error: " + e.getMessage() + s_query);
		}
	}
	public static void f_write_log_in_db_multiple(String s_query){
		String s_result;
		String connectionUrl;
		String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
		if(  (s_query.toUpperCase().contains("TC_STATUS_SUMMARY")) || (s_query.toUpperCase().contains("TC_LOG_TABLE")) 
				|| (s_query.toUpperCase().contains("AUTO_TC_RUN_ID")) ){
			connectionUrl = Global.DB_REPORT_CONNECTION_STRING;
		}else{
			connectionUrl = Global.SDS_DB_CONNECTION_STRING;  
		}
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(connectionUrl);		      
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			conn.setAutoCommit(false);
			String[] temp_query = s_query.split("~~");
			for (int i =0;i<temp_query.length;i++){
				stmt.addBatch(temp_query[i]);
			}
			stmt.executeBatch();
			conn.commit();
			conn.close();
			conn = null;
			stmt = null;
		}catch(Exception e){
			try {
				conn.close();
				conn = null;
				stmt = null;
			} catch (SQLException e1) {
				CommonFunctions.f_write_logs("fail,Unable to close the Connection: " + e1.getMessage());
			}
			CommonFunctions.f_write_logs("fail. DB connection or sql generated error: " + e.getMessage() + s_query);
		}
	}
	public static void f_read_config(){
		String s_config_file_path;
		XSSFSheet sourcesheet_user_details;
		s_config_file_path = Global.PATH_CONFIG_FILE_PATH;
		XSSFWorkbook srcBook;
		XSSFSheet sourceSheet;
		try {
			srcBook = new XSSFWorkbook(s_config_file_path);
			sourceSheet = srcBook.getSheetAt(0);
			int rowcounter = sourceSheet.getLastRowNum();
			int clmCounter = sourceSheet.getRow(0).getLastCellNum();
			for(int i=1; i<=rowcounter;i++){
				Global.CONFIG_DATA.put(sourceSheet.getRow(i).getCell(0).toString().trim(), 
						sourceSheet.getRow(i).getCell(1).toString().trim());
			}
			sourcesheet_user_details = srcBook.getSheet("TEST_USERS");
			rowcounter = sourcesheet_user_details.getLastRowNum();
			clmCounter = sourcesheet_user_details.getRow(0).getLastCellNum();
			String temp="";
			for(int i = 1; i <= rowcounter; i++){
				for(int j = 1; j < clmCounter; j++){
					if(temp.equals("")){
						temp = sourcesheet_user_details.getRow(i).getCell(j).toString().trim();
					}else{
						if(j == 2)
							temp = temp + "~" + EncryptDecrypt.f_decrypt_text(sourcesheet_user_details.getRow(i).getCell(j).toString().trim());
						else
							temp = temp + "~" + sourcesheet_user_details.getRow(i).getCell(j).toString().trim();
					}
				}
				Global.CONFIG_DATA.put(sourcesheet_user_details.getRow(i).getCell(0).toString().trim(),temp);
				temp = "";	
			}
		} catch (IOException e1) {
			CommonFunctions.f_write_logs("fail_no_ss","Unable to read Config file: " + e1.getMessage());
		} catch (Exception e2) {
			CommonFunctions.f_write_logs("fail_no_ss","Error Exception in Read Config file function: " + CommonFunctions.f_err_string(e2));
		} 
		srcBook = null;
		sourceSheet=null;
	}
	public static String f_err_string(Exception e){
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		return " PrintStackTraceContent: " + errors.toString();
	}
	public static String f_enrich_input_string_and_save_in_global(String s_message, String s_to_be_replaced, String s_replaced_with){
		String s_message_local = "";
		try{
			if (!(s_to_be_replaced.equalsIgnoreCase(""))){
				if ( (s_replaced_with==null)  ){
					CommonFunctions.f_write_logs("fail_not_exit","Replace with Argument is Null. Can not enrich. Argument passed: To be replaced: " + s_to_be_replaced + " with " + s_replaced_with );
				}else{
					s_message = s_message.replace(s_to_be_replaced,s_replaced_with);
					CommonFunctions.f_write_logs("info","Enriched input data replaced: " + s_to_be_replaced + " with " + s_replaced_with );
				}
			}else{
				if( s_message.contains("[WEB_SERVICE_URL_PUBLIC_USER]")){
					String version = Global.CONFIG_DATA.get("WEB_SERVICE_VERSION");
					String url = "http:
					s_message = s_message.replace("[WEB_SERVICE_URL_PUBLIC_USER]", url );
					Global.CONFIG_DATA.put("[WEB_SERVICE_URL_PUBLIC_USER]", url);
					f_add_enriched_param_in_global("[WEB_SERVICE_URL_PUBLIC_USER]", url);
					CommonFunctions.f_write_logs("info","Enriched input data replaced: " + "[WEB_SERVICE_URL_PUBLIC_USER]" + " with " + url );
				}
	
			}
			return s_message;
		}catch(Exception e){
			CommonFunctions.f_write_logs("fail_no_ss","Fail to enrich input string." + CommonFunctions.f_err_string(e));
			return s_message;
		}
	}
	public static void f_add_enriched_param_in_global(String s_param_name, String s_param_value){
		if (Global.ENRICHED_PARAM.containsKey(s_param_name)){
			int i_size = Global.ENRICHED_PARAM.get(s_param_name).size();
			Global.ENRICHED_PARAM.get(s_param_name).add(s_param_value);
			CommonFunctions.f_write_logs("info", "Param value Added in Enriched Param Field. param Name:  " + s_param_name + " Param Value: " + s_param_value + " Full value: " +  Global.ENRICHED_PARAM.toString() );
		}
		else
		{
			ArrayList al_temp = new ArrayList();
			al_temp.add(0,s_param_value);
			Global.ENRICHED_PARAM.put(s_param_name, al_temp);
			CommonFunctions.f_write_logs("info", "Param created and Aded in Enriched Param Field. param Name:  " + s_param_name + " Param Value: " + s_param_value + " Full value: " +  Global.ENRICHED_PARAM.toString() );
		}
	}
	public static String f_fetch_and_enrich_tc_data_file_content(String s_xml_param,int i_file_index){
		String s_file_path = null;
		try{
			Map<String,Map<String,String>> o_temp =  CommonFunctions.f_parse_xml_return_hashmap(s_xml_param);
			s_file_path = Global.PATH_TC_DATA_FILE + "\\"  + o_temp.get("DataFile").get("FileName").split("~")[i_file_index];
			String s_file_content = CommonFunctions.f_read_text_file(s_file_path);
			s_file_content = CommonFunctions.f_enrich_input_string_and_save_in_global(s_file_content, "", "");
			CommonFunctions.f_write_logs("info", "File Successfully read and enriched and content returned from file path: " + s_file_path + " File Content: " + s_file_content );
			return s_file_content;
		}catch(Exception e){
			CommonFunctions.f_write_logs("fail_no_ss", "Exception thrown while trying to read the file sent in Parameters: " + s_file_path + " Exception: " + CommonFunctions.f_err_string(e) );
			return null;
		}
	}
	public static String f_generate_random_alpa_numeric_string(int i_len_of_string){
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");
		uuid = uuid.substring(0, Math.min(i_len_of_string, uuid.length()));
		return uuid;
	}
	public static  String f_create_date_string_format(Long lDays, String format) {
		Date date = new Date(System.currentTimeMillis() + lDays * 1000L * 60L * 60L * 24L);
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date).replace("/", "");
	}
	public static String f_generate_time_based_unique_integer(){
		String result;
		String y,mon,d,h,min,s,mil;
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1; 
		int day = now.get(Calendar.DAY_OF_MONTH);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		int millis = now.get(Calendar.MILLISECOND);
		y = Integer.toString(year);
		mon = Integer.toString(month);
		d = Integer.toString(day);
		h = Integer.toString(hour);
		min = Integer.toString(minute);
		s = Integer.toString(second);
		mil = Integer.toString(millis);
		result = y+mon+d+h+min+s+mil;
		return result;
	}
	public static String f_generate_random_numeric_string(long i_min, long i_max){
		Random rand = new Random();
		long random = (int )(Math.random() * i_max + i_min);
		String result = Long.toString(random);
		return result;
	}
	public static String f_generate_random_alphabetical_string(int i_length){
		String result = RandomStringUtils.randomAlphabetic(i_length);
		return result;
	}		  
	public static String QueryManagerForDifferentSchema(String s_query){
		String result_query;
		if(  (s_query.toUpperCase().contains("TC_STATUS_SUMMARY")) || (s_query.toUpperCase().contains("TC_LOG_TABLE")) 
				|| (s_query.toUpperCase().contains("AUTO_TC_RUN_ID")) ){
			return s_query;
		}
		if (Global.CONFIG_DATA.get("DB_RE_ENGINEER").equalsIgnoreCase("true")){
			s_query = s_query.replace("dbo", "");
			String[] arr = s_query.split("_", 2);
			s_query = arr[0] + "_SDS." + arr[1].replace("..", ".");
			CommonFunctions.f_write_logs("info", "Query  replaced based on DB reenginner schema. New Query:  " + s_query);
			return s_query;
		}
		if (Global.CONFIG_DATA.get("DB_QUERY_HAS_ENV").equalsIgnoreCase("false")){
			s_query = s_query.replace(Global.ENV_NAME +"_", ""); 
			CommonFunctions.f_write_logs("info", "Query  replaced. New Query:  " + s_query);
			return s_query;
		}
		return s_query; 
	}
	public static  LinkedHashMap<Integer,LinkedHashMap<Integer,String>>  f_get_sql_result_map(String s_query){
		String s_result;
		String connectionUrl;
		Map<String,String> map_result = new HashMap<String,String>(); 
		LinkedHashMap<Integer,String> o_clm_data;
		LinkedHashMap<Integer,LinkedHashMap<Integer,String>> tbl_map_result = new LinkedHashMap<Integer,LinkedHashMap<Integer,String>>();
		String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
		if(  (s_query.toUpperCase().contains("TC_STATUS_SUMMARY")) || (s_query.toUpperCase().contains("TC_LOG_TABLE")) 
				|| (s_query.toUpperCase().contains("AUTO_TC_RUN_ID")) ){
			connectionUrl = Global.DB_REPORT_CONNECTION_STRING;
		}else{
			connectionUrl = Global.SDS_DB_CONNECTION_STRING;  
		}
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs =null;
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(connectionUrl);
			stmt = conn.createStatement();  
			s_query = QueryManagerForDifferentSchema(s_query);
			rs = stmt.executeQuery(s_query);
			ResultSetMetaData rsmd = rs.getMetaData();
			int i_clm_count = rsmd.getColumnCount();
			int i_map_row_counter=0;
			while(rs.next()){					  
				o_clm_data = new LinkedHashMap<Integer,String>();
				for(int i=1;i<=i_clm_count;i++){
					o_clm_data.put(i-1,rs.getString(i));
				}
				tbl_map_result.put(i_map_row_counter, o_clm_data);
				i_map_row_counter = i_map_row_counter + 1;
			}
			if(tbl_map_result.isEmpty()) {
				CommonFunctions.f_write_logs("warn", "Recordset is Empty. i.e. no records have been returned by the query. Connection Url: " + connectionUrl + " and Query: " + s_query);
			}else{
				CommonFunctions.f_write_logs("info", "Recordset has been stored in HashMap and returned. Connection Url: " + connectionUrl + " and Query: " + s_query);			    	  
			}
			return tbl_map_result;
		}catch(SQLException se){
			CommonFunctions.f_write_logs("warn", "SQl Exception: " + se.toString() + " Query used: " + s_query);
			return tbl_map_result;
		}catch(Exception e){
			CommonFunctions.f_write_logs("warn", "Other General Exception: " + e.getMessage() + " Query used: " + s_query);
			return tbl_map_result;
		}finally{
			try{
				if(stmt!=null)
					rs.close();
				conn.close();
			}catch(SQLException se){
				CommonFunctions.f_write_logs("warn","Unable to close connection f_get_sql_result_multiple_records: " + se.getMessage());
			}
			try{
				if(conn!=null)
					rs.close();
				conn.close();
			}catch(SQLException se){
				CommonFunctions.f_write_logs("warn", "Unable to close the Connection f_get_sql_result_multiple_records" + se.getMessage() + " Query used: " + s_query);
			}
		}
	}
	public static  LinkedHashMap<Integer,LinkedHashMap<String,String>>  f_get_sql_result_map_with_col_names(String s_query){
		String s_result;
		String connectionUrl;
		Map<String,String> map_result = new HashMap<String,String>(); 
		LinkedHashMap<String,String> o_clm_data;
		LinkedHashMap<Integer,LinkedHashMap<String,String>> tbl_map_result = new LinkedHashMap<Integer,LinkedHashMap<String,String>>();
		String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
		if(  (s_query.toUpperCase().contains("TC_STATUS_SUMMARY")) || (s_query.toUpperCase().contains("TC_LOG_TABLE")) 
				|| (s_query.toUpperCase().contains("AUTO_TC_RUN_ID")) ){
			connectionUrl = Global.DB_REPORT_CONNECTION_STRING;
		}else{
			connectionUrl = Global.SDS_DB_CONNECTION_STRING;  
		}
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs =null;
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(connectionUrl);
			stmt = conn.createStatement();  
			s_query = QueryManagerForDifferentSchema(s_query);
			rs = stmt.executeQuery(s_query);
			ResultSetMetaData rsmd = rs.getMetaData();
			int i_clm_count = rsmd.getColumnCount();
			int i_map_row_counter=0;
			while(rs.next()){					  
				o_clm_data = new LinkedHashMap<String,String>();
				for(int i=1;i<=i_clm_count;i++){
					o_clm_data.put(rsmd.getColumnName(i),rs.getString(i));
				}
				tbl_map_result.put(i_map_row_counter, o_clm_data);
				i_map_row_counter = i_map_row_counter + 1;
			}
			if(tbl_map_result.isEmpty()) {
				CommonFunctions.f_write_logs("warn", "Recordset is Empty. i.e. no records have been returned by the query. Connection Url: " + connectionUrl + " and Query: " + s_query);
			}else{
				CommonFunctions.f_write_logs("info", "Recordset has been stored in HashMap and returned. Connection Url: " + connectionUrl + " and Query: " + s_query);			    	  
			}
			return tbl_map_result;
		}catch(SQLException se){
			CommonFunctions.f_write_logs("warn", "SQl Exception: " + se.toString() + " Query used: " + s_query);
			return tbl_map_result;
		}catch(Exception e){
			CommonFunctions.f_write_logs("warn", "Other General Exception: " + e.getMessage() + " Query used: " + s_query);
			return tbl_map_result;
		}finally{
			try{
				if(stmt!=null)
					rs.close();
				conn.close();
			}catch(SQLException se){
				CommonFunctions.f_write_logs("warn","Unable to close connection f_get_sql_result_multiple_records: " + se.getMessage());
			}
			try{
				if(conn!=null)
					rs.close();
				conn.close();
			}catch(SQLException se){
				CommonFunctions.f_write_logs("warn", "Unable to close the Connection f_get_sql_result_multiple_records" + se.getMessage() + " Query used: " + s_query);
			}
		}
	}
	public static void f_insert_record_in_db(String s_query){
		String s_result;
		String connectionUrl;
		String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
		if(  (s_query.toUpperCase().contains("TC_STATUS_SUMMARY")) || (s_query.toUpperCase().contains("TC_LOG_TABLE")) 
				|| (s_query.toUpperCase().contains("AUTO_TC_RUN_ID")) ){
			connectionUrl = Global.DB_REPORT_CONNECTION_STRING;
		}else{
			connectionUrl = Global.SDS_DB_CONNECTION_STRING;  
		}
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(connectionUrl);		      
			stmt = conn.createStatement();
			boolean result_flag;
			s_query = QueryManagerForDifferentSchema(s_query);
			result_flag = stmt.execute(s_query);
			CommonFunctions.f_write_logs("info", "Record Successfully inserted/Updated. Query used : " + s_query + " Result Flag: " +  result_flag);
			conn.close();
			stmt= null;
			conn = null;
		}catch(Exception e){
			try {
				conn.close();
				stmt= null;
				conn = null;
			} catch (SQLException e1) {
				CommonFunctions.f_write_logs("fail_no_ss", "Unable to close the Connection: " + e1.getMessage());
			}
			CommonFunctions.f_write_logs("fail_no_ss", "DB connection or sql generated error: " + e.getMessage());
		}
	}
	public static  String f_get_sql_result(String s_query){
		String s_result;
		String connectionUrl;
		String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
		if(  (s_query.toUpperCase().contains("TC_STATUS_SUMMARY")) || (s_query.toUpperCase().contains("TC_LOG_TABLE")) 
				|| (s_query.toUpperCase().contains("AUTO_TC_RUN_ID")) ){
			connectionUrl = Global.DB_REPORT_CONNECTION_STRING;
		}else{
			connectionUrl = Global.SDS_DB_CONNECTION_STRING;  
		}
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs =null;
		try{
			Class.forName(JDBC_DRIVER);			      
			conn = DriverManager.getConnection(connectionUrl);
			stmt = conn.createStatement();
			s_query = QueryManagerForDifferentSchema(s_query);
			rs = stmt.executeQuery(s_query);
			rs.next(); 
			s_result = rs.getString(1);
			if(s_result == null)
				s_result = "";
			rs.close();
			conn.close();
			stmt = null;
			conn = null;
			rs = null;
			CommonFunctions.f_write_logs("info", "Result: " + s_result  +  " . Connection Url: " + connectionUrl + " and Query: " + s_query);
			return s_result;
		}catch(SQLException se){
			CommonFunctions.f_write_logs("warn", "SQl Exception: " + se.getMessage() + " Query used: " + s_query);
			return "false_err";
		}catch(Exception e){
			CommonFunctions.f_write_logs("warn", "Other General Exception: " + e.getMessage() + " Query used: " + s_query);
			return "false_err";
		}finally{
			try{
				if(stmt!=null)
					conn.close();
			}catch(SQLException se){
				CommonFunctions.f_write_logs("warn", "Unable to close the Connection" + se.getMessage() + " Query used: " + s_query);
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				CommonFunctions.f_write_logs("warn", "Unable to close the Connection" + se.getMessage() + " Query used: " + s_query);
			}
		}
	}
	public static  Map<String, String>  f_get_sql_result_multiple_records(String s_query){
		String s_result;
		String connectionUrl;
		Map<String,String> map_result_query = new HashMap<String,String>(); 
		String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
		if(  (s_query.toUpperCase().contains("TC_STATUS_SUMMARY")) || (s_query.toUpperCase().contains("TC_LOG_TABLE")) 
				|| (s_query.toUpperCase().contains("AUTO_TC_RUN_ID")) ){
			connectionUrl = Global.DB_REPORT_CONNECTION_STRING;
		}else{
			connectionUrl = Global.SDS_DB_CONNECTION_STRING;  
		}
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs =null;
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(connectionUrl);
			stmt = conn.createStatement();
			s_query = QueryManagerForDifferentSchema(s_query);
			rs = stmt.executeQuery(s_query);
			ResultSetMetaData rsmd = rs.getMetaData();
			int i_clm_count = rsmd.getColumnCount();
			int i_row_counter = 1;
			String s_temp_row_string="";
			while(rs.next()){
				for(int i=1;i<=i_clm_count;i++){
					if(i==1){
						s_temp_row_string =  rs.getString(i).trim();
					}else{
						s_temp_row_string =  s_temp_row_string + "~" + rs.getString(i).trim();
					}
				}
				map_result_query.put("ROW_"+i_row_counter,s_temp_row_string.trim());
				i_row_counter = i_row_counter +1;
			}
			if(map_result_query.isEmpty()){
				CommonFunctions.f_write_logs("warn", "Recordset is Empty. i.e. no records have been returned by the query. Connection Url: " + connectionUrl + " and Query: " + s_query);
			}else{
				CommonFunctions.f_write_logs("info", "Recordset has been stored in HashMap and returned. Connection Url: " + connectionUrl + " and Query: " + s_query);			    	  
			}
			return map_result_query;
		}catch(SQLException se){
			CommonFunctions.f_write_logs("warn", "SQl Exception: " + se.toString() + " Query used: " + s_query);
			return map_result_query;
		}catch(Exception e){
			CommonFunctions.f_write_logs("warn", "Other General Exception: " + e.getMessage() + " Query used: " + s_query);
			return map_result_query;
		}finally{
			try{
				if(stmt!=null)
					rs.close();
				conn.close();
			}catch(SQLException se){
				CommonFunctions.f_write_logs("warn","Unable to close connection f_get_sql_result_multiple_records: " + se.getMessage());
			}
			try{
				if(conn!=null)
					rs.close();
				conn.close();
			}catch(SQLException se){
				CommonFunctions.f_write_logs("warn", "Unable to close the Connection f_get_sql_result_multiple_records" + se.getMessage() + " Query used: " + s_query);
			}
		}
	}
	public static  ResultSet f_get_sql_recordset(String s_query){
		String connectionUrl;
		String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
		if(  (s_query.toUpperCase().contains("TC_STATUS_SUMMARY")) || (s_query.toUpperCase().contains("TC_LOG_TABLE")) 
				|| (s_query.toUpperCase().contains("AUTO_TC_RUN_ID")) ){
			connectionUrl = Global.DB_REPORT_CONNECTION_STRING;
		}else{
			connectionUrl = Global.SDS_DB_CONNECTION_STRING;  
		}
		CommonFunctions.f_write_logs("info", "Connection Url: " + connectionUrl + " and Query: " + s_query);
		ResultSet rs;
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(connectionUrl);
			stmt = conn.createStatement();
			s_query = QueryManagerForDifferentSchema(s_query);
			rs = stmt.executeQuery(s_query);
			return rs;
		}catch(SQLException se){
			CommonFunctions.f_write_logs("info", se.getMessage());
			return null;
		}catch(Exception e){
			CommonFunctions.f_write_logs("info", e.getMessage());
			return null;
		}
	}
	public static int f_update_record_in_db(String s_query){
		int result_count = 0;
		String connectionUrl;
		String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
		if(  (s_query.toUpperCase().contains("TC_STATUS_SUMMARY")) || (s_query.toUpperCase().contains("TC_LOG_TABLE")) 
				|| (s_query.toUpperCase().contains("AUTO_TC_RUN_ID")) ){
			connectionUrl = Global.DB_REPORT_CONNECTION_STRING;
		}else{
			connectionUrl = Global.SDS_DB_CONNECTION_STRING;  
		}
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(connectionUrl);		      
			stmt = conn.createStatement();
			s_query = QueryManagerForDifferentSchema(s_query);
			result_count = stmt.executeUpdate(s_query);
			if(result_count > 0)
				CommonFunctions.f_write_logs("info", "Record Successfully Updated. Query used : " + s_query + " Result Count: " +  result_count);
			else
				CommonFunctions.f_write_logs("warn", "No Record Updated. Query used : " + s_query + " Result Count: " +  result_count);
			conn.close();
			stmt = null;
			conn = null;
		}catch(Exception e){
			try {
				conn.close();
				stmt = null;
				conn = null;
			} catch (SQLException e1) {
				CommonFunctions.f_write_logs("fail_no_ss", "Unable to close the Connection: " + f_err_string(e1));
			}
			CommonFunctions.f_write_logs("fail_no_ss", "DB connection or sql generated error: " +  f_err_string(e));
		}
		return result_count;
	}
	public static boolean f_wait_until_db_value_matches(String s_query,String s_expected_to_string, int TIME_OUT_IN_MILI_SECONDS){
		try{
			CommonFunctions.f_write_logs("info", "Will search for String: '" + s_expected_to_string+ "'" );
			String result;
			for (int i=0;i<=(TIME_OUT_IN_MILI_SECONDS/1000);i++){
				result = CommonFunctions.f_get_sql_result(s_query);
				if (result.trim().equalsIgnoreCase(s_expected_to_string.trim())){
					CommonFunctions.f_write_logs("info", "Matching value appeared after: " + i + " seconds. Returning from the method.");
					return true;
				}else{
					if (i<=TIME_OUT_IN_MILI_SECONDS){
						Thread.sleep(1000);	
					}else{
						CommonFunctions.f_write_logs("warn", "Could not find Matching value even after : " + i + " seconds.Time out reached. Existing. "
								+ " Expected: " + s_expected_to_string + " Actual: " + result);
						return false;
					}
				}
			}
			return false;
		}catch(Exception e){
			CommonFunctions.f_write_logs("warn", "Exception caught during db value waiting. Exception: " + CommonFunctions.f_err_string(e));
			return false;
		}
	}
	public static void f_copy_file_using_stream(File source, File dest) throws IOException {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} finally {
			is.close();
			os.close();
		}
	}
	public static String f_read_text_file(String s_file_path){
		try{
			Path path = Paths.get(s_file_path);
			String temp = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
			CommonFunctions.f_write_logs("info", "File Successfully read and content returned from file path: " + s_file_path);
			return temp;
		}catch(Exception e){
			CommonFunctions.f_write_logs("fail_no_ss", "Exception thrown while trying to read the file: " + s_file_path + " Exception: " + CommonFunctions.f_err_string(e) );
			return null;
		}
	}
	public static void f_delete_file(String s_file_path){
		try{
			File o_file = new File(s_file_path);
			if (o_file.exists()){
				if (o_file.delete()){
					CommonFunctions.f_write_logs("info", "File Deleted from location: " + s_file_path);
				}else{
					CommonFunctions.f_write_logs("fail_no_ss", "Unable to delete file from location: " + s_file_path);
				}
			}else{
				CommonFunctions.f_write_logs("warn", "Unable to delete file from location as file not found at location: " + s_file_path);
			}
		}catch(Exception e){
			CommonFunctions.f_write_logs("fail_no_ss", "Exception thrown while trying to delte the file: " + s_file_path + " Exception: " + CommonFunctions.f_err_string(e) );
		}
	}
	public static void f_create_file(String s_file_path, String s_text){
		try {
			FileWriter fileWriter =
					new FileWriter(s_file_path);
			BufferedWriter bufferedWriter =
					new BufferedWriter(fileWriter);
			bufferedWriter.write(s_text);
			bufferedWriter.close();
			CommonFunctions.f_write_logs("info", "Text written to file. File Location: " + s_file_path + " Text Written: " + s_text);
		}catch(Exception e){
			CommonFunctions.f_write_logs("fail_no_ss", "Exception thrown while trying to create and write to the file: " + s_file_path + " Exception: " + CommonFunctions.f_err_string(e) );
		}
	}
	public static void f_create_directory(String path, String folder_name) {
		File dir_name = new File(path + "
		if(!dir_name.exists()) {
			boolean result = false;
			try {
				dir_name.mkdir();
				result = true;
			} 
			catch(SecurityException se) {
				se.printStackTrace();
			}
			if(result) {
				System.out.println("Directory with name " + dir_name + " created on path " + path);
			}
		}
	}
	public static void f_fluent_wait_for_webelement(WebDriver driver, WebElement element, int timoutSec, int pollingSec) {
		if(timoutSec == -1) {
			timoutSec = Global.TIME_OUT_OBJECT_WAIT;
		}
		try {	
			FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(timoutSec, TimeUnit.MILLISECONDS)
					.pollingEvery(pollingSec, TimeUnit.MILLISECONDS)
					.ignoring(TimeoutException.class)
					.ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class);
			fWait.until(ExpectedConditions.visibilityOf(element));    	
			fWait.until(ExpectedConditions.elementToBeClickable(element));
			f_write_logs("info","Wait for Element complete." + element.toString());
		} catch (Exception e) {
			f_write_logs("warn"," Error Observed while waiting for Element.  Stack Strace : " + f_err_string(e));
		}
	}
	public static boolean f_wait_for_url_change(WebDriver driver,final String sPreviousUrl){
		try{
			WebDriverWait wait = new WebDriverWait(driver, (Global.TIME_OUT_MAX/1000));
			ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return (d.getCurrentUrl() != sPreviousUrl);
				}
			};
			wait.until(e);
			String sCurrentUrl = driver.getCurrentUrl();
			if(sCurrentUrl.equalsIgnoreCase(sPreviousUrl)){
				CommonFunctions.f_write_logs("info","Url changed " + "New URL : '" + sCurrentUrl + "' ##### Old URL '" + sPreviousUrl + "'");
				return true;
			}else{
				CommonFunctions.f_write_logs("warn","Url not changed even after waiting for:  " +( Global.TIME_OUT_MAX) + " ms. New URL : '" + sCurrentUrl + "' ##### Old URL '" + sPreviousUrl + "'");
				return false;
			}
		}catch(Exception e){
			CommonFunctions.f_write_logs("fail_not_exit","url not change or failed to wait for url change.Exception thrown: " + CommonFunctions.f_err_string(e));
			return false;
		}
	}
	public static void f_wait_for_text_box_value(WebElement element, String s_value){
		WebDriverWait wait = new WebDriverWait(Global.driver, Global.TIME_OUT_OBJECT_WAIT);
		try {
			wait.until(ExpectedConditions.textToBePresentInElementValue(element, s_value));
		} 
		catch (Exception e) {
			CommonFunctions.f_write_logs("info","Exception caught during waiting for text box to turn to value '" + CommonFunctions.f_err_string(e) + "'");
		}
	}
	public static Date f_date_time_convert_local_to_gmt(Date date, String s_format) {
		SimpleDateFormat sdf = new SimpleDateFormat(s_format);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String s_day_light_saving = Global.CONFIG_DATA.get("DAY_LIGHT_SAVING");
		if ((s_day_light_saving.equalsIgnoreCase("On")) || (s_day_light_saving.equalsIgnoreCase("true"))){
			cal.add(Calendar.HOUR_OF_DAY, -4);
		}else if ((s_day_light_saving.equalsIgnoreCase("Off")) || (s_day_light_saving.equalsIgnoreCase("false"))){
			cal.add(Calendar.HOUR_OF_DAY, -5);
		}else{
			cal.add(Calendar.HOUR_OF_DAY, -5);
		}
		cal.add(Calendar.MINUTE,-30);
		CommonFunctions.f_write_logs("info","Time Coverted to gmt: " + 
				cal.getTime().toString() + "  Original Time: " + date.toString() );
		return cal.getTime();
	}
	public static Date f_date_time_gmt_to_local(Date date) {
		String timeZone = Calendar.getInstance().getTimeZone().getID();
		Date local = new Date(date.getTime() + TimeZone.getTimeZone(timeZone).getOffset(date.getTime()));
		return local;
	}
	public static Date f_date_time_convert_string_to_date(String dateInString,String s_format) {
		try{	
			SimpleDateFormat sdf1 = new SimpleDateFormat(s_format);
			Date date1;
			date1 = sdf1.parse(dateInString);
			return (date1);
		}catch (ParseException e) {
			CommonFunctions.f_write_logs("warn", "unable to convert date. " + CommonFunctions.f_err_string(e));
			return (null);
		}
	}
	public static Date f_date_time_get_current_date_time(String s_format) {
		try{	
			SimpleDateFormat dateFormat = new SimpleDateFormat(s_format);
			Date date = new Date();
			return (dateFormat.parse(dateFormat.format(date)));
		}catch (ParseException e) {
			CommonFunctions.f_write_logs("warn", "unable to generate current date. " + CommonFunctions.f_err_string(e));
			return (null);
		}
	}
	public static void f_navigate_to_url(WebDriver driver,String s_url){
		String[] arr_pwd_url = null;
		String[] arr_user_pwd = null;
		try{
			driver.get(s_url);
			try {
				if(s_url.contains("@")) {
					arr_pwd_url = s_url.split("@");
					arr_user_pwd = arr_pwd_url[0].split(":");
					s_url = arr_user_pwd[0] + ":" + arr_user_pwd[1] + "@" + arr_pwd_url[1];
				}
			} catch(Exception e){
				CommonFunctions.f_write_logs("info","problem found in splitting user id and pwd.");
			}
			if(s_url.contains("@"))
				CommonFunctions.f_write_logs("info","Navigating to URL: " + arr_user_pwd[0] + "@" + arr_pwd_url[1]);
			else
				CommonFunctions.f_write_logs("info","Navigating to URL: " + s_url);
		}catch(Exception e){
			if(s_url.contains("@"))
				CommonFunctions.f_write_logs("fail","Unable to navigate to URL: " + arr_user_pwd[0] + "@" + arr_pwd_url[1] + "  Due to Exception: " + CommonFunctions.f_err_string(e));
			else
				CommonFunctions.f_write_logs("fail","Unable to navigate to URL: " + s_url + "  Due to Exception: " + CommonFunctions.f_err_string(e));
		}
	}
	public static String f_url_username_pass_string(String s_user_acc_key){
		try{
			String s_user_name,s_password;
			s_user_name = Global.CONFIG_DATA.get(s_user_acc_key).split("~")[0];
			s_password = Global.CONFIG_DATA.get(s_user_acc_key).split("~")[1];
			return (s_user_name+":"+s_password);
		}catch(Exception e){
			CommonFunctions.f_write_logs("fail_no_ss","Error Observed. Root cause can be user id not present in the config file. " + s_user_acc_key + CommonFunctions.f_err_string(e));
			return null;
		}
	}
	public static Map<String,Integer> f_get_table_col_indices_from_col_model(WebElement o_col_model){
		try{
			String s_inner_text = o_col_model.getText();
			String[] a_text = s_inner_text.split("\\n");
			Map<String,Integer> o_col_map = new HashMap<String,Integer>();
			for(int i=0; i<a_text.length;i++){
				o_col_map.put(a_text[i].trim(), i+1); 
			}
			return o_col_map;
		}
		catch (Exception e) {
			CommonFunctions.f_write_logs("info","Exception caught while feching column names and indices info" + CommonFunctions.f_err_string(e) + "'");
			return null;
		}
	}
	public static Map<String, Map<String, String>> f_parse_xml_return_hashmap(String xml){
		Map<String, Map<String, String>> o_result=null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			if(xml.contains("\"<")) {
				xml = xml.replace("\"<", "\"");
			}
			InputSource is = new InputSource(new StringReader(xml));
			Document doc;
			doc = dBuilder.parse(is);
			doc.getDocumentElement().normalize();
			NodeList o_node = doc.getElementsByTagName("*");
			NamedNodeMap o_att=null;
			String s_att_name=null;
			String s_att_val = null;
			String s_tag_name = null;
			o_result = new HashMap<String, Map<String, String>>();
			Map<String,String> o_temp_att;
			for(int i=0;i< o_node.getLength();i++){
				s_tag_name = o_node.item(i).getNodeName().trim();
				o_temp_att = new HashMap<String,String>();
				o_att = o_node.item(i).getAttributes();
				for (int j=0;j< o_att.getLength();j++){
					s_att_name = o_att.item(j).getNodeName().trim();
					s_att_val = o_att.item(j).getNodeValue().trim();
					if (!(o_result.containsKey(s_tag_name))){
						o_temp_att.put(s_att_name.trim(), s_att_val.trim());
					}else{
						o_result.get(s_tag_name).put(s_att_name,o_result.get(s_tag_name).get(s_att_name) + "~" + s_att_val);
					}
				}
				if (!(o_result.containsKey(s_tag_name))){
					o_result.put(s_tag_name, o_temp_att);
				}
			}
			CommonFunctions.f_write_logs("info","Input XML parsed and saved in has map: " + o_result.toString());
		} catch (SAXException e1) {
			CommonFunctions.f_write_logs("fail_no_ss", "unable to parse input xml. Error:  SAXException:"+ CommonFunctions.f_err_string(e1) );
		} catch (IOException e2) {
			CommonFunctions.f_write_logs("fail_no_ss", "unable to parse input xml. Error:  IOException:"+ CommonFunctions.f_err_string(e2) );
		} catch (ParserConfigurationException e3) {
			CommonFunctions.f_write_logs("fail_no_ss", "unable to parse input xml. Error:  ParserConfigurationException:"+ CommonFunctions.f_err_string(e3) );
		} catch (Exception e){
			CommonFunctions.f_write_logs("fail_no_ss","unable to parse input xml. Error: " + CommonFunctions.f_err_string(e));
		}
		return o_result;
	}
	public static void f_compare_mq_maps(Map<String, Map<String, String>> mq_map_result,
			Map<String, Map<String, String>> exp_map_result) {
		String s_key,s_exp_tag_key,s_exp_tag_val,s_act_tag_val,s_log_text = null;
		try{
			for(Entry<String, Map<String, String>> entry : exp_map_result.entrySet())
			{
				s_key = entry.getKey();
				Map<String, String> internalMap = entry.getValue();
				for(Entry<String, String> internalEntry : internalMap.entrySet())
				{
					s_exp_tag_key = internalEntry.getKey();
					s_exp_tag_val = internalEntry.getValue();
					s_exp_tag_val = s_exp_tag_val.replace("Add", "");
					try{
						s_act_tag_val = mq_map_result.get(s_key).get(s_exp_tag_key); 
						s_log_text = "MQ Tag :: " + s_key + " : " + s_exp_tag_key + " Expected " + s_exp_tag_val + " = Actual " + s_act_tag_val;
						if(s_act_tag_val.replace(" ", "").contains(s_exp_tag_val.replace(" ", ""))){
							CommonFunctions.f_write_logs("pass_no_ss", s_log_text);
						}else{
							CommonFunctions.f_write_logs("fail_no_ss", s_log_text.replace("=", "!="));
						}
					}
					catch (Exception e) {
						CommonFunctions.f_write_logs("info","Exception caught while comparing expected vs actual mq tag#value map for '" + s_log_text + "\\r\\n" + CommonFunctions.f_err_string(e) + "'");
					}
				}
			}  
		}
		catch (Exception e) {
			CommonFunctions.f_write_logs("info","Exception caught while comparing expected vs actual mq tag#value map for '" + CommonFunctions.f_err_string(e) + "'");
		}
	}
	public static void f_compare_mq_entire_node(String s_mq_xml, String s_exp_node_text){
		try{
			if(!s_mq_xml.replace(" ","").toLowerCase().contains(s_exp_node_text.replace(" ","").toLowerCase())){
				CommonFunctions.f_write_logs("fail_not_exit_no_ss","Expected Node '" + s_exp_node_text + "' not found in the MQ XML message");
			}else{
				CommonFunctions.f_write_logs("pass_no_ss","Expected Node '" + s_exp_node_text + "' found in the MQ XML message");
			}
		}catch(Exception e){
			CommonFunctions.f_write_logs("fail_not_exit_no_ss","Exception caught during MQ check for node '" + s_exp_node_text + "'. Exception : " + CommonFunctions.f_err_string(e) + "'");  
		}
	}
	public static void setClipboardContents(String text) {
		StringSelection stringSelection = new StringSelection( text );
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}
	public static int f_return_number_of_opened_process(String process_name, String by_user){
		String a = System.getenv("windir") + "\\system32\\"+"tasklist.exe /fo csv /nh /FI \"USERNAME eq "  +  by_user + "\"";
		int p_counter=0;
		try {
			String process;
			Process p = Runtime.getRuntime().exec(a);
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((process = input.readLine()) != null) {
				if (  process.toLowerCase().contains(process_name.toLowerCase())  ){
					p_counter = p_counter +1;
				}
			}
			input.close();
			CommonFunctions.f_write_logs("info", "Number of open process found for process : " + 
					process_name + " Total instances opened for the  process: " + p_counter);
			return p_counter;
		} catch (Exception e) {
			CommonFunctions.f_write_logs("fail_not_exit_no_ss", "Unable to find all the open process due to exception : " + CommonFunctions.f_err_string(e));
			return 0;
		}
	}
	public static String f_create_next_int_run_id(String path) {
		File file = new File(path);
		String[] directories = file.list(new FilenameFilter() {
			@Override
			public boolean accept(File current, String name) {
				return new File(current, name).isDirectory();
			}
		});
		if(directories == null || directories.length == 0) {
			f_create_directory(path, "1");
			return "1";
		}
		else{
			String lastNum = directories[directories.length-1];
			int nextNum = Integer.parseInt(lastNum) + 1;
			f_create_directory(path, Integer.toString(nextNum));
			return Integer.toString(nextNum);
		}
	}
	public static void f_clean_up(WebDriver driver, String s_flag) {
		driver.quit();
		driver=null;
	}
	public static int f_array_check_element(String[] s_array,String s_value) {
		try{
			for(int i=0; i<s_array.length; i++){
				if(s_array[i].trim().equalsIgnoreCase(s_value))
					return i;
			}
			return -1;
		}
		catch (Exception e) {
			CommonFunctions.f_write_logs("info","Exception caught while checking for element '" + s_value + " existence in array " + s_array.toString() + " '" + CommonFunctions.f_err_string(e) + "'");
			return -1;
		}
	}
	public static Map<Integer, Map<String, String>> f_get_multiple_distinct_hash_maps(Map<String, Map<String, String>> o_combined_hash_map, String s_node_name){
		try{
			String s_internal_key,s_internal_val;
			LinkedHashMap<Integer, Map<String, String>> o_main_map = null;
			LinkedHashMap<String, String> o_sub_map;
			o_main_map = new LinkedHashMap<Integer,Map<String,String>>();
			for(Entry<String, Map<String, String>> entry : o_combined_hash_map.entrySet())
			{
				if(entry.getKey().trim().equalsIgnoreCase(s_node_name.trim())){
					Map<String, String> internalMap = entry.getValue();
					for(Entry<String, String> internalEntry : internalMap.entrySet())
					{
						s_internal_key = internalEntry.getKey();
						s_internal_val = internalEntry.getValue();
						int j=0;
						for (String str:s_internal_val.split("~")){
							o_sub_map = new LinkedHashMap<String,String>();
							o_sub_map.put(s_internal_key, str);
							if(o_main_map.containsKey(j)){
								o_main_map.get(j).put(s_internal_key,str);
							}else{
								o_main_map.put(j, o_sub_map);
							}
							j++;
						}
					}
				}
			}
			return o_main_map;
		} catch (Exception e) {
			CommonFunctions.f_write_logs("fail_not_exit","Exception caught while trying to prepare separate maps from combined map");
			return null;
		}
	}
	public static boolean f_arraylist_compare(ArrayList<String> al_1, ArrayList<String> al_2){
		try{
			if (al_1 == null && al_2 == null) return true;
			if (al_1 == null || al_2 == null) return false;
			Collections.sort(al_1);
			Collections.sort(al_2);
			return al_1.equals(al_2);
		}catch (Exception e) {
			CommonFunctions.f_write_logs("fail_not_exit","Exception caught while trying to prepare separate maps from combined map");
			return false;
		}
	}
	public static boolean f_get_sql_cellvalue_stringVerification(String s_query, String VerificationString) {
		String s_result;
		boolean ismatch;
		String connectionUrl;
		String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		if ((s_query.toUpperCase().contains("TC_STATUS_SUMMARY")) || (s_query.toUpperCase().contains("TC_LOG_TABLE"))
				|| (s_query.toUpperCase().contains("AUTO_TC_RUN_ID"))) {
			connectionUrl = Global.DB_REPORT_CONNECTION_STRING;
		} else {
			connectionUrl = Global.SDS_DB_CONNECTION_STRING;
		}
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(connectionUrl);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(s_query);
			rs.next();
			s_result = rs.getString(1);
			if (s_result.trim().equalsIgnoreCase(VerificationString)) {
				ismatch = true;
				CommonFunctions.f_write_logs("PASS_NO_SS",
						"Result: " + s_result + " is matched with expected result ==>> "  + VerificationString);
				CommonFunctions.f_write_logs("info",
						"Result: " + s_result + " . Connection Url: " + connectionUrl + " and Query: " + s_query);
			} else {
				ismatch = false;
			}
			rs.close();
			conn.close();
			stmt = null;
			conn = null;
			rs = null;
			return ismatch;
		} catch (SQLException se) {
			CommonFunctions.f_write_logs("warn", "SQl Exception: " + se.getMessage() + " Query used: " + s_query);
			return false;
		} catch (Exception e) {
			CommonFunctions.f_write_logs("warn",
					"Other General Exception: " + e.getMessage() + " Query used: " + s_query);
			return false;
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
				CommonFunctions.f_write_logs("warn",
						"Unable to close the Connection" + se.getMessage() + " Query used: " + s_query);
			} 
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				CommonFunctions.f_write_logs("warn",
						"Unable to close the Connection" + se.getMessage() + " Query used: " + s_query);
			} 
		} 
	}
	@SuppressWarnings("unused")
	public static boolean f_usersetup_ismandatorycheck(String TeamID, String UserId, String IsCheckingMandatory, String businessArea) {
		boolean isUpdated = false;
		try{
			String UserName = UserId.split(":")[0];
			if(!TeamID.isEmpty()) {
				String arrTeam = TeamID;
				String[] TeamId = arrTeam.split(",");
				for (String id: TeamId) {
					String SelectQuery = "Select Id From " + Global.ENV_NAME + "_workflow..AnalystTeam Where TeamId = '" + id + "' and UserName = 'INTRANET\\" + UserName + "'";
					String team_id = CommonFunctions.f_get_sql_result(SelectQuery);
					String DescriptionQuery = "Select Description From " + Global.ENV_NAME + "_workflow..Team Where Id = '" + id + "'";
					String TeamName = CommonFunctions.f_get_sql_result(DescriptionQuery);
					if(team_id.equalsIgnoreCase("false_err")) {
						String AnalystTeamTableQuery = "Insert " + Global.ENV_NAME + "_workflow..AnalystTeam (TeamId, UserId, UserName, Role) Values (" + id + ", 0," + "'INTRANET\\" + UserName + "', 'A')";
						CommonFunctions.f_insert_record_in_db(AnalystTeamTableQuery);
						CommonFunctions.f_write_logs("info", "Analyst Role ->" + TeamName + " -> having role Id '" + id + "' is assigned to the user '" + "INTRANET\\" + UserName + "'. Query used " + DescriptionQuery);
						isUpdated = true;
					} else {
						CommonFunctions.f_write_logs("info", "User INTRANET\\" + UserName + " is already assigned with Analyst role -> " + TeamName + "having Role Id '" + id + "'. Query used -> " + DescriptionQuery);
						isUpdated = true;
					}
				}
			}
			if(IsCheckingMandatory.equalsIgnoreCase("Y")){
				String CheckingMandatoryQuery = "Update " + Global.ENV_NAME + "_workflow..UserDetails Set CheckingMandatory = 1 Where UserId = '" + "INTRANET\\" + UserName + "'";
				ResultSet CheckingMandatoryResultSet = CommonFunctions.f_get_sql_recordset(CheckingMandatoryQuery);
				CommonFunctions.f_write_logs("info", "CheckingMandatory flag is set to: " + IsCheckingMandatory + " user :  " + UserName + "  Query used -> " + CheckingMandatoryQuery );
				isUpdated = true;
			}
			if(IsCheckingMandatory.equalsIgnoreCase("N")){
				String CheckingMandatoryQuery = "Update " + Global.ENV_NAME + "_workflow..UserDetails Set CheckingMandatory = 0 Where UserId = '" + "INTRANET\\" + UserName + "'";
				ResultSet CheckingMandatoryResultSet = CommonFunctions.f_get_sql_recordset(CheckingMandatoryQuery);
				CommonFunctions.f_write_logs("info", "CheckingMandatory flag is set to: " + IsCheckingMandatory + " user :  " + UserName + "Query used -> " + CheckingMandatoryQuery );
				isUpdated = true;
			}
			if(!businessArea.equals("")){
				String businessAreaQuery = "Update " + Global.ENV_NAME + "_workflow..UserDetails Set BusinessArea = '" + businessArea + "' Where UserId = '" + "INTRANET\\" + UserName + "'";
				ResultSet businessAreaResultSet = CommonFunctions.f_get_sql_recordset(businessAreaQuery);
				CommonFunctions.f_write_logs("info", "Business Area is updated to: " + businessArea + " user :  " + UserName + "  Query used -> " + businessAreaQuery );
				isUpdated = true;
			}
			return isUpdated;
		}catch(Exception e){
			CommonFunctions.f_write_logs("fail_not_exit", "Team set up not done due to run time exception. Exception: " + CommonFunctions.f_err_string(e));
			return isUpdated;
		}
	}
	public static boolean f_usersetup_delete_team(String TeamID, String UserId) {
		boolean isUpdated = false;
		try{
			String UserName = UserId.split(":")[0];
			if(!TeamID.isEmpty()) {
				String arrTeam = TeamID;
				String[] TeamId = arrTeam.split(",");
				for (String id: TeamId) {
					String SelectQuery = "Select Id From " + Global.ENV_NAME + "_workflow..AnalystTeam Where TeamId = '" + id + "' and UserName = 'INTRANET\\" + UserName + "'";
					String team_id = f_get_sql_result(SelectQuery);
					String DescriptionQuery = "Select Description From " + Global.ENV_NAME + "_workflow..Team Where Id = '" + id + "'";
					String TeamName = f_get_sql_result(DescriptionQuery);
					if(!team_id.equalsIgnoreCase("false_err")) {
						String AnalystTeamTableQuery = "Delete From " + Global.ENV_NAME + "_workflow..AnalystTeam Where TeamId = " + id + " AND UserName = 'INTRANET\\" + UserName + "'";
						f_update_record_in_db(AnalystTeamTableQuery);
						f_write_logs("info", "Analyst Role ->" + TeamName + " -> having role Id '" + id + "' is deleted from the user '" + "INTRANET\\" + UserName + "'. Query used " + DescriptionQuery);
						isUpdated = true;
					} else {
						f_write_logs("info", "User INTRANET\\" + UserName + " is not assigned with Analyst role -> " + TeamName + "having Role Id '" + id + "'. Query used -> " + DescriptionQuery);
						isUpdated = true;
					}
				}
			}
			return isUpdated;
		}catch(Exception e){
			f_write_logs("fail_not_exit", "Team set up not done due to run time exception. Exception: " + CommonFunctions.f_err_string(e));
			return isUpdated;
		}
	}
	public static String ReplaceJSONSubStringBasedOnAttributeValue(String searchableString,String keyword,String searchString,String replacewith){
		try{
			Scanner scanner = new Scanner(searchableString);
			String NewJsonLine="";
			String JsonInputline;
			while (scanner.hasNextLine()) {
				JsonInputline = scanner.nextLine();
				if (JsonInputline.contains(keyword)){
					NewJsonLine=NewJsonLine+JsonInputline.replace(searchString, replacewith)+"\n";
				}
				else{
					NewJsonLine=NewJsonLine+JsonInputline+"\n";
				}
			}
			System.out.println(NewJsonLine);
			scanner.close();
			return NewJsonLine;
		}catch (Exception e){
			CommonFunctions.f_write_logs("fail_no_ss","issue with input string   Stack trace: " + CommonFunctions.f_err_string(e));
			return "";
		}
	}
	public static boolean f_wait_until_db_value_appears(String s_query, int TIME_OUT_IN_MILI_SECONDS){
		try{
			CommonFunctions.f_write_logs("info", "Will search and wait for any value other than false_err or null" );
			String result;
			for (int i=0;i<=(TIME_OUT_IN_MILI_SECONDS/1000);i++){
				result = CommonFunctions.f_get_sql_result(s_query);
				if (   (result.trim().equalsIgnoreCase("false_err")) || (result.trim().isEmpty())   ){
					if (i<=TIME_OUT_IN_MILI_SECONDS){
						Thread.sleep(1000);	
					}else{
						CommonFunctions.f_write_logs("warn", "Could not find any value even after : " + i + " seconds.Time out reached. Existing. "
								+ " Expected: Any value other than false_err/blank string Actual: " + result);
						return false;
					}
				}else{
					CommonFunctions.f_write_logs("info", "Matching value appeared after: " + i + " seconds. Returning from the method.");
					return true;
				}
			}
			return false;
		}catch(Exception e){
			CommonFunctions.f_write_logs("warn", "Exception caught during db value waiting. Exception: " + CommonFunctions.f_err_string(e));
			return false;
		}
	}
	public static boolean isnumeric(String strNum) {
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException | NullPointerException e) {
	    	CommonFunctions.f_write_logs("warn", "Exception coccur " + CommonFunctions.f_err_string(e));
	        return false;
	    }
	    return true;
	}
}