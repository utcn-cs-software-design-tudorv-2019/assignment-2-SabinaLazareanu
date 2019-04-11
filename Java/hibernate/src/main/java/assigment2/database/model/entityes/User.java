package assigment2.database.model.entityes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	@Column
	private String address;

	@Column
	private String PNC;
	
	@Column
	private String ICN;

	public Long getIdUser() {
		return id;
	}

	public void setIdUser(Long idUser) {
		this.id = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPNC() {
		return PNC;
	}

	public void setPNC(String pNC) {
		PNC = pNC;
	}

	public String getICN() {
		return ICN;
	}

	public void setICN(String iCN) {
		ICN = iCN;
	}

	@Override
	public String toString() {
		return "User [idUser=" + id + ", name=" + name + ", address=" + address + ", PNC=" + PNC + ", ICN=" + ICN
				+ "]";
	}

}
