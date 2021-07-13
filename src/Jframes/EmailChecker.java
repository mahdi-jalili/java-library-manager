package Jframes;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

//this class will check that an Email is exist or not
public class EmailChecker {

    //we need a apikey from this site "https://mailboxlayer.com/"
    private final String apikey = "4ce76c67eb760aeabbe5c8d9f73a6827";

    //this method returned the results of existence an email
    private String getResponse(String email) throws Exception {
        //we need a url that is from "https://apilayer.net/" and it contains apikey and email like this format
        String url = "https://apilayer.net/api/check?access_key=" + apikey + "&email=" + email + "&smtp=1&format=1";
        URL urlobj = new URL(url);
        //try connection with url
        HttpURLConnection con = (HttpURLConnection) urlobj.openConnection();

        //optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/17.0");

        //creatin an object of BufferReader class for reading information of an InputStream from con_object
        BufferedReader at = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        //as long as InputStream established, write information in inputLine and add into response_obj 
        while ((inputLine = at.readLine()) != null) {
            response.append(inputLine);
        }

        //close InputStream
        at.close();

        //print result
        return response.toString();
    }

    //this method checked existence an email
    public boolean checker(String email) {
        
        //make a variable for result
        boolean isExist = false;
        try {
            String ecc = this.getResponse(email);
            //the response_output contains many information and we need just one, smtp_check! and smtp_check maybe true or false
            //we neet go to the right position for checking smtp_check is 't'rue or 'f'alse
            char torf = ecc.charAt(ecc.indexOf("smtp_check") + 12);
        
            if (torf == 't') {
                isExist = true;
            } else if (torf == 'f') {
                isExist = false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isExist;
    }
}
