package apiMaven;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ApiRandom {


	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public String[] getTld() {
		return tld;
	}
	public void setTld(String[] tld) {
		this.tld = tld;
	}
	public String getCca2() {
		return cca2;
	}
	public void setCca2(String cca2) {
		this.cca2 = cca2;
	}
	public String getCcn3() {
		return ccn3;
	}
	public void setCcn3(String ccn3) {
		this.ccn3 = ccn3;
	}
	public String getCca3() {
		return cca3;
	}
	public void setCca3(String cca3) {
		this.cca3 = cca3;
	}
	public String getCioc() {
		return cioc;
	}
	public void setCioc(String cioc) {
		this.cioc = cioc;
	}
	public boolean getIndependent() {
		return independent;
	}
	public void setIndependent(boolean independent) {
		this.independent = independent;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUnMember() {
		return unMember;
	}
	public void setUnMember(String unMember) {
		this.unMember = unMember;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getSubregion() {
		return subregion;
	}
	public void setSubregion(String subregion) {
		this.subregion = subregion;
	}
	public boolean getLandlocked() {
		return landlocked;
	}
	public void setLandlocked(boolean landlocked) {
		this.landlocked = landlocked;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public String getFifa() {
		return fifa;
	}
	public void setFifa(String fifa) {
		this.fifa = fifa;
	}
	public String getStartOfWeek() {
		return startOfWeek;
	}
	public void setStartOfWeek(String startOfWeek) {
		this.startOfWeek = startOfWeek;
	}
	public currencies getCurrencies() {
		return currencies;
	}
	public void setCurrencies(currencies currencies) {
		this.currencies = currencies;
	}
	public Idd getIdd() {
		return idd;
	}
	public void setIdd(Idd idd) {
		this.idd = idd;
	}
	public String[] getCapital() {
		return capital;
	}
	public void setCapital(String[] capital) {
		this.capital = capital;
	}
	public String[] getAltSpellings() {
		return altSpellings;
	}
	public void setAltSpellings(String[] altSpellings) {
		this.altSpellings = altSpellings;
	}
	public languages getLanguages() {
		return languages;
	}
	public void setLanguages(languages languages) {
		this.languages = languages;
	}
	public float[] getLatlng() {
		return latlng;
	}
	public void setLatlng(float[] latlng) {
		this.latlng = latlng;
	}
	public demonyms getDemonyms() {
		return demonyms;
	}
	public void setDemonyms(demonyms demonyms) {
		this.demonyms = demonyms;
	}
	public maps getMaps() {
		return maps;
	}
	public void setMaps(maps maps) {
		this.maps = maps;
	}
	public car getCar() {
		return car;
	}
	public void setCar(car car) {
		this.car = car;
	}
	public String[] getTimezones() {
		return timezones;
	}
	public void setTimezones(String[] timezones) {
		this.timezones = timezones;
	}
	public String[] getContinents() {
		return continents;
	}
	public void setContinents(String[] continents) {
		this.continents = continents;
	}
	public flags getFlags() {
		return flags;
	}
	public void setFlags(flags flags) {
		this.flags = flags;
	}
	public coatOfArms getCoatOfArms() {
		return coatOfArms;
	}
	public void setCoatOfArms(coatOfArms coatOfArms) {
		this.coatOfArms = coatOfArms;
	}
	public capitalInfo getCapitalInfo() {
		return capitalInfo;
	}
	public void setCapitalInfo(capitalInfo capitalInfo) {
		this.capitalInfo = capitalInfo;
	}
	public translations getTranslations() {
		return translations;
	}
	public void setTranslations(translations translations) {
		this.translations = translations;
	}
	String region;
	String subregion;
	boolean landlocked;
	double area;
	String flag;
	Integer population;
	String fifa;
	String startOfWeek;
	currencies currencies;
	Idd idd;
	String[] capital;
	String[] altSpellings;
	languages languages;
	float[] latlng;
	demonyms demonyms;
	maps maps;
	car car;
	String[] timezones;
	String[] continents;
	flags flags;
	coatOfArms coatOfArms;
	capitalInfo capitalInfo;
	translations translations;
	Name name;
	String[] tld;
	String cca2;
	String ccn3;
	String cca3;
	String cioc;
	boolean independent;
	String status;
	String unMember;
	
	public static void selectById(Long number) {
		Scanner scanner = new Scanner(System.in);
		String selectUrl = "jdbc:sqlserver://localhost:1433;databaseName=ApiRandom;encrypt=true;trustServerCertificate=true";
		String selectUser = "sa";
		String selectPass = "root";
		String SelectSqlDB = "SELECT * FROM ApiRandom where id=" + number;
		Connection connection = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			connection = DriverManager.getConnection(selectUrl, selectUser, selectPass);

			Statement st = connection.createStatement();

			ResultSet m = st.executeQuery(SelectSqlDB);

			if (m.next()) {

				do {

					System.out.println(" ***************************** " + "|");
					System.out.println("id : " + m.getInt(1));
					System.out.println("common NAME : " + m.getString(2));
					System.out.println("oFFICIAL name : " + m.getString(3));
					System.out.println("TLD : " + m.getString(4));
					System.out.println("indepandent : " + m.getString(5));
					System.out.println("Status : " + m.getString(6));
					System.out.println("Region : " + m.getString(7));
					System.out.println("language : " + m.getString(8));
					System.out.println("Flag : " + m.getString(9));
					System.out.println("Maps : " + m.getString(10));
					System.out.println("StartOfWeek : " + m.getString(11));
					System.out.println(" ***************************** " + "|");

				} while (m.next());

			} else {
				System.out.println("No such user id is already registered");
			}

			connection.close();
		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}

	public static void UpdateById(Long number) {
		try{
		Scanner scanner = new Scanner(System.in);
		String selectUrl = "jdbc:sqlserver://localhost:1433;databaseName=ApiRandom;encrypt=true;trustServerCertificate=true";
		String selectUser = "sa";
		String selectPass = "root";
		System.out.println(" Enter common to update ?");
		String common = scanner.next();
		System.out.println(" Enter languages to update ?");
		String languages = scanner.next();
		String SelectSqlDB = "Update ApiRandom SET common='"+common+"',languages='"+languages+"'where id=" + number;
		Connection conn = null;

		Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection(selectUrl, selectUser, selectPass);

		Statement st = conn.createStatement();

		int m = st.executeUpdate(SelectSqlDB);

		if (m >= 1) {
			System.out.println("Values updated in given Table...");

		} else {
			System.out.println("Values already updated in given database...");
		}

		conn.close();
		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}
	
	public static void deleteById(long id) {
		Scanner scanner = new Scanner(System.in);
		String url = "jdbc:sqlserver://localhost:1433;databaseName=ApiRandom;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		
		String sqlDB = "delete from ApiRandom where id ="+id;
		Connection conn = null;
	try {
		Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection(url, user, pass);

		Statement st = conn.createStatement();

		int m = st.executeUpdate(sqlDB);

		if (m >= 1) {
			System.out.println("Row Deleted in given Table...");

		} else {
			System.out.println(" Row already Deleted in given database...");
		}

		conn.close();
		  

	} catch (Exception ex) {
		System.err.println(ex);
	}
	}	
	
	
	
	
	
	
	
}
