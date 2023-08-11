package api;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataApi {
	
	private final HttpClient httpClient;
	private final String urlListaUsuarios ="https://gorest.co.in/public/v2/users";
	private final String urlUsuario ="https://fakestoreapi.com/users/" ;
	
	public DataApi() {
		httpClient = HttpClients.createDefault();
	}

	private String makeHttpRequest(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse response = httpClient.execute(httpGet);
            return EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
            throw e; 
        }
    }
	
	public String  listaUsuariosNombres() {	         
       try {      	
            String jsonResponse = makeHttpRequest(urlListaUsuarios);
            JSONArray jsonArray = new JSONArray(jsonResponse);
            
            return (jsonArray.length() > 0) ? jsonArray.getJSONObject(0).getString("name") : null;
     
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
		return null;       
	}

	public JSONObject obtenerDatosUsuariosById(String userId) throws IOException {		
				
		String jsonResponse = makeHttpRequest(urlUsuario + userId);
		try {     
	         return new JSONObject(jsonResponse);	         
		} catch (JSONException e) {
			e.printStackTrace();
		}		
		return null;		
	}
}
