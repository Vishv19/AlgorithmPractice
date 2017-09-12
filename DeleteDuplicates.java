import java.util.*;

public class DeleteDuplicates {
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(2);
		A.add(3);
		A.add(5);
		A.add(5);
		A.add(7);
		A.add(11);
		A.add(11);
		A.add(11);
		A.add(13);
		System.out.println(A);
		deleteDuplicates(A);
		System.out.println(A);
	}

	public static int deleteDuplicates(List<Integer> A) {
		if(A.size() == 0) {
			return 0;
		}

		int writeIndex = 1;
		for(int i = 1; i < A.size(); i++) {
			System.out.println("writeIndex: " + writeIndex);
			System.out.println("i: " + i);
			if(!A.get(writeIndex - 1).equals(A.get(i))) {
				// System.out.println("in condition");
				A.set(writeIndex++, A.get(i));
			}
		}
		return writeIndex;
	}
}

https://jsonmock.hackerrank.com/api/movies/search/?Title=


    static int getNumberOfMovies(String substr) {
        String baseurl = "https://jsonmock.hackerrank.com/api/movies/search/?Title=";
        String finalurl = baseurl + substr;
        int total = 0;
        try {
            URL geturlObj = new URL(finalurl);
            HttpURLConnection con = (HttpURLConnection) geturlObj.openConnection();
            con.setRequestMethod("GET");

            int resCode = con.getResponseCode();
            BufferedReader bufRead = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String interResponse;
            StringBuffer finalResponse = new StringBuffer();
            while((interResponse = bufRead.readLine())!=null) {
                finalResponse.append(interResponse);
            }
            bufRead.close();
            String jsonString = finalResponse.toString();
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonString);            
            System.out.println((String)jsonObject.get("total"));
            String totalStr = (String)jsonObject.get("total");
            total = Integer.parseInt(totalStr);
        }
        catch(Exception e) {
            
        }

    return total;
    }


    