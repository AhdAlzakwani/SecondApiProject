package apiMaven;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) {
		ApiRandom api = new ApiRandom();

		Scanner scannerr = new Scanner(System.in);
		boolean menuExit = true;
		while (menuExit) {
			System.out.println("1- Fetch API AND DISPLAY");
			System.out.println("2- CREATE TABLE IN DATABASE ");
			System.out.println("3- INSERT INTO TABLE ");
			System.out.println("4- READE FROM TABLE ");
			System.out.println("5- UPDATE FROM TABLE ");
			System.out.println("6- DELETE FROM TABLE ");
			int option = scannerr.nextInt();
			switch (option) {

			case 1:
				URL url;
				try {
					url = new URL("https://restcountries.com/v3.1/all");

					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("GET");
					conn.connect();
					StringBuilder apiInformation = new StringBuilder();
					int responseCode = conn.getResponseCode();
					if (responseCode != 200) {
						throw new RuntimeException("HttpresponseCode");

					} else {
						Scanner scanner = new Scanner(url.openStream());
						while (scanner.hasNext()) {
							apiInformation.append(scanner.nextLine());
						}
						scanner.close();
						// System.out.println(apiInformation);
						Gson gson = new Gson();

						ApiRandom[] apiResult = gson.fromJson(apiInformation.toString(), ApiRandom[].class);

						for (ApiRandom x : apiResult) {

							try {
								System.out.println(" ***************************** " + "|");
								System.out.println("Common : " + x.getName().getCommon());
								System.out.println("Official : " + x.getName().getOfficial());
								System.out.println(
										"eng Official : " + x.getName().getNativeName().getEng().getOfficial());
								System.out.println("eng Common : " + x.getName().getNativeName().getEng().getCommon());
								System.out.println("Tld : " + x.getTld()[0]);
								System.out.println("Cca2 : " + x.getCca2());
								System.out.println("Cca3 : " + x.getCca3());
								System.out.println("Ccn3 : " + x.getCcn3());
								System.out.println("Cioc : " + x.getCioc());
								System.out.println("Independent : " + x.getIndependent());
								System.out.println("Status : " + x.getStatus());
								System.out.println("UnMember : " + x.getUnMember());
								System.out.println("XCD Name : " + x.getCurrencies().getXCD().getName());
								System.out.println("XCD Symbol : " + x.getCurrencies().getXCD().getSymbol());
								System.out.println("Idd Root : " + x.getIdd().getRoot());
								System.out.println("Idd Suffixes : " + x.getIdd().getSuffixes()[0]);
								System.out.println("Capital : " + x.getCapital()[0]);
								System.out.println("AltSpellings : " + x.getAltSpellings()[0]);
								System.out.println("AltRegion : " + x.getRegion());
								System.out.println("AltSubregion : " + x.getSubregion());
								System.out.println("Languages eng : " + x.getLanguages().getEng());
								System.out.println("Ara Common : " + x.getTranslations().getAra().getCommon());
								System.out.println("Ara Official : " + x.getTranslations().getAra().getOfficial());
								System.out.println("bre Common : " + x.getTranslations().getBre().getCommon());
								System.out.println("bre Official : " + x.getTranslations().getBre().getOfficial());
								System.out.println("ces Common : " + x.getTranslations().getCes().getCommon());
								System.out.println("ces Official : " + x.getTranslations().getCes().getOfficial());
								System.out.println("cym Common : " + x.getTranslations().getCym().getCommon());
								System.out.println("cym Official : " + x.getTranslations().getCym().getOfficial());
								System.out.println("Latlng : " + x.getLatlng()[0]);
								System.out.println("Landlocked : " + x.getLandlocked());
								System.out.println("Area : " + x.getArea());
								System.out.println("Demonyms Eng F : " + x.getDemonyms().getEng().getF());
								System.out.println("Demonyms Eng M : " + x.getDemonyms().getEng().getM());
								System.out.println("Demonyms Fra F : " + x.getDemonyms().getFra().getF());
								System.out.println("Demonyms Fra M : " + x.getDemonyms().getFra().getM());
								System.out.println("Flag : " + x.getFlag());
								System.out.println("Maps GoogleMaps : " + x.getMaps().getGoogleMaps());
								System.out.println("Maps OpenStreetMaps : " + x.getMaps().getOpenStreetMaps());
								System.out.println("Population : " + x.getPopulation());
								System.out.println("Fifa : " + x.getFifa());
								System.out.println("Car Signs : " + x.getCar().getSigns()[0]);
								System.out.println("Car Side : " + x.getCar().getSide());
								System.out.println("Timezones : " + x.getTimezones()[0]);
								System.out.println("Continents : " + x.getContinents()[0]);
								System.out.println("Flags Png : " + x.getFlags().getPng());
								System.out.println("Flags Svg : " + x.getFlags().getSvg());
								System.out.println("CoatOfArms Png : " + x.getCoatOfArms().getPng());
								System.out.println("CoatOfArms Svg : " + x.getCoatOfArms().getSvg());
								System.out.println("StartOfWeek : " + x.getStartOfWeek());
								System.out.println("CapitalInfo Latlng : " + x.getCapitalInfo().getLatlng()[0]);
								System.out.println("|" + " ***************************** " + "|");
							} catch (Exception e) {
							}

						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
				break;

			case 2:
				String urld = "jdbc:sqlserver://localhost:1433;databaseName=ApiRandom;encrypt=true;trustServerCertificate=true";
				String user = "sa";
				String pass = "root";
				String sqlDB = "CREATE TABLE ApiRandom " + "(id INTEGER Identity(1,1)," + "common TEXT, "
						+ "official TEXT, " + "tld VARCHAR(20), " + "independent VARCHAR(5) CHECK (independent in('true','false')) NOT NULL, " + "status TEXT ,"
						 + "region VARCHAR(50)" + ",languages VARCHAR(50)"
						+ ",flag TEXT" + ",maps TEXT" + ",startOfWeek VARCHAR(20)" + " PRIMARY KEY ( id ))";

				Connection conn = null;
				try {

					Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
							.newInstance();
					DriverManager.registerDriver(driver);
					conn = DriverManager.getConnection(urld, user, pass);

					Statement st = conn.createStatement();

					int m = st.executeUpdate(sqlDB);
					if (m >= 1) {
						System.out.println("Created table in given database...");

					} else {
						System.out.println(" table already Created in given database...");
					}
					conn.close();
				}

				catch (Exception ex) {
					System.err.println(ex);
				}

				break;

			case 3:
				String urld1 = "jdbc:sqlserver://localhost:1433;databaseName=ApiRandom;encrypt=true;trustServerCertificate=true";
				String user1 = "sa";
				String pass1 = "root";
				URL urll;
				try {
					urll = new URL("https://restcountries.com/v3.1/all");

					HttpURLConnection connn = (HttpURLConnection) urll.openConnection();
					connn.setRequestMethod("GET");
					connn.connect();
					StringBuilder apiInformation = new StringBuilder();
					int responseCode = connn.getResponseCode();
					if (responseCode != 200) {
						throw new RuntimeException("HttpresponseCode");

					} else {
						Scanner scanner = new Scanner(urll.openStream());
						while (scanner.hasNext()) {
							apiInformation.append(scanner.nextLine());
						}
						scanner.close();
//					System.out.println(apiInformation);
						Gson gson = new Gson();

						ApiRandom[] apiResult = gson.fromJson(apiInformation.toString(), ApiRandom[].class);
						Connection insertConn = null;
						Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
								.newInstance();
						DriverManager.registerDriver(driver);
						insertConn = DriverManager.getConnection(urld1, user1, pass1);
						for (ApiRandom x : apiResult) {

							String sqlDBInsert = "INSERT INTO ApiRandom (common, official, tld, independent, status, region, languages, flag, maps ,startOfWeek)VALUES('"
									+ x.getName().getCommon() + "','" + x.getName().getOfficial() + "','"
									+ x.getTld()[0] + "','" + x.getIndependent() + "','" + x.getStatus()
									+ "','"+ x.getRegion() + "','" + x.getLanguages().getEng() + "','" + x.getFlags().getPng()
									+ "','" + x.getMaps().getGoogleMaps() + "','" + x.getStartOfWeek() + "')";

							System.out.println(sqlDBInsert);

							Statement st = insertConn.createStatement();

							int m = st.executeUpdate(sqlDBInsert);
							if (m >= 1) {
								System.out.println("inserted in given database...");

							} else {
								System.out.println(" data already inserted in given database...");
							}
							
						}
						insertConn.close();
					}
				} catch (Exception ex) {
					System.err.println(ex);
				}
//	
				break;

			case 4:
				System.out.println(" Enter id ?");
				long id = scannerr.nextInt();

					api.selectById(id);
					

				break;

			case 5:
				System.out.println(" Enter id ?");
				long updateid = scannerr.nextInt();
				api.UpdateById(updateid);

				break;

			case 6:
//				System.out.println(" Enter id to be deleted ?");
//				  int deleteId = scannerr.nextInt();
//				  api.deleteById(deleteId);

				break;

			}
		}

	}

}
