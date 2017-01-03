package com.spreadsheet.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.spreadsheet.services.RedisDataService;


public class SpreadSheet {
	
	/*@Autowired
	private static QuickStartService qsService;
	*/
	
    /** Application name. */
    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";

    /** Directory to store user credentials for this application. */
    private static final java.io.File DATA_STORE_DIR = new java.io.File( System.getProperty("user.home"), ".credentials/sheets.googleapis.com-java-quickstart");

    /** Global instance of the {@link FileDataStoreFactory}. */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY =
        JacksonFactory.getDefaultInstance();

    /** Global instance of the HTTP transport. */
    private static HttpTransport HTTP_TRANSPORT;

    /** Global instance of the scopes required by this quickstart.
     *
     * If modifying these scopes, delete your previously saved credentials
     * at ~/.credentials/sheets.googleapis.com-java-quickstart
     */
    private static final List<String> SCOPES =
        Arrays.asList(SheetsScopes.SPREADSHEETS_READONLY);
   /* private static final List<String> SCOPES =
            Arrays.asList(SheetsScopes.SPREADSHEETS,SheetsScopes.DRIVE);*/
    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Creates an authorized Credential object.
     * @return an authorized Credential object.
     * @throws Exception 
     */
    public static Credential authorize() throws Exception {
        // Load client secrets.
        //InputStream in = Quickstart.class.getResourceAsStream("/client_secret.json");
        InputStream in = new FileInputStream("/home/bridgeit/client_secret.json");
        
        GoogleClientSecrets clientSecrets =
            GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow =
                new GoogleAuthorizationCodeFlow.Builder(
                        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(DATA_STORE_FACTORY)
                .setAccessType("offline")
                .build();
        Credential credential = new AuthorizationCodeInstalledApp(
            flow, new LocalServerReceiver()).authorize("user");
        System.out.println(
                "Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    /**
     * Build and return an authorized Sheets API client service.
     * @return an authorized Sheets API client service
     * @throws Exception 
     */
    public static Sheets getSheetsService() throws Exception {
        Credential credential = authorize();
        return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

   /* @RequestMapping(name="/getfomdata")*/
    public void getAndStore()
    {
    	try {
			getSheetData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void main(String[] args) throws Exception {
    	getSheetData();
    }
    
    private static void getSheetData() throws Exception {
    	
        // Build a new authorized API client service.
        Sheets service = getSheetsService();
    	/*QuickStartDto qs=new QuickStartDto();*/
        // Prints the names  of students in a sample spreadsheet:
        // https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit
        String spreadsheetId = "1CZPzCBwp3-SviyvmTvgsIcLotvAzuG_H5rFYzQ3aQFE";
        /*String range = "MyTestSheet!A1:AZ2000";*/
        String range = "Sheet1!A1:AZ2000";
       
        ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
        List<List<Object>> rows = response.getValues();
    	System.out.println(rows.size());
        if ( rows != null && rows.size() > 0 ) {
        	//getting frst row
        	List<Object> rowHeader =  rows.get(0);
        	
        	for (int rowNo = 1;  rowNo < rows.size(); rowNo++) {
        		System.out.println("----");
        		
        		//it returns particular row
        		List<Object> row =  rows.get(rowNo);
        		/*System.out.println(row.size());*/
        		int colNo = 0;
        		Map<String, String> map = new HashMap<String, String>();
        		//it returns column of that particular row
        		for (colNo = 0; colNo < row.size(); colNo++) {
        			map.put((String)rowHeader.get(colNo), (String)row.get( 0));
        			System.out.println((String)row.get(colNo));
        		}
        		
        		
        	/*	RedisDataService.addHash( map.get(  rowHeader.get(0) ) , map );*/
        		RedisDataService.addHash( map.get(  rowHeader.get(1) ) , map );
        		RedisDataService.getHash( map.get(  rowHeader.get(1)));
        		System.out.println(map);
        		
        		//jdis.hset( map.get(  rowHeader.get(0) ) , map);
        		
        	}
        	
        }
       /* String status="";

        try{
            // Print entries
            ListFeed feed = service.getFeed(listFeedUrl, ListFeed.class);

            for (ListEntry entry : feed.getEntries()) {
                System.out.println("new row");
                for (String tag : entry.getCustomElements().getTags())) {
                    System.out.println("     " + tag + ": "
                            + entry.getCustomElements().getValue(tag));
                    status=entry.getCustomElements().getValue(tag);

                }
            }

        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println(status);
        return(status);
        }*/
    }
    
}