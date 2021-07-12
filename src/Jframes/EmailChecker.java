package Jframes;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class EmailChecker {

    private final String apikey = "4ce76c67eb760aeabbe5c8d9f73a6827";

    private String checkEmail(String email) throws Exception {

        String url = "https://apilayer.net/api/check?access_key=" + apikey + "&email=" + email + "&smtp=1&format=1";

        URL urlobj = new URL(url);

        HttpURLConnection con = (HttpURLConnection) urlobj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/17.0");

        BufferedReader at = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = at.readLine()) != null) {
            response.append(inputLine);
        }
        at.close();

        //print result
        return response.toString();
        // System.out.println(response.toString());
    }

    public boolean checker(String email) {
        boolean isExist = false;
        EmailChecker ec = new EmailChecker();
        try {
            String ecc = ec.checkEmail(email);
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
