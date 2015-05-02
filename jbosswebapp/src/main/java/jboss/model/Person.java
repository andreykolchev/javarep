package jboss.model;

import javax.persistence.Entity;

import java.io.Serializable;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import java.lang.Override;
import java.sql.Date;

@SuppressWarnings("serial")
@Entity
@Table(name = "person")
public class Person implements Serializable
{

	@Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   @Column(name = "id", updatable = false, nullable = false)
	   private Long id;
	   @Version
	   @Column(name = "version")
	   private int version;

	   @Column(length = 50, name = "name")
	   @NotNull
	   private String name;

	   @Column(length = 50, name = "surname")
	   @NotNull
	   private String surname;

	   @Column(length = 50, name = "patronymic")
	   @NotNull
	   private String patronymic;

	   @Column(name = "birsday")
	   @NotNull
	   private Date birsday;

	   public Long getId()
	   {
	      return this.id;
	   }

	   public void setId(final Long id)
	   {
	      this.id = id;
	   }

	   public int getVersion()
	   {
	      return this.version;
	   }

	   public void setVersion(final int version)
	   {
	      this.version = version;
	   }

	   public String getName()
	   {
	      return name;
	   }

	   public void setName(String name)
	   {
	      this.name = name;
	   }

	   public String getSurname()
	   {
	      return surname;
	   }

	   public void setSurname(String surname)
	   {
	      this.surname = surname;
	   }

	   public String getPatronymic()
	   {
	      return patronymic;
	   }

	   public void setPatronymic(String patronymic)
	   {
	      this.patronymic = patronymic;
	   }

	   public Date getBirsday()
	   {
	      return birsday;
	   }

	   public void setBirsday(Date birsday)
	   {
	      this.birsday = birsday;
	   }

	   @Override
	   public boolean equals(Object obj)
	   {
	      if (this == obj)
	      {
	         return true;
	      }
	      if (!(obj instanceof Person))
	      {
	         return false;
	      }
	      Person other = (Person) obj;
	      if (id != null)
	      {
	         if (!id.equals(other.id))
	         {
	            return false;
	         }
	      }
	      return true;
	   }

	   @Override
	   public int hashCode()
	   {
	      final int prime = 31;
	      int result = 1;
	      result = prime * result + ((id == null) ? 0 : id.hashCode());
	      return result;
	   }

	   @Override
	   public String toString()
	   {
	      String result = getClass().getSimpleName() + " ";
	      if (name != null && !name.trim().isEmpty())
	         result += "name: " + name;
	      if (surname != null && !surname.trim().isEmpty())
	         result += ", surname: " + surname;
	      if (patronymic != null && !patronymic.trim().isEmpty())
	         result += ", last_name: " + patronymic;
	      return result;
	   }
}