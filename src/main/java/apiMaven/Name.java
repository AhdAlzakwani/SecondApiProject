package apiMaven;

public class Name {
	String common;
	String official;
	public String getCommon() {
		return common;
	}
	public void setCommon(String common) {
		this.common = common;
	}
	public String getOfficial() {
		return official;
	}
	public void setOfficial(String official) {
		this.official = official;
	}
	public nativeName getNativeName() {
		return nativeName;
	}
	public void setNativeName(nativeName nativeName) {
		this.nativeName = nativeName;
	}
	nativeName nativeName;

}
