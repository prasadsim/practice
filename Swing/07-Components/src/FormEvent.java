import java.util.EventObject;

public class FormEvent extends EventObject {

	private String name, occupation, empCat, taxId, gender;
	private int ageCategory;
	private boolean isCiziten;

	public FormEvent(Object o) {
		super(o);

	}

	public FormEvent(Object source, String name, String occupation, int ageCategory, String empCat, String taxId,
			boolean isCiziten, String gender) {
		super(source);
		this.name = name;
		this.occupation = occupation;
		this.ageCategory = ageCategory;
		this.empCat = empCat;
		this.taxId = taxId;
		this.isCiziten = isCiziten;
		this.gender = gender;

	}

	public String getGender() {
		return gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public int getAgeCategory() {
		return ageCategory;
	}

	public String getEmpCat() {
		return empCat;
	}

	public String getTaxId() {
		return taxId;
	}

	public boolean getIsCiziten() {
		return isCiziten;
	}

}
