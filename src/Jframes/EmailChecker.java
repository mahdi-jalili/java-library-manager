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

    public static void main(String[] args) {
        EmailChecker ec = new EmailChecker();
        String emailadd = "mahdijalili@gmail.com";
        int length = emailadd.length();
        try {
            String ecc = ec.checkEmail(emailadd);
            System.out.println(ecc);
            System.out.println(ecc.charAt(length + 79));
            char torf = ecc.charAt(length + 79);
            if (torf == 't') {
                System.out.println("The email is exist");
            } else if (torf == 'f') {
                System.out.println("The email is not exist");
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
