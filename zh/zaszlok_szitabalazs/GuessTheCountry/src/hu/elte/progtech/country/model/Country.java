package hu.elte.progtech.country.model;

public class Country {

	private String name;
	private String imageFile;

	public Country(String name, String imageFile) {
		this.name = name;
		this.imageFile = imageFile;
	}

	public String getName() {
		return name;
	}

	public String getImageFile() {
		return imageFile;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
