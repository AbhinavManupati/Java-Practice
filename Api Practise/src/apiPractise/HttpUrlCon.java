package apiPractise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpUrlCon {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String urlParameters = "email=eve.holt@reqres.in & password=pistol";
		try {
			URL url = new URL("https://reqres.in/api/users");

			URLConnection conn = url.openConnection();

			conn.setDoOutput(true);

			OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

			writer.write(urlParameters);
			writer.flush();

			String line;
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			writer.close();
			reader.close();
			System.out.println("Compiled Successfully!!");
		} catch (MalformedURLException e) {
			System.out.println("The specified URL is malformed: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("An I/O error occurs: " + e.getMessage());
		}
	}
}
