
package com.org.model;

import java.io.Serializable;

/**
 * A Renseigner.
 * @author  : mmenhour
 * @project : model
 * @package : com.org.model
 * @date    : 4 sept. 2016 13:44:48
 */
public class PersonModel implements Serializable
{
   
   /**
    * 
    */
   private static final long serialVersionUID = -2924640401880955911L;
   
   private Integer           id;
   
   private String            firstName;
   
   private String            lastName;
   
   private String            email;
   
   /**
    * @return the id
    */
   public Integer getId()
   {
      return id;
   }
   
   /**
    * @param id the id to set
    */
   public void setId( Integer id )
   {
      this.id = id;
   }
   
   /**
    * @return the firstName
    */
   public String getFirstName()
   {
      return firstName;
   }
   
   /**
    * @param firstName the firstName to set
    */
   public void setFirstName( String firstName )
   {
      this.firstName = firstName;
   }
   
   /**
    * @return the lastName
    */
   public String getLastName()
   {
      return lastName;
   }
   
   /**
    * @param lastName the lastName to set
    */
   public void setLastName( String lastName )
   {
      this.lastName = lastName;
   }
   
   /**
    * @return the email
    */
   public String getEmail()
   {
      return email;
   }
   
   /**
    * @param email the email to set
    */
   public void setEmail( String email )
   {
      this.email = email;
   }
   
   /**
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString()
   {
      return "PersonModel [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
   }
   
   /**
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ( ( email == null ) ? 0 : email.hashCode() );
      result = prime * result + ( ( firstName == null ) ? 0 : firstName.hashCode() );
      result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
      result = prime * result + ( ( lastName == null ) ? 0 : lastName.hashCode() );
      return result;
   }
   
   /**
    * @see java.lang.Object#equals(java.lang.Object)
    */
   @Override
   public boolean equals( Object obj )
   {
      if( this == obj ) return true;
      if( obj == null ) return false;
      if( getClass() != obj.getClass() ) return false;
      PersonModel other = (PersonModel) obj;
      if( email == null )
      {
         if( other.email != null ) return false;
      }
      else if( !email.equals( other.email ) ) return false;
      if( firstName == null )
      {
         if( other.firstName != null ) return false;
      }
      else if( !firstName.equals( other.firstName ) ) return false;
      if( id == null )
      {
         if( other.id != null ) return false;
      }
      else if( !id.equals( other.id ) ) return false;
      if( lastName == null )
      {
         if( other.lastName != null ) return false;
      }
      else if( !lastName.equals( other.lastName ) ) return false;
      return true;
   }
}
