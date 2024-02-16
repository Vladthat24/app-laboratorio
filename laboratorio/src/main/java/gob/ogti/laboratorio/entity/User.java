package gob.ogti.laboratorio.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ogti_laboratorio_user")
public class User implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3019787586293798172L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	@Column 
	private String firstName;
	@Column 
	private String lastName;
	@Column(unique = true) 
	private String email;
	@Column(unique = true) 
	private String username;
	@Column
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codEstablecimiento", referencedColumnName = "codEstablecimiento")
	private Establecimiento establecimiento;
	
	@Column
	private int estado;
	
	@Column(name="usuario_reg")
	private String usuarioRegU;
	
	@Column(name="fecha_reg")
	private Timestamp fechaRegU;
	
	@Column(name="usuario_mod")
	private String usuarioModU;
	
	@Column(name="fecha_mod")
	private Timestamp fechaModU;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ogti_laboratorio_user_roles",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="role_id"))
	
	private Set<Role> roles;
	
	@Transient 
	private String confirmPassword;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Establecimiento getEstablecimiento() {
		return establecimiento;
	}

	public void setEstablecimiento(Establecimiento establecimiento) {
		this.establecimiento = establecimiento;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getUsuarioRegU() {
		return usuarioRegU;
	}

	public void setUsuarioRegU(String usuarioRegU) {
		this.usuarioRegU = usuarioRegU;
	}

	public Timestamp getFechaRegU() {
		return fechaRegU;
	}

	public void setFechaRegU(Timestamp fechaRegU) {
		this.fechaRegU = fechaRegU;
	}

	public String getUsuarioModU() {
		return usuarioModU;
	}

	public void setUsuarioModU(String usuarioModU) {
		this.usuarioModU = usuarioModU;
	}

	public Timestamp getFechaModU() {
		return fechaModU;
	}

	public void setFechaModU(Timestamp fechaModU) {
		this.fechaModU = fechaModU;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", establecimiento=" + establecimiento
				+ ", estado=" + estado + ", usuarioRegU=" + usuarioRegU + ", fechaRegU=" + fechaRegU + ", usuarioModU="
				+ usuarioModU + ", fechaModU=" + fechaModU + ", roles=" + roles + ", confirmPassword=" + confirmPassword
				+ "]";
	}

	

	


}
